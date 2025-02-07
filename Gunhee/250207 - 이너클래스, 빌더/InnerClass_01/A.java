package day05.InnerClass_01;

// 이너클래스 B를 가진 아우터클래스 A
public class A {
    // 인스턴스 멤버 클래스
    class B {
        // 인스턴스 필드
        int field1 = 10;
        static int field2 = 20;

        // 생성자
        B() {
            System.out.println("B의 생성자 실행");
        }

        // 인스턴스 메소드
        void method1() {
            System.out.println("B의 메소드1 실행");
        }

        static void method2() {
            System.out.println("B의 static 메소드2 실행");
        }
    }

    // A 클래스 영역
    // 인스턴스 메소드
     void useB() {
        B b = new B();
         System.out.println(b.field1);
         System.out.println(B.field2);

         b.method1();
         B.method2();
     }
}
