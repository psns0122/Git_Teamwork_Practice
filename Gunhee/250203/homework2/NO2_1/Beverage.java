package day01.homework2.NO2_1;

public abstract class Beverage {
    // 생성자
    public Beverage(String name) {
        this.name = name;
    }

    // 추상 메소드
    // 추상 메소드는 추상 클래스에서 구현하면 안됨 ({} 없어야함)
    public abstract void calcPrice();

    // 멤버 메소드
    public void print() {
        System.out.println(this.name + "이며, 가격은 " + this.price);
    }

    // 멤버 변수
    private String name;
    protected int price;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
