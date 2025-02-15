import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.IOException;

public class TESTMAIN {

    public static void main(String[] args) throws IOException {

        // 학생관리
        ObjectDBIO<Student> studentDB = ObjectDBIO.getInstance(Student.class);
        InterfaceIO<Student, String> io = new InterfaceIO<>();
        InterfaceIO<Student, Integer> io2 = new InterfaceIO<>();

        studentDB.readDB();

        // 함수형인터페이스 add
        // Menu.addItem(studentDB, "0000000000 박건희 100 100 100 100 0 0 nan");

        // TODO 함수형인터페이스 search

        // Comparator.comparing sort (학번 순)
        Menu.sort(studentDB, Menu.By.num);
        System.out.println("-----------------------------------------------");
        System.out.println("학번 순으로 전체 학생 정보를 출력합니다.");
        Menu.printALl(studentDB);
        System.out.println("\n////////////////////////////////////////////////////////////////////\n");
        // Comparator.comparing sort (이름 순)
        Menu.sort(studentDB, Menu.By.name);
        System.out.println("-----------------------------------------------");
        System.out.println("이름 순으로 전체 학생 정보를 출력합니다.");
        Menu.printALl(studentDB);
        System.out.println("\n////////////////////////////////////////////////////////////////////\n");
        // compareTo sort (성적 순)
        Menu.sort(studentDB, Menu.By.score);
        System.out.println("-----------------------------------------------");
        System.out.println("성적 순으로 전체 학생 정보를 출력합니다.");
        Menu.printALl(studentDB);

        // 함수형인터페이스 print (전체 요소 출력)
        // Menu.printALl(studentDB);

        // TODO 함수형인터페이스 print (일부 요소 출력)

        io.print(
                (item) -> {
                    if (item != null)
                    {
                        System.out.println("학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");
                        System.out.println(item);
                        System.out.println("-----------------------------------------------");
                    } else {
                        System.out.println("찾는 학생이 없습니다.");
                    }
                },

                io2.search(
                        (item) -> {
                            // forEach 는 return 사용 불가
                            // forEach 대신 stream 사용 (filter + findFirst)
                            return ((ObjectManager<Student>) studentDB).getObjects().stream()
                                    .filter(s -> s.getSno().equals(item.getSno())) // 조건에 맞는 첫 번째 요소 필터
                                    .findFirst() // 첫 번째 일치하는 요소 반환
                                    .orElse(null); // 없으면 null 반환
                        },

                        (param) -> new Student(param),
                        2017103984
                )
        );

        studentDB.pushDB();

        System.out.println("\n////////////////////////////////////////////////////////////////////\n");

        // 직원관리
        ObjectDBIO<Employee> employee = ObjectDBIO.getInstance(Employee.class);

        employee.readDB();

        // TODO 함수형인터페이스 add
        // TODO 함수형인터페이스 search
        // TODO 함수형인터페이스 sort
        // TODO 함수형인터페이스 print

        employee.pushDB();

    }

}
