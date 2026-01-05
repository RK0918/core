// Grade(enum) 등급 설정
// Member(클래스) 멤버 객체 생성
// MemberRepository(인터페이스) 생성, 이 인터페이스는 세 번째
// MemoryMemberRepository 구현체(클래스) 생성
// MemberService 인터페이스 생성
package hello.core.member;

public interface MemberRepository {
// MemeberRepository에선 어떤 구현체를 이용해서 회원저장소에 저장할지
// 인터페이스 생성
    // 회원 가입
    void save(Member member);
    // 회원 조회
    Member findById(Long memberId);
}
