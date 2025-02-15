import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.IOException;

public class TESTMAIN {

    public static void main(String[] args) throws IOException {

        // 학생관리
        ObjectDBIO<Student> studentDB = ObjectDBIO.getInstance(Student.class);

        studentDB.readDB();

        // TODO 함수형인터페이스 add
        // TODO 함수형인터페이스 search
        // TODO 함수형인터페이스 sort
        // TODO 함수형인터페이스 print

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
