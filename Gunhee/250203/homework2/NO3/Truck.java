package day01.homework2.NO3;

public class Truck extends Wheeler {
    Truck(String carName, int velocity, int wheelNumber) {
        this.carName = carName;
        this.velocity = velocity;
        this.wheelNumber = wheelNumber;
    }

    // 추상 메소드 오버라이딩
    @Override
    public void speedUp(int speed) {
        this.velocity += speed * 5;
        if (this.velocity > 100) {
            this.velocity = 100;
        }
        System.out.println(this.carName + "의 현재 속도는 " + this.velocity + "입니다.\n");
    }

    @Override
    public void speedDown(int speed) {
        this.velocity -= speed * 5;
        if (this.velocity < 50) {
            this.velocity = 50;
        }
        System.out.println(this.carName + "의 최저속도위반으로 속도를 " + this.velocity + "으로 올립니다.\n");
    }
}
