package day13.homework.NO3;

public class Drink {
    String name;
    int price;
    int count;

    Drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    int getTotalPrice() {
        return this.price * this.count;
    }

    static void printTitle() {
        System.out.println("상품명\t단가\t\t수량\t\t금액");
    }

    void printData() {
        System.out.println(this.name + "\t\t" + this.price + "\t" + this.count + "\t\t" + this.getTotalPrice());
    }

}
