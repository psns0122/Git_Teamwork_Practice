package day03.Cafe;

public class Owner {
    void giveItem(Order menu) {
        String beverage = menu.makeOrder();
        System.out.println("주문하신 " + beverage + " 나왔습니다.");
    }
}
