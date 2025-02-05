package NO2;

public class CashPayment extends Payment {
    private String cashRecelptNumber;

    // 생성자
    CashPayment(String shopName, String productName, long productPrice,
                String cashRecelptNumber) {
        super(shopName, productName, productPrice);
        this.cashRecelptNumber = cashRecelptNumber;
    }

    // (인터페이스->추상클래스)로 전달받은 추상 메소드 오버라이딩
    @Override
    public void pay() throws PayException {
        if (this.productPrice <= 0) {
            throw new PayException("가격이 잘못되었습니다.");
        }
    }

    // 객체명을 이용해 문자열 출력을 하기 위한 함수
    @Override
    public String toString() {
        return "현금이 정상적으로 지불되었습니다.\n" +
                "[ 현금 결제 정보 ]\n" +
                "상점명 : " + this.shopName + "\n" +
                "상품명 : " + this.productName + "\n" +
                "상품가격 : " + this.productPrice + "\n" +
                "현금영수증번호 : " + this.cashRecelptNumber;
    }

}
