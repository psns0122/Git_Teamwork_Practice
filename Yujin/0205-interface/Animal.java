package day03.interfaceEx.ex02;

public abstract class Animal {
    private int speed;
    private double distance;

    public Animal(){}
    public Animal(int speed){     //속도받는 생성자를 만들었다
        this.speed = speed;
    }
    abstract void run(int hours);

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
