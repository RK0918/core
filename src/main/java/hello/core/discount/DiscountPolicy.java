package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*
    * @return 할인 대상 금액, 얼마나 할인됐는지 리턴
    -> 이거에 대한 구현체 생성(FixDiscountPolicy)
    */
    int discount(Member member, int price );

}
