package day03.Cafe;

import java.util.Scanner;

public class Customer implements Order {
    // 생성자
    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // 추상 메소드 오버라이딩
    @Override
    public String makeOrder() {
        System.out.print("주문하시겠습니까? :");
        return in.next();
    }

    // 멤버변수
    private String name;
    private double balance;
    Scanner in = new Scanner(System.in);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
