package day01.homework2.NO1;

public class Circle extends Shape {
    // 생성자
    public Circle(double radius) {
        this.radius = radius;
    }

    // 추상 메소드 오버라이딩
    @Override
    public void calculationArea() {
        this.area = Math.pow(this.radius, 2) * Math.PI;
    }

    // 멤버 메소드 오버라이딩
    public void print() {
        System.out.println("원의 면적은 " + this.area);
    }

    // 멤버 변수
    private double radius;
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
