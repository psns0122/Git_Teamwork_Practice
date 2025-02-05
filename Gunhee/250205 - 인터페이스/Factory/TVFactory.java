package day03.Factory;

// Factory 클래스를 상속받고 IWorkingTogether을 구현하는 클래스
public class TVFactory extends Factory implements IWorkingTogether {
    // 생성자
    TVFactory(String name, int openHour, int closeHour) {
        // 3개의 데이터를 매개변수의 인자로 받아, 이를 부모 클래스로 전달한다.
        super(name, openHour, closeHour);
    }

    // 추상 메소드 오버라이딩
    @Override
    int makeProducts(char skill) {
        // 목표 : 매개변수 skill과 실제 공장운행시간을 통해 공잔의 하루 생산량을 수치화한다.
        // 계산식 : 공장운행시간 * skill
        switch (skill) {
            case 'A':
                return this.getWorkingTime()*8;
            case 'B':
                return this.getWorkingTime()*5;
            case 'C':
                return this.getWorkingTime()*3;
            default:
                return this.getWorkingTime();
        }
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        // 파트너 공장의 기술력 'C'에 대한 하루 생산량을 리턴한다
        int products = 0;
        if (partner instanceof CarFactory c) {
            products = c.makeProducts('C');
        } else if (partner instanceof TVFactory t) {
            products = t.makeProducts('C');
        }
        return products;
    }
}
