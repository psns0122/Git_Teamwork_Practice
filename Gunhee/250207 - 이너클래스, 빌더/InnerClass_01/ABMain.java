package day05.InnerClass_01;

public class ABMain {
    public static void main(String[] args) {
        A a = new A();
        // 외부에서 이너클래스를 생성하는 문법
        A.B b = a.new B();

        // A클래스의 메소드를 통해 이너클래스에 접근하는 방법
        a.useB();
        /* 실행결과
        B의 생성자 실행
        B의 생성자 실행
        10
        20
        B의 메소드1 실행
        B의 static 메소드2 실행
         */

        /*
        총 세개의 클래스 파일이 생성됨
        A$B.class
        A.class
        ABMain.class
         */

    }
}
