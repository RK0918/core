package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회
        Member member = memberRepository.findById(memberId);

        // orderserivce 입장에선 할인에 대한건 모르고 디스카운트팔러시 너가 알아서 해줘
        // -> 단일책임원칙(SRP) 잘지킴.
        // 회원 정보 조회를 했으니 그걸 할인 정책에 넘김
        // Grade만 넘길지 member를 넘길지는 프로젝트에 따라서(여기선 member를 넘김)

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    // 테스팅용도(싱글톤)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
