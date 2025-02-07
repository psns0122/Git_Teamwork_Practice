package day05.InnerClass_02;

// 이너클래스 B를 가진 아우터클래스 A
public class A {
    // 스태틱 멤버 클래스 B
    static class B { }

    B field1 = new B();
    static B field2 = new B();

    void method1() {
        B b = new B();
    }

    static void method2() {
        B b = new B();
    }
}
