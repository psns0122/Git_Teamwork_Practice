package day13;

// 참조변수의 형변환은 사용할 수 있는 멤버의 갯수를 조절한다

public class Child extends Pareant{
//    super.name;
//    super.age;
    int number;
}

class Main {
    public static void main(String[] args) {
        Pareant p = new Pareant();
        Child c = new Child();

        // 업캐스팅 (자식 -> 부모)
        Pareant p1 = (Pareant) c;
        System.out.println(p1.name);
        System.out.println(p1.age);
        // System.out.println(p1.number); (error 발생)

        System.out.println(p1 instanceof Pareant);
        System.out.println(p1 instanceof Child);

        // 다운캐스팅 (부모 -> 자식)
        // Child c1 = (Child) p; (error 발생)
        Child c1 = (Child) p1;
        System.out.println(c1.name);
        System.out.println(c1.age);
        System.out.println(c1.number);

        System.out.println(p instanceof Pareant);
        System.out.println(p instanceof Child);
        System.out.println(c1 instanceof Pareant);
        System.out.println(c1 instanceof Child);
    }
}

/** 출력결과
 * null
 * 0
 * true
 * true
 * null
 * 0
 * 0
 * true
 * false
 * true
 * true
 */