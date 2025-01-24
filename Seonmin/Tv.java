package Day13.Home;

public class Tv {
    String color;
    boolean power;
    int channel;


    Tv() {
        color = "black";
        power = false;
        channel = 0;
    }

    void power() {
        if (power == true) {
            power = false;
        } else {
            power = true;
        }

    }

    void channelUp() {
        channel++;

    }

    void channelDown() {
        channel--;

    }

    void print() {
        System.out.printf("color :%s   ",color);
        System.out.printf("power :%b    ", power);
        System.out.printf("channel :%d  ",channel);
        System.out.println();

    }
}

