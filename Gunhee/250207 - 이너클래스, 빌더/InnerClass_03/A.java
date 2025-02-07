package day05.InnerClass_03;

// 이너클래스 B를 가진 아우터클래스 A
public class A {
    // 로컬 클래스는 생성자와 메소드가 샐행될 동안에만 객체를 생성하고 유지한다.
    public A() {
        // 로컬 클래스 B
        class B { }
        B b = new B();
    }
    // 로컬 클래스는 생성자와 메소드가 샐행될 동안에만 객체를 생성하고 유지한다.
    void userB(int param) {
        // 로컬 변수
        // 메소드의 로컬 변수를 로컬 클래스가 사용할 경우,
        // 로컬 변수는 final의 특성을 가지게 된다.
        int value = param;

        // 로컬 클래스 B
        // 로컬 변수는 로컬 클래스 내부에서 수정할 수 없다. (문법적으로 아예 막아둠)
        int finalValue = value;
        class B {
            int field1 = 10;
            static int field2 = 20;

            public B() {
                System.out.println("B 생성자 호출");
            }

            void changeField1() {
                System.out.println("이너클래스 B method1 실행");
                System.out.println("이너클래스의 멤버변수 field1 : " + field1);
                this.field1 = field2;
                System.out.println("이너클래스의 멤버변수 field1 : " + field1);
                System.out.println("이너클래스 B method1 종료\n");
            }

            void changeParam() {
                System.out.println("이너클래스 B static method2 실행");
                // 로컬 변수는 로컬 클래스 내부에서 수정할 수 없다. (문법적으로 아예 막아둠)
                System.out.println("useB의 지역변수 value : " + finalValue);
                // value = 110;
                System.out.println("useB의 지역변수 value : " + finalValue);
                System.out.println("이너클래스 B static method2 종료\n");
            }
        }; // 로컬 클래스 B 끝

        B b = new B();
        System.out.println(b.field1);
        b.changeField1();
        b.changeParam();

        System.out.println("아우터클래스 A의 useB 메소드 실행");
        // 아우트 클래스에서는 로컬변수의 수정이 가능하다.
        System.out.println("useB의 지역변수 value : " + value);
        value = 110;
        System.out.println("useB의 지역변수 value : " + value);
        System.out.println("아우터클래스 A의 useB 메소드 종료");
    }
}
