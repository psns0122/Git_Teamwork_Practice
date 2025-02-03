package day01.homework2.NO1;

public abstract class Shape {
    // 생성자
    public Shape() { }
    public Shape(String name) {
        this.name = name;
    }

    // 추상 메소드
    // 추상 메소드는 추상 클래스에서 구현하면 안됨 ({} 없어야함)
    abstract public void calculationArea();

    // 멤버 메소드
    public void print() { }

    // 멤버 변수
    private String name;
    protected double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
