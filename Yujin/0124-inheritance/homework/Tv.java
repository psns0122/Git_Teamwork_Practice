package day13.homework.class실습;

public class Tv {
    private String color;
    private Boolean power;
    private int channel;

    // 생성자
    public Tv(){
        color = "black";
        power = false;
        channel = 0;
    }

    // 겟터 셋터
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getPower() {
        return power;
    }

    public void setPower(Boolean power) {
        this.power = power;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    // 문제에 나오는 일반 메소드
    public void power(){
        if(power == true){
            power = false;
        }else{
            power=true;
        }
    }
    public void channelUp(){
        channel++;
    }
    public void channelDown(){
        channel--;
    }
    public void print(){
        System.out.println("color:"+color+" "+"power:"+power+" "+"channel:"+channel);
    }
}
