package day12;

class Parent {
    // 멤버변수
    int field1 = 12; // 힙 메모리에 저장
    // 멤버메소드
    void method1() {
        System.out.println("나는 부모클래스의 method1이야");
    }
    // 기본 생성자
    Parent() { }
}

// Parent 클래스에게 상속을 오청
// Parent 클래스는 접근제어자가 허용한다면 무조건 상속 요청을 받아야한다.
// extends : 확장의 개념 (부모가 먼저 생성되어야 한다)
class Child extends Parent {
    // 멤버변수
    int field2 = 22; // 힙 메모리에 저장
    // 멤버메소드
    void method2() {
        System.out.println("나는 자식클래스의 method2이야");
    }
    // 기본 생성자
    Child() { // 자식 생성자
        super(); // 부모 생성자
    }

}

public class InherMain {
    public static void main(String[] args) {
        Parent parent = new Parent(); // 메모리 공간 생성
        Child child = new Child(); // Parent 공간 먼저 만들고 Child 공간 만든다
        System.out.println(parent.field1);
        parent.method1();

        System.out.println(child.field1 + " " + child.field2);
        child.method1();
        child.method2();

        // field1을 공유하는 개념은 X
        child.field1 = 100;
        System.out.println(parent.field1);
        System.out.println(child.field1);

    }
}
