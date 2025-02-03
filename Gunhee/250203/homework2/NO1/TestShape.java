package day01.homework2.NO1;

public class TestShape {
    public static void main(String[] args) {
        Shape [] shape = new Shape[2];

        shape[0] = new Circle(10);
        shape[1] = new Rectangular(20, 10);

        for(Shape temp : shape) {
            temp.calculationArea();
            temp.print();
        }

    }
}
