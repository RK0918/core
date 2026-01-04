package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    // @Bean memberService -> new MemoryMemeberRepository()
    // @Bean orderService -> new MemoryMemeberRepository()
    // -> 그러면 싱글톤 깨지는 거 아님? 테스트해보자


    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository
    // => 이렇게 호출되어야 할 거 같지만?
    // ConfigurationSingletonTest.java에서 테스팅해보면

/*  call AppConfig.memberService
    call AppConfig.memberRepository => 한 번만 호출됨
    call AppConfig.orderService
    총 3번만 호출된다.=> 스프링이 빈을 관리하며 싱글톤을 보장해주
*/


    @Bean
    // MemberServiceImpl 클래스 이동하면 아래 생성자 덕분에
    //       Config 반환타입     Config 객체 이름
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
                                    // new MemoryMemberRepository()를 아래 MemoryMemberRepository 추가하여 리팩토링
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    // 멤버서비스 구현체(멤버Imp) 생성자에서
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()); // new FixDiscountPolicy()를 아래 코드를 추가하여 리팩토링
                                    // new MemoryMemberRepository() 의 중복이 제거됨. 메모리멤버레포지토리를 다른 구현체로 변경할 때 한 부분만 변경하면 됨
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
         return new RateDiscountPolicy();
    }
}
