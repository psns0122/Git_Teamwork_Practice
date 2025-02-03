package day01.homework2.NO1;

public class Rectangular extends Shape{
    // 생성자
    public Rectangular(double width, double hight) {
        this.width = width;
        this.hight = hight;
    }

    // 추상 메소드 오버라이딩
    @Override
    public void calculationArea() {
        this.area = this.width * this.hight;
    }

    // 멤버 메소드 오버라이딩
    public void print() {
        System.out.println("직사각형의 면적은 " + this.area);
    }

    // 멤버 변수
    private double width;
    private double hight;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }
}
