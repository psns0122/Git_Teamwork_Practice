package day13.homework.NO5;

public abstract class Account {
    // 멤버 변수
    private String accId;
    private long balance;
    private String ownerName;

    // 생성자
    public Account(){

    }
    public Account(String accId,long balance,String ownerName){
        this.accId = accId;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // 추상 메소드
    public abstract void calcRate();

    // 멤버 메소드
    public void deposit(long money){
        this.balance = this.balance + money;

    }
    public void withdraw(long money){
        this.balance = this.balance - money;
    }

    // getter, setter 메소드
    public long getBalance(){
        return this.balance;
    }
    public String getAccId() {
        return accId;
    }
    public void setAccId(String accId) {
        this.accId = accId;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }

}