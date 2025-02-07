package day05.Builder;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger 선민이햄버거 = new Hamburger.BurgerBuilder("플랫", "쇠고기").addCheese().addBacon().addtomato().addlettuce().build();
        System.out.println(선민이햄버거);

        Hamburger test = new HamburgerSet.BurgerSetBuilder("플랫", "닭고기", "콜라").addBacon().addlettuce().addCheese().build();
        System.out.println(test);
    }
}

//실습 : 필수 사항에 셋트는 반드시 음료가 포함되는 햄버거 셋트이다.
//음료가 포함되어 있는 햄버거를 만들어 주세요
//치킨버거(토핑: 치즈, 야채 , 베이컨) + 콜라  셋트 메뉴 만들어 주세요

// 기본 생성자 오버로딩에서 보였던 가독성 문제가 해결되고, 파라미터에 대해 해당되는 Setter 메서드를
// 호출하면서 유연하게 객체 생성이 가능해짐. (자바빈즈 패턴)

/*
  하지만 자바빈즈 패턴에도 문제점 발생이 발생됨
  1. 일관성 문제 (consistency)
  필수 매개변수가 선택적으로 셋팅될 수 있으므로 일관성 문제가 발생한다.
  필수 멤버 : 객체가 초기화 될때, 반드시 설정이 되어야 하는 값
  객체가 유효하지 않은 형태로 생성, 햄버거 인스턴스를 다른곳에서 사용하게 되면 런타임 예외가 발생할 수 있다.
  객체를 생성하는 부분과 값을 설정하는 부분이 물리적으로 떨어져 있어서 발생하는 문제점이다.

2. 불변성 문제 (immutable)
   자바빈즈 패턴의 Setter 메서드는 객체를 처음 생성할때 필드값을 설정하기 위해 존재하는 메서드이다.
*/

// => 최종적으로 빌더 패턴을 사용