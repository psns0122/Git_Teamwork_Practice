import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class Menu{
    enum By {
        num, name, score
    }

    static void addItem(ObjectDBIO manager, String data) {
        if (manager.getType() == Student.class) {
            InterfaceIO<Student, String> io = new InterfaceIO<>();
            io.add(
                    (item) -> {

                        ((ObjectManager<Student>)manager).getObjects().add(item);
                    },

                    (param) -> {
                        Student student = new Student(param);

                        // 총점 계산
                        int totalScore = student.sum((korean, english, math, science)
                                -> korean + english + math + science);
                        student.setTotal(totalScore);

                        // 평균 계산
                        student.setAverage(student.avg());

                        // 성적 계산
                        student.setGrade(student.grade());

                        return student;
                    },
                    data
            );
        }

        else if (manager.getType() == Employee.class) {

            InterfaceIO<Employee, String> io = new InterfaceIO<>();
            io.add(
                    (item) -> {
                        ((ObjectManager<Employee>)manager).getObjects().add(item);
                    },

                    (param) -> {
                        Employee employee = new Employee(param);

                        // TODO 급여계산

                        return employee;
                    },
                    data
            );
        }
    }

    static void sort(ObjectDBIO manager, By type) {
        if (type == By.num) {
            // 학번 || 사번 으로 정렬
            if (manager.getType() == Student.class) {
                Collections.sort(
                        ((ObjectManager<Student>) manager).getObjects(),
                        Comparator.comparing(Student::getSno)
                );
            } else if (manager.getType() == Employee.class) {
                Collections.sort(
                        ((ObjectManager<Employee>) manager).getObjects(),
                        Comparator.comparing(Employee::getEmpNo)
                );
            }
        }

        else if (type == By.name) {
            // 이름으로 정렬
            if (manager.getType() == Student.class) {
                Collections.sort(
                        ((ObjectManager<Student>) manager).getObjects(),
                        Comparator.comparing(Student::getName)
                );
            } else if (manager.getType() == Employee.class) {
                Collections.sort(
                        ((ObjectManager<Employee>) manager).getObjects(),
                        Comparator.comparing(Employee::getName)
                );
            }
        }

        else if (type == By.score) {
            // 성적으로 정렬
            if (manager.getType() == Student.class) {
                Collections.sort(((ObjectManager<Student>)manager).getObjects());
            } else if (manager.getType() == Employee.class) {
                Collections.sort(((ObjectManager<Employee>)manager).getObjects());
            }
        }
    }

    static void printALl(ObjectDBIO manager) {
        if (manager.getType() == Student.class) {
            InterfaceIO<Student, String> io = new InterfaceIO<>();
            io.print(
                    (item) -> {
                        System.out.println("학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");

                        ((ObjectManager<Student>)manager).getObjects().forEach(System.out::println);
                    },
                    Student::new
            );
        }

        else if (manager.getType() == Employee.class) {
            InterfaceIO<Employee, String> io = new InterfaceIO<>();
            io.print(
                    (item) -> {
                        System.out.println("학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");

                        ((ObjectManager<Employee>)manager).getObjects().forEach(System.out::println);
                    },
                    Employee::new
            );
        }
    }

}