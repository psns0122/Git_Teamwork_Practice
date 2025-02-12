package day12.inheritance;
class Parent extends Object{
    int field1 = 10;                   //멤버 변수

    Parent(){
        super();
    }
    void method1(){                    //멤버 메소드
        System.out.println("나는 부모클래스의 method1이야");
    }
}
class Child extends Parent{  //Child클래스는 Parent 클래스에게 상속을 요청
    int field2;
    Child(){
        super();  //super 메서드
    }

    void method2(){
        System.out.println("나는 자식클래스의 method2이야");
    }
}

public class inherMain {
    public static void main(String[] args) {
        /*
        Parent parent = new Parent();         //Parent 객체 생성
        Child child = new Child();
        System.out.println(parent.field1);
        parent.method1();                     //parent.method2()(x) - 부모는 자식클래스에 접근할수없다
        */

        Child child = new Child();

        System.out.println(child.field1 + " "+child.field2);
        child.method1();
        child.method2();
    }
}
