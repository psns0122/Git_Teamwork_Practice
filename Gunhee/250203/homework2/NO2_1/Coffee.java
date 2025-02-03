package day01.homework2.NO2_1;

public class Coffee extends Beverage {
    // 생성자
    public Coffee (String name) {
        // 부모 클래스 생성자 호출
        super(name);
        Coffee.amount++;
        this.calcPrice();
    }

    // 추상 메소드 오버라이딩
    @Override
    public void calcPrice() {
        switch(this.getName()) {
            case "Americano":
                this.price = 1500;
                break;
            case "CafeLatte":
                this.price = 2500;
                break;
            case "Cappuccino":
                this.price = 3000;
                break;
        }
    }

    // 멤버 변수
    static int amount;
    public int getAmount() {
        return Coffee.amount;
    }

    public void setAmount(int amount) {
        Coffee.amount = amount;
    }

}
