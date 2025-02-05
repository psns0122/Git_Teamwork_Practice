package NO2;

// implements : 실행하다, 구현하다
// class Payment implements Payable : Payment 클래스는 Payable을 구현한다.

import java.net.ProtocolException;

// 상속(extends) : 기존의 것을 확장하는 개념
// 인터페이스(implements) : 설계(계획)을 실제로 구현하는 개념
//      -> Payable 계획에 따라 Payment 클래스를 구현하시오.
//      -> Payment 클래스는 Payable 계획에 따라 구현되었다.
// 추상 클래스(abstract) : 상속과 인터페이스의 중간 개념
//      -> 기존의 것을 확장하는데 일정한 계획에 따라 확장을 구현
public abstract class Payment implements Payable {
    protected String shopName;
    protected String productName;
    protected long productPrice;

    // 생성자
    public Payment(String shopName, String productName, long productPrice) {
        this.shopName = shopName;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // 추상 클래스는 인터페이스의 추상 메소드(pay())를 구현할 의무가 없다.
    // 대신 추상 클래스를 상속받는 일반 클래스가 구현의 의무를 진다.
    // 인터페이스(계획, 설계) -> 추상 클래스(미완성된 구현, 확장 가능성 보유) -> 일반 클래스(최종 구현)
}
