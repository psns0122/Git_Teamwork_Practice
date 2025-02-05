package day03.Chicken;

public class Chicken extends Animal implements Cheatable{

    Chicken(int speed){
        super(speed);

    }


    @Override
    void run(int hours) {
        //매개변수 시간을 받아서 멤버변수인 속도와 곱한다
        //부모클래스의 멤버변수인 distance에 저장한다.
        setDistance(getDistance() + hours * getSpeed());
    }

    @Override
    public void fly() {
        //현재속도의 값이 2배가 되도록 설정
        setSpeed(getSpeed()*2);


    }
}