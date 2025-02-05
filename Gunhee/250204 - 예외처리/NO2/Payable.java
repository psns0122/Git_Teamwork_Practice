package NO2;

public interface Payable {
    // 1.
    // 인터페이스 Payable을 상속받은 클래스는 반드시 pay 함수를 정의해야한다.
    // 이때, pay 함수는 PayException에 대한 예외를 던지거나(throw), 직접 처리(try-catch)해야 한다.

    // 2.
    // 인터페이스에서 선언되었으므로 pay 함수는 abstract 키워드 없이도 자동으로 추상 메소드가 된다.
    public void pay() throws PayException ;
}

