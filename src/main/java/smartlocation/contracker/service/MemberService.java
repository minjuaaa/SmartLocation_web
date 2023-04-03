package smartlocation.contracker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import smartlocation.contracker.repository.MemberRepository;

import java.sql.SQLException;

@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void Tdasdasdas(String memberId, String memberName, String memberPhoneNumber) throws SQLException {
            //비즈니스 로직 시작
                bizLogic(memberId, memberName, memberPhoneNumber);
    }

    private void bizLogic(String memberId, String memberName, String memberPhoneNumber) throws SQLException {

    }

}
