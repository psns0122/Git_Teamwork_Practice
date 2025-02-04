package NO1;
//BufferedReader(new InputStreamReader(System.in)) 사용하셔도 됩니다.

import java.util.Scanner;

public class Prob1 {

    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
        String str= scan.nextLine();
        int result= 0;

        //여기를 작성하십시오.
        try {
            result = convert(str);
            System.out.println("변환된 숫자는 " + result + " 입니다.");
        } catch (IllegalArgumentException e) {
            // 매개변수로 전달된 값에 이상이 있는 경우
            System.out.println(e.getMessage());
        }

    }

    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
    // IllegalArgumentException 예외는 런타임 예외이므로 throws 필요 없음
    // 컴파일시 체크하는 예외 : 체크 예외 / 런타임시 발생하는 예외 : 언체크 예외
    private static int convert(String str) {
        //여기를 작성하십시오.
        if (str == null || str.length() == 0) {
            // str 객체가 비어있을 수도 있으므로, 길이 검사하는 함수를 호출하기 전에 null에 대한 검사를 우선한다.
            throw new IllegalArgumentException("예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.");
        } else if (!str.matches("-?\\d+(\\.\\d+)?")) {
            // -? : 음수 부호가 올 수도, 안 올 수도 있음 -> 어떤 경우에도 허용
            // \\d : 0~9 한자리 수
            // \\d+ : 0~9로 이뤄진 여러자리 수
            // \\. : . 하나
            // (\\.\\d+)? : (. 하나와 그 뒤로 여러개의 숫자)가 올 수도, 안 올 수도 있음
            // !str.matches("-?\\d+(\\.\\d+)?") : 즉, (음수 정수, 음수 소수, 양수, 양수 소수) 가 아닌 경우에 대해 아래 예외처리 발생
            throw new NumberFormatException("예외가 발생되었습니다. 숫자만 입력해주세요.");
        }

        // 실수가 입력되는 경우를 대비
        return (int) Double.parseDouble(str);
    }

}
