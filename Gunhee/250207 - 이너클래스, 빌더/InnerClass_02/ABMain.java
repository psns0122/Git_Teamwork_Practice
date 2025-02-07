package day05.InnerClass_02;

public class ABMain {
    // B클래스가 정적 멤버 클래스이므로 외부에서 직접 생성이 가능하다.
    // (생성이 A에 의존적이지 않음)
    A.B b = new A.B();

}
