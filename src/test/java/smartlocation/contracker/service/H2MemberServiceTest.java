package smartlocation.contracker.service;

import smartlocation.contracker.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 예외 누수 문제 해결
 * SQLException 제거
 *
 * MemberRepository 인터페이스 의존
 */
@Slf4j
@SpringBootTest
class H2MemberServiceTest {

    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_EX = "ex";

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @TestConfiguration
    static class TestConfig {

        private final DataSource dataSource;

        TestConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        MemberRepository memberRepository() {
            return new H2MemberRepository(dataSource);
        }

        @Bean
        MemberService H2memberService() {
            return new MemberService(memberRepository());
        }

    }

    @AfterEach
    void after() {

    }

//
//    @Test
//    @DisplayName("정상 이체")
//    void accountTransfer() {
//        //given
//        Member memberA = new Member(MEMBER_A, 10000);
//        Member memberB = new Member(MEMBER_B, 10000);
//        memberRepository.save(memberA);
//        memberRepository.save(memberB);
//
//        //when
//        memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);
//
//        //then
//        Member findMemberA = memberRepository.findById(memberA.getMemberId());
//        Member findMemberB = memberRepository.findById(memberB.getMemberId());
//        assertThat(findMemberA.getMoney()).isEqualTo(8000);
//        assertThat(findMemberB.getMoney()).isEqualTo(12000);
//    }
//
//    @Test
//    @DisplayName("이체중 예외 발생")
//    void accountTransferEx() {
//        //given
//        Member memberA = new Member(MEMBER_A, 10000);
//        Member memberEX = new Member(MEMBER_EX, 10000);
//        memberRepository.save(memberA);
//        memberRepository.save(memberEX);
//
//        //when
//        assertThatThrownBy(() -> memberService.accountTransfer(memberA.getMemberId(), memberEX.getMemberId(), 2000))
//                .isInstanceOf(IllegalStateException.class);
//
//
//        //then
//        Member findMemberA = memberRepository.findById(memberA.getMemberId());
//        Member findMemberB = memberRepository.findById(memberEX.getMemberId());
//        assertThat(findMemberA.getMoney()).isEqualTo(10000);
//        assertThat(findMemberB.getMoney()).isEqualTo(10000);
//    }
}