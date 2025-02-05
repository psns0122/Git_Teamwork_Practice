package day01.homework2.NO2_2;

public abstract class Content {
    // 생성자
    Content () {}
    Content (String title) {
        this.title = title;
    }

    // 추상 메소드
    abstract void totalPrice();

    // 멤버 메소드
    void show() {
        System.out.println(this.title + " 비디오의 가격은 " + this.price + "원 입니다.");
    }

    // 멤버 변수
    String title;
    int price;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
