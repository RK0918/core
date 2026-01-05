// 원래는 MemoryMemberRepository도 따로 패키지를 만들어서 빼놓는게 좋지만
// 복잡해질 수 있으니 member 패키지에 생성

package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    // 원래는 동시성 이슈 때문에 CurrentHashMap을 써야 좋음.
    private static final Map<Long, Member> store = new HashMap<>();
    // memory이므로 단 하나 존재하는 저장소로 만들기 위해 static
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);


    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
