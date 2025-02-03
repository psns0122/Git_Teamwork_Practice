package day01.homework2.NO3;

public abstract class Wheeler {
    protected int velocity;
    protected String carName;
    protected int wheelNumber;

    // 추상 메소드
    abstract public void speedUp(int speed);
    abstract public void speedDown(int speed);

    // 멤버 메소드
    public void stop(){
        velocity = 0;
        System.out.println("정지상태로 속도를 0으로 초기화합니다.\n");
    }
}

