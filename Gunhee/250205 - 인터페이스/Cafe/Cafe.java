package day03.Cafe;

import java.util.ArrayList;

public class Cafe {
    public static void main(String[] args) {
        // Owner 클래스 만든 후
        Owner master = new Owner();
        master.giveItem(new Customer("customer_1", 2000));
        master.giveItem(new Customer("customer_2", 2000));
        master.giveItem(new RegularCustomer("customer_3", 2000, "아메리카노"));
        master.giveItem(new Customer("customer_4", 2000));
        master.giveItem(new RegularCustomer("customer_5", 2000, "딸기라떼"));


        // Owner 클래스 만들기 전
//        ArrayList<Customer> clist = new ArrayList<>(5);
//        clist.add(new Customer("customer_1", 2000));
//        clist.add(new Customer("customer_2", 2000));
//        clist.add(new RegularCustomer("customer_3", 2000, "아메리카노"));
//        clist.add(new Customer("customer_4", 2000));
//        clist.add(new RegularCustomer("customer_5", 2000, "딸기라떼"));
//
//        clist.forEach(c -> {
//            String beverage = c.makeOrder();
//            System.out.println(c.getName() + " 고객님, 주문하신 " + beverage + " 나왔습니다.");
//        });
    }
}
