import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.IOException;

public class TESTMAIN {

    public static void main(String[] args) throws IOException {

        // 학생관리
        ObjectDBIO<Student> studentDB = ObjectDBIO.getInstance(Student.class);
        InterfaceIO<Student, String> io = new InterfaceIO<>();

        studentDB.readDB();

        // TODO 함수형인터페이스 add
        io.add(
                (item) -> {

                    ((ObjectManager<Student>)studentDB).getObjects().add(item);
                },

                (param) -> {
                    Student student = new Student(param);

                    // 총점 계산
                    int totalScore = student.sum((korean, english, math, science) -> korean + english + math + science);
                    student.setTotal(totalScore);

                    // 평균 계산
                    student.setAverage(student.avg());

                    // 성적 계산
                    student.setGrade(student.grade());

                    return student;
                },

                "0000000000 신입생 100 100 100 100 0 0 nan"
        );

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
