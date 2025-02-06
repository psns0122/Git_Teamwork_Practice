package day03.interfaceEx.ex05.P2;

class Dog implements Soundable{

    @Override
    public String sound() {
        return "멍멍";
    }
}

class Cat implements Soundable{

    @Override
    public String sound() {
        return "야옹";
    }
}

public class SoundableExample {
    public static void printSound(Soundable soundable){
        System.out.println(soundable.sound());  //야옹,멍멍
    }

    public static void main(String[] args) {
        printSound(new Cat());  //야옹
        printSound(new Dog());  //멍멍
    }

}
