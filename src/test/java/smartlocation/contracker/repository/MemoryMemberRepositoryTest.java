package smartlocation.contracker.repository;

import smartlocation.contracker.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("정무진","010-6715-5178");

        //when
        Member savedMember = memoryMemberRepository.save(member);

        //then
        Member findMember = memoryMemberRepository.findById(member.getMemberId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("정수연", "010-4045-5178");
        Member member2 = new Member("정혜리", "010-9089-5178");

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        //when
        List<Member> result = memoryMemberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

    @Test
    void update() {
        //given
        Member member = new Member("정무진", "010-6714-5178");

        Member savedMember = memoryMemberRepository.save(member);
        Long memberId = savedMember.getMemberId();

        //when
        Member updateParam = new Member("정무진", "010-6715-5178");
        memoryMemberRepository.update(memberId, updateParam);

        Member findMember = memoryMemberRepository.findById(memberId);

        //then
        assertThat(findMember.getMemberName()).isEqualTo(updateParam.getMemberName());
        assertThat(findMember.getMemberPhoneNumber()).isEqualTo(updateParam.getMemberPhoneNumber());

    }
}
