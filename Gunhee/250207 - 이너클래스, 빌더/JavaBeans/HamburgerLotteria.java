package day05.JavaBeans;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger 선민 = new Hamburger();
        선민.setBun(2);
        선민.setPatty(3);
        선민.setCheese(2);
        선민.setLettuce(1);
        선민.setBacon(2);
        Hamburger 유진 = new Hamburger();
        Hamburger 성빈 = new Hamburger();

    }
}

// 기본 생성자 오버로딩에서 보였던 가독성 문제가 해결되고, 파라미터에 대해 해당되는 Setter 메서드를
// 호출하면서 유연하게 객체 생성이 가능해짐.
// 문제점 발생이 발생됨
//1. 일관성 문제 (consistency)
/*필수 매개변수가 선택적으로 셋팅될 수 있으므로 일관성 문제가 발생한다.
  필수 멤버 : 객체가 초기화 될때, 반드시 설정이 되어야 하는 값
  객체가 유효하지 않은 형태로 생성, 햄버거 인스턴스를 다른곳에서 사용하게 되면 런타임 예외가 발생할 수 있다.
  객체를 생성하는 부분과 값을 설정하는 부분이 물리적으로 떨어져 있어서 발생하는 문제점이다.

2. 불변성 문제 (immutable)
   자바빈즈 패턴의 Setter 메서드는 객체를 처음 생성할때 필드값을 설정하기 위해 존재하는 메서드이다.
*/