package day13.homework.NO3;

public class Alcohol extends Drink {
    double alcper;

    Alcohol(String name, int price, int count, double alcper) {
        super(name, price, count);

        this.alcper = alcper;
    }

    static void printTitle() {
        System.out.println("상품명(도수[%])\t단가\t\t수량\t\t금액");
    }

    void printData() {
        System.out.println(this.name + "(" + this.alcper + ")"
                + "\t\t" + this.price + "\t" + this.count + "\t\t" + this.getTotalPrice());
    }

}
