package smartlocation.contracker.repository;

import smartlocation.contracker.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryMemberRepository {

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setMemberId(++sequence);
        store.put(member.getMemberId(), member);
        return member;
    }

    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long memberId, Member updateParam) {
        Member findMember = findById(memberId);
        findMember.setMemberName(updateParam.getMemberName());
        findMember.setMemberPhoneNumber(updateParam.getMemberPhoneNumber());
    }

    public void clearStore() {
        store.clear();
    }
}
