package Management;

import java.io.IOException;

/**
 * 학교 관리 시스템의 메인 클래스입니다.
 * 프로그램을 초기화하고 메뉴 화면을 시작합니다.
 */
public class TESTMAIN {

    /**
     * 학교 관리 시스템을 시작하는 main 메서드입니다.
     * Managing.Menu.startSystem() 메서드를 호출해 메인 메뉴를 표시합니다.
     *
     * @param args 실행 시 전달되는 인자 (사용하지 않음)
     * @throws IOException 입출력 오류 발생 시 예외를 던집니다.
     */
    public static void main(String[] args) throws IOException {

        Menu.startSystem();

    }

}
