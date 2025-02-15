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
//        Menu.addItem(studentDB, "0000000000 박건희 100 100 100 100");

        // TODO 함수형인터페이스 search
//        Menu.getStudent(studentDB, 2017103984);

        // Comparator.comparing sort (학번 순)
//        Menu.sort(studentDB, Menu.By.num);
//        System.out.println("-----------------------------------------------");
//        System.out.println("학번 순으로 전체 학생 정보를 출력합니다.");
//        Menu.printALl(studentDB);
//        System.out.println("-----------------------------------------------");
//        System.out.println("\n\n");

        // Comparator.comparing sort (이름 순)
//        Menu.sort(studentDB, Menu.By.name);
//        System.out.println("-----------------------------------------------");
//        System.out.println("이름 순으로 전체 학생 정보를 출력합니다.");
//        Menu.printALl(studentDB);
//        System.out.println("-----------------------------------------------");
//        System.out.println("\n\n");

        // compareTo sort (성적 순)
//        Menu.sort(studentDB, Menu.By.score);
//        System.out.println("-----------------------------------------------");
//        System.out.println("성적 순으로 전체 학생 정보를 출력합니다.");
//        Menu.printALl(studentDB);
//        System.out.println("-----------------------------------------------");
//        System.out.println("\n\n");

        // 함수형인터페이스 print (전체 요소 출력)
//        Menu.printALl(studentDB);

        // 함수형인터페이스 print (일부 요소 출력)
//        Menu.printThis(new Student("test student 100 100 100 100"));
        Menu.printThis(Menu.getStudent(studentDB, 2017103984));

        studentDB.pushDB();

        System.out.println("\n////////////////////////////////////////////////////////////////////\n");

        // 직원관리
        ObjectDBIO<Employee> employee = ObjectDBIO.getInstance(Employee.class);

        employee.readDB();
        employee.pushDB();

    }

}
