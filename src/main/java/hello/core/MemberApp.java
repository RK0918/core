package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // MemberService memberService = new MemberServiceImpl();
        // AppConfig에서 관리하게 되면서 위 코드가 아래 두 줄의 코드로 변경
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // AppConfig에 @Configuration, @Bean을 통해 스프링 컨테이너에 등록했으므로
        // 아래 코드로 다시 변경 -> 스프링 컨테이너 생성
        // ApplicationContext는 인터페이스이다. #ppt 참고
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfing를 담당하는 클래스명.calss
        // AppConfig에 등록되어 있는 MemberService memberService() 에서
        // memberService() -> 메서드명 -> memberService / MemberService->반환타입 -> MemberService.class
        // "memberService(메서드명)", MemberService.class(반환타입)
        // 최종적으로 아래 코드
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findeMember = memberService.findMember(1L);
        System.out.println("new member =" + member.getName());
        System.out.println("findmember =" + findeMember.getName());

    }
}
