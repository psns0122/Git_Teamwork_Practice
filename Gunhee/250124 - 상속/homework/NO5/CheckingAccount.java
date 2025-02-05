package day13.homework.NO5;

public class CheckingAccount extends Account {
    // 멤버 변수
    private String cardNo;

    // getter, setter 메소드
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    // 생성자
    CheckingAccount(String accId, String ownerName, long balance, String cardNo) {
        this.cardNo = cardNo;
        this.setAccId(accId);
        this.setBalance(balance);
        this.setOwnerName(ownerName);
    }

    // 멤버 메소드
    void pay(String cardNo, long amount) {
        if (this.cardNo == cardNo) {
            if (amount < this.getBalance()) {
                this.setBalance(this.getBalance() - amount);
            }
            else {
                System.out.println("지불이 불가능합니다.");
            }
        }
        else {
            System.out.println("지불이 불가능합니다.");
        }
    }

    // 추상 메소드 오버라이딩
    @Override
    public void calcRate() {
        // 아직 기능 정의가 되지 않아서 구현하지 않음
    }
}
