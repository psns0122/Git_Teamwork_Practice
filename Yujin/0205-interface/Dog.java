package day03.interfaceEx.ex02;

public class Dog extends Animal{

    public Dog(int speed){
        super(speed);
    }

    @Override
    void run(int hours) {  //run 메소드를 오버라이딩해서 이동 거리 측정
        //거리는 시간*스피드*1/2
        setDistance(getDistance() + getSpeed()*hours*0.5);
    }
}
