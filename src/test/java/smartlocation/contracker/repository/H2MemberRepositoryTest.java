package smartlocation.contracker.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smartlocation.contracker.domain.Member;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static smartlocation.contracker.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class H2MemberRepositoryTest {

    H2MemberRepository repository;

    Member member;

    @BeforeEach
    void beforeEach() {
        //기본 DriverManager - 항상 새로운 커넥션을 획득
//        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);

        //커넥션 풀링
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new H2MemberRepository(dataSource);
    }

//    @AfterEach
//    void after() {
//        repository.delete(member.getMemberId());
//    }


    @Test
    void crud() {
        log.info("start");

        //save
        Member member = new Member(8L,"정ㅁ진", "010-6715-5555");
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
//        assertThat(findMember).isEqualTo(member);

        //update
        repository.update(member.getMemberId(), "정무진","010-6715-5178");
        Member updatedMember = repository.findById(member.getMemberId());
        assertThat(updatedMember.getMemberPhoneNumber()).isEqualTo("010-6715-5178");

        //delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);

    }

    @Test
    void save() {
        Member member = new Member(5L,"정ㅁ진", "010-6715-5555");
        repository.save(member);

        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);
    }
}