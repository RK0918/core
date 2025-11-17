package hello.core.order;


// 1. 주문생성
// -회원id, 상품명, 회원 가격 을 파라미터로 넘겨야됨.
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
