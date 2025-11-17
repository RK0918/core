package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl; // 더이상 구현체에 의존한 필요x
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl; // 더이상 구현체에 의존할 필요x
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        /*
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        마찬가지로 AppConfig에서 관리하므로 위 두 줄의 코드가 아래 세 줄로 변경
        */

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // memberApp과 마찬가지로 orderApp도 아래 코드로 다시 변경
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",
                OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order); // Order 구현체에서 toString 해놔서 문자열로 출력
    }
}

/*
결과
 order = Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}
할인 금액이 잘 출력되는 것을 확인할 수 있다.
애플리케이션 로직으로 이렇게 테스트 하는 것은 좋은 방법이 아니다. JUnit 테스트를 사용하자
* */