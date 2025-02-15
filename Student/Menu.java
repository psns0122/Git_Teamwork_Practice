import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class Menu{
    enum By {
        num, name, score
    }

    static void addItem(ObjectDBIO manager, String data) {
        // 1️⃣ 만약 현재 타입이 Student 라면
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

        // 2️⃣ 만약 현재 타입이 Employee 라면
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
            // 1️⃣ 만약 현재 타입이 Student 라면
            if (manager.getType() == Student.class) {
                Collections.sort(
                        ((ObjectManager<Student>) manager).getObjects(),
                        Comparator.comparing(Student::getSno)
                );
            }

            // 2️⃣ 만약 현재 타입이 Employee 라면
            else if (manager.getType() == Employee.class) {
                Collections.sort(
                        ((ObjectManager<Employee>) manager).getObjects(),
                        Comparator.comparing(Employee::getEmpNo)
                );
            }
        }

        else if (type == By.name) {
            // 이름으로 정렬
            // 1️⃣ 만약 현재 타입이 Student 라면
            if (manager.getType() == Student.class) {
                Collections.sort(
                        ((ObjectManager<Student>) manager).getObjects(),
                        Comparator.comparing(Student::getName)
                );
            }

            // 2️⃣ 만약 현재 타입이 Employee 라면
            else if (manager.getType() == Employee.class) {
                Collections.sort(
                        ((ObjectManager<Employee>) manager).getObjects(),
                        Comparator.comparing(Employee::getName)
                );
            }
        }

        else if (type == By.score) {
            // 성적으로 정렬
            // 1️⃣ 만약 현재 타입이 Student 라면
            if (manager.getType() == Student.class) {
                Collections.sort(((ObjectManager<Student>)manager).getObjects());
            }

            // 2️⃣ 만약 현재 타입이 Employee 라면
            else if (manager.getType() == Employee.class) {
                Collections.sort(((ObjectManager<Employee>)manager).getObjects());
            }
        }
    }

    static void printALl(ObjectDBIO manager) {
        // 1️⃣ 만약 현재 타입이 Student 라면
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

        // 2️⃣ 만약 현재 타입이 Employee 라면
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

    static void printThis(Student student) {
        InterfaceIO<Student, String> io = new InterfaceIO<>();
        io.print(
                (item) -> {
                    if (item != null)
                    {
                        System.out.println("학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");
                        System.out.println(item);
                    } else {
                        System.out.println("찾는 학생이 없습니다.");
                    }
                },
                student
        );
    }

    static void printThis(Employee employee) {
        InterfaceIO<Employee, String> io = new InterfaceIO<>();
        io.print(
                (item) -> {
                    if (item != null)
                    {
                        System.out.println("학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");
                        System.out.println(item);
                    } else {
                        System.out.println("찾는 학생이 없습니다.");
                    }
                },
                employee
        );
    }

    static Student getStudent(ObjectDBIO<Student> manager, String key) {
        InterfaceIO<Student, String> io = new InterfaceIO<>();
        Student student = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Student>) manager).getObjects().stream()
                            .filter(s -> s.getName().equals(item.getName())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Student(param),
                key
        );
        return student;
    }

    static Employee getEmployee(ObjectDBIO<Employee> manager, String key) {
        InterfaceIO<Employee, String> io = new InterfaceIO<>();
        Employee employee = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Employee>) manager).getObjects().stream()
                            .filter(s -> s.getName().equals(item.getName())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Employee(param),
                key
        );
        return employee;
    }

    static Student getStudent(ObjectDBIO<Student> manager, int key) {
        InterfaceIO<Student, Integer> io = new InterfaceIO<>();
        Student student = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Student>) manager).getObjects().stream()
                            .filter(s -> s.getName().equals(item.getName())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Student(param),
                key
        );
        return student;
    }

     static Employee getEmployee(ObjectDBIO<Employee> manager, int key) {
        InterfaceIO<Employee, Integer> io = new InterfaceIO<>();
        Employee employee = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Employee>) manager).getObjects().stream()
                            .filter(s -> s.getName().equals(item.getName())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Employee(param),
                key
        );
        return employee;
    }

}