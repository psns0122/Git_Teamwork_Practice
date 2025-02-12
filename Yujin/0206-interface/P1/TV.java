package day03.interfaceEx.ex05.P1;

public class TV implements Remocon{


    public static void main(String[] args) {
        Remocon r = new TV();
        r.powerOn();
    }

    @Override
    public void powerOn() {
        System.out.println("TV를 켰습니다");
    }
}
