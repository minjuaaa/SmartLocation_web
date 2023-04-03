package smartlocation.contracker.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import smartlocation.contracker.domain.Member;

import javax.sql.DataSource;

@Slf4j
public class H2MemberRepository implements MemberRepository {

    private final JdbcTemplate template;

    public H2MemberRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(member_id, member_name, member_phonenumber) values (?, ?, ?)";
        template.update(sql, member.getMemberId(), member.getMemberName(), member.getMemberPhoneNumber());
        return member;
    }

    @Override
    public Member findById(Long memberId) {
        String sql = "select * from member where member_id = ?";
        return template.queryForObject(sql, memberRowMapper(), memberId);
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setMemberId(rs.getLong("member_id"));
            member.setMemberName(rs.getString("member_name"));
            member.setMemberPhoneNumber(rs.getString("member_phoneNumber"));
            return member;
        };
    }

    @Override
    public void update(Long memberId, String memberName, String memberPhoneNumber) {
        String sql = "update member set memberName=?, memberPhoneNumber=? where member_id=?";
        template.update(sql, memberName, memberPhoneNumber, memberId);
    }

    @Override
    public void delete(Long memberId) {
        String sql = "delete from member where member_id=?";
        template.update(sql, memberId);
    }

}
