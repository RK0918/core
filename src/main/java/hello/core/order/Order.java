package hello.core.order;

public class Order {

    private Long MemberId;
    private String name;
    private int itemPrice;
    private int discountPrice;


    // 생성자
    // 객체를 한 번에 초기화하기 위해서
    // ex) new Order(1L, "itemA", 10000, 1000)
    public Order(Long memberId, String name, int itemPrice, int discountPrice) {
        MemberId = memberId;
        this.name = name;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    // 계산기
    public int calculatePrice() {
        return itemPrice-discountPrice;
    }

    // Getter / Setter

    // Getter : 저장된 값을 외부에서 읽을 때 사용
    //→ order.getItemPrice(), order.getName()
    //Setter : 값을 바꿀 때 사용
    //→ order.setItemPrice(12000)

    // 왜 생성자, Getter/Setter 둘 다 필요한가?
    //생성자만 있으면 객체 생성 시에만 값을 넣을 수 있고, 이후 값을 변경할 방법이 없음.
    //Setter만 있으면 객체 생성 후 new Order() 하고 setXXX()를 여러 번 호출해야 하므로, 잘못하면 필드 일부가 비어 있는 상태로 남을 수 있음.
    // 그래서 실무에서는 두 방식을 상황에 맞게 병행합니다.

    //반드시 필요한 값은 생성자로 강제
    //변경 가능해야 하는 값은 setter 제공
    //조회는 getter
    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPirce) {
        this.discountPrice = discountPirce;
    }


    // 자바에서 모든 클래스는 Object를 상속받는데
    // 이 객체를 출력할 때 보기 쉽게 하기 위해
    // Object 클래스의 toString() -> 인스턴스에 대한 정보를 문자열로 제공

    @Override
    public String toString() {
        return "Order{" +
                "MemberId=" + MemberId +
                ", name='" + name + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPirce=" + discountPrice +
                '}';
        // System.out.println("order = " + order);
        // -> 클래스명+해시코드로 출력돼서 보기 힘듦.
        // 오버라이딩한 toString()을 통해서 객체의 상태를 읽기 좋게 표현
    }
}
