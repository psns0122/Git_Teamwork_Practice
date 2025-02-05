package day03.Chicken;

public class Dog extends Animal{
    public Dog(int speed){
        super(speed);
    }

    @Override
    void run(int hours) {
        //거리는 시간*스피드*1/2
        setDistance(getDistance() + getSpeed()*hours*0.5);
    }
}
