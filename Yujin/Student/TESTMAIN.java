import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.IOException;
/**
 * 프로그램 실행을 위한 메인 클래스
 */
public class TESTMAIN {
    /**
     * 프로그램 실행 메서드
     * @param args 실행 시 전달되는 인자
     * @throws IOException 입출력 오류 발생 시
     */
    public static void main(String[] args) throws IOException {

        // 학생관리
        ObjectDBIO<Student> studentDB = ObjectDBIO.getInstance(Student.class);

        // 파일에서 읽기
        studentDB.readDB();

        // 1️⃣ 함수형인터페이스 add
        System.out.println("신입생 추가 시도");
        if (Menu.addItem(studentDB, "0000000001 신입생 100 100 100 100")) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
        System.out.println("-----------------------------------------------");

        // 2️⃣ 검색 + return 함수 getStudent
        System.out.println("학번 2017103985 검색 결과");
        System.out.println(Menu.getStudent(studentDB, 2017103985));
        System.out.println("이름 홍길동 검색 결과");
        System.out.println(Menu.getStudent(studentDB, "홍길동"));
        System.out.println("-----------------------------------------------");

        // 3️⃣ 정렬
        // Comparator.comparing sort (학번 순)
        Menu.sort(studentDB, Menu.By.num);

        // Comparator.comparing sort (이름 순)
//        Menu.sort(studentDB, Menu.By.name);

        // compareTo sort (성적 순)
//        Menu.sort(studentDB, Menu.By.score);


        // 4️⃣ 함수형인터페이스 print (전체 요소 출력)
        System.out.println("전체 학생 정보를 출력합니다.");
        Menu.printAll(studentDB);
        System.out.println("-----------------------------------------------");

        // 파일에 쓰기
        studentDB.pushDB();

        System.out.println("\n////////////////////////////////////////////////////////////////////\n");

        // 직원관리
        ObjectDBIO<Employee> employee = ObjectDBIO.getInstance(Employee.class);

        employee.readDB();
        employee.pushDB();

    }

}