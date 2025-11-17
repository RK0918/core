// Grade(enum) 등급 설정
// Member(클래스) 멤버 객체 생성
// MemberRepository(인터페이스) 생성, 이 인터페이스는 세 번째
// MemoryMemberRepository 구현체(클래스) 생성
// MemberService 인터페이스 생성
// MemberServiceImpl 생성
package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl이 MemberRepository 인터페이스에만 의존해야 하는데,
    // 직접 new MemoryMemberRepository()로 구체 클래스(구현체)를 의존하고 있다는 점이에요.
    // 즉, 코드 상에서 이미 MemoryMemberRepository에 강하게 결합
    // 아래 코드 참고(강한결합)
    // private final MemberRepository memberRepository = new MemoryMemberRepository();


    // 아래 코드에선 더 이상 MemoryMemberRepository가 없음. 구현체를 의존x(강한결합x)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        // 생성자를 통해서 이 멤버리포지토리에 어떤 구현체가 들어갈지 정해줌. -> 그리고 AppConfig 설정클래스를 통해
        // AppConfig로 이동하면

    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // join에서 save를 호출하면 다형성에 의해 MemoryMemberRepository에 있는 인터페이스(MemberRepository)가
        // 아니라 이 MemoryMemberRepository에 있는 save가 오버라이딩된 게 호출
        // +추가설명 :
        // memberRepository의 타입 선언은 인터페이스 MemberRepository
        //하지만 실제로는 new MemoryMemberRepository() 객체가 들어가 있음
        //즉, **참조 변수 타입(왼쪽)**은 인터페이스지만, **실제 생성된 객체(오른쪽)**는 구현체입니다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스팅 용도(싱글톤)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
