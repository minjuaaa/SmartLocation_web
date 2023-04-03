package smartlocation.contracker.repository;

import smartlocation.contracker.domain.Member;

import java.util.List;


public interface MemberRepository {
    Member save(Member member);

    Member findById(Long memberId);

    void update(Long memberId, String memberName, String memberPhoneNumber);

    void delete(Long memberId);
}
