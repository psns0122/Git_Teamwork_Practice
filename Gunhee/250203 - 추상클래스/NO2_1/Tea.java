package day01.homework2.NO2_1;

public class Tea extends Beverage {
    // 생성자
    public Tea (String name) {
        // 부모 클래스 생성자 호출
        super(name);
        Tea.amount++;
        this.calcPrice();
    }

    // 추상 메소드 오버라이딩
    @Override
    public void calcPrice() {
        switch(this.getName()) {
            case "LemonTea":
                this.price = 1500;
                break;
            case "ginsengTea":
                this.price = 2000;
                break;
            case "redginsengTea":
                this.price = 2500;
                break;
        }
    }

    // 멤버 변수
    static int amount;
    public int getAmount() {
        return Tea.amount;
    }

    public void setAmount(int amount) {
        Tea.amount = amount;
    }

}
