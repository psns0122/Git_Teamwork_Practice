package day13.homework.NO1;

public class Tv {
    String color;
    boolean power;
    int channel;

    Tv() {
        this.color = "black";
        this.power = false;
        this.channel = 0;
    }

    boolean power() {
        this.power = !power;
        return this.power;
    }

    void channelUp() {
        this.channel++;
    }

    void channelDown() {
        this.channel--;
    }

    void print() {
        System.out.println("color :" + this.color + "\tpower:" + this.power + "\t\tchannel:" + this.channel);
    }

}
