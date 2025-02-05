package day03.Factory;

// 추상클래스
public abstract class Factory {
    // 생성자
    Factory(String name, int openHour, int closeHour) {
        // 3개의 데이터를 매개변수의 인자로 받으며 아래와 같이 멤버 변수의 초기화에 사용한다.
        this.name = name;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    // 멤버 메소드
    String getFactoryName() {
        // 공장의 이름을 리턴한다.
        return this.name;
    }

    int getWorkingTime() {
        // 실제 공장운행 시간을 리턴한다
        // 공식 : closeHour - openHour
        return this.closeHour - this.openHour;
    }

    // 추상 메소드
    abstract int makeProducts(char skill);

    // 멤버 변수 및 getter, setter 메소드
    int openHour; // 공장시작시간
    int closeHour; // 공장종료시각
    String name; // 공장이름

    public int getOpenHour() {
        return openHour;
    }

    public void setOpenHour(int openHour) {
        this.openHour = openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(int closeHour) {
        this.closeHour = closeHour;
    }

    public void setName(String name) {
        this.name = name;
    }
}
