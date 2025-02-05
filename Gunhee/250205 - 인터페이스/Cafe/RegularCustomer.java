package day03.Cafe;

public class RegularCustomer extends Customer implements Order {
    // 생성자
    RegularCustomer(String name, double balance, String myFavorite) {
        super(name, balance);
        this.myFavorite = myFavorite;
    }

    // 추상 메소드 오버라이딩
    @Override
    public String makeOrder() {
        return this.myFavorite;
    }

    // 멤버 변수
    private String myFavorite;

    public String getMyFavorite() {
        return myFavorite;
    }

    public void setMyFavorite(String myFavorite) {
        this.myFavorite = myFavorite;
    }
}
