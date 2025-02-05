package day13;

class GrandFather {
    protected String home = "수원";

    GrandFather() {
        System.out.println("저는 할아버지입니다.");
    }
    GrandFather(String home) {
        System.out.println("저는 할아버지입니다.");
        System.out.println("저는 " + home + "에 삽니다.");
    }
}

class SubFather extends GrandFather{
    protected String home = "강남";

    SubFather() {
        System.out.println("> 저는 아버지입니다.");
        System.out.println("> 저는 할아버지를 상속받습니다.");
        System.out.println("> 저는 " + this.home + "에 삽니다.");
    }
    SubFather(String job) {
        System.out.println("> 저는 아버지입니다.");
        System.out.println("> 저는 할아버지를 상속받습니다.");
        System.out.println("> 제 직업은 " + job + "입니다.");
        System.out.println("> 저는 " + super.home + "에 삽니다.");
    }
}

class Son extends SubFather {
    Son() {
        super("프로그래머");
        System.out.println(">> 저는 아들입니다.");
        System.out.println(">> 저는 아버지를 상속받습니다.");
        System.out.println(">> 제 직업은 학생입니다.");
    }
    Son(String myJob) {
        System.out.println(">> 저는 아들입니다.");
        System.out.println(">> 저는 아버지를 상속받습니다.");
        System.out.println(">> 제 직업은 " + myJob + "입니다.");
    }
}

public class Father {
    public static void main(String[] args) {
        Son tomas = new Son();
        System.out.println("-----------------------------------------");
        Son benjamin = new Son("취준생");
    }
}

/**
 * 저는 할아버지입니다.
 * > 저는 아버지입니다.
 * > 저는 할아버지를 상속받습니다.
 * > 제 직업은 프로그래머입니다.
 * > 저는 수원에 삽니다.
 * >> 저는 아들입니다.
 * >> 저는 아버지를 상속받습니다.
 * >> 제 직업은 학생입니다.
 * -----------------------------------------
 * 저는 할아버지입니다.
 * > 저는 아버지입니다.
 * > 저는 할아버지를 상속받습니다.
 * > 저는 강남에 삽니다.
 * >> 저는 아들입니다.
 * >> 저는 아버지를 상속받습니다.
 * >> 제 직업은 취준생입니다.
 */