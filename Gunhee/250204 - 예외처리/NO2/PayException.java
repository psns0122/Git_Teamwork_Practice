package NO2;

// 사용자 정의 Exception : 수정하지 말고 그대로 사용하세요.
public class PayException extends Exception {
    // Exception을 상속받았으므로 throws를 명시해야하는 체크 예외 클래스가 됨
    // 만약 RuntimeException을 상속받을 경우 throws를 생략해도 되는 언체크 예외 클래스가 된다.
    public PayException(String message){
        super(message);
    }
}
