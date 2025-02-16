import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Menu{
    enum By {
        num, name, score
    }

    // 🚀 - 요소 추가
    static boolean addItem(ObjectDBIO manager, String data) {
        StringTokenizer st = new StringTokenizer(data);
        int num = Integer.parseInt(st.nextToken());

        // 학번 || 사번이 중복될 경우 addItem 취소
        if (searchItem(manager, num)) return false;

        // 1️⃣ 만약 현재 타입이 Student 라면
        if (manager.getType() == Student.class) {
            InterfaceIO<Student, String> io = new InterfaceIO<>();
            io.add(
                    // 객체를 리스트에 추가하는 동작
                    (item) -> {
                        ((ObjectManager<Student>)manager).getObjects().add(item);
                    },

                    // 객체를 생성하는 동작
                    (param) -> {
                        // 객체 생성 및 값 대입
                        Student student = new Student(num);
                        student.setName(st.nextToken());
                        student.setKorean(Integer.parseInt(st.nextToken()));
                        student.setEnglish(Integer.parseInt(st.nextToken()));
                        student.setMath(Integer.parseInt(st.nextToken()));
                        student.setScience(Integer.parseInt(st.nextToken()));

                        // 성적 계산
                        int totalScore = student.sum((korean, english, math, science)
                                -> korean + english + math + science);
                        student.setTotal(totalScore);
                        student.setAverage(student.avg());
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
                    // 객체를 리스트에 추가하는 동작
                    (item) -> {
                        ((ObjectManager<Employee>)manager).getObjects().add(item);
                    },

                    // 객체를 생성하는 동작
                    (param) -> {
                        Employee employee = new Employee(param);
                        employee.setName("test");
                        employee.setEmpNo("000");

                        // TODO 급여계산

                        return employee;
                    },
                    data
            );
        }

        return true;
    }

    // 🧷 정렬 (번호, 이름, 성적 순 정렬 제공)
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

    // 🖨️ 전체 출력
    static void printAll(ObjectDBIO manager) {
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

    // 🔍 - 번호 중복 확인
    static boolean searchItem(ObjectDBIO manager, int key) {
        if (manager.getType() == Student.class) {
            return getStudent(manager, key) != null;
        } else if (manager.getType() == Employee.class) {
            return getEmployee(manager, key) != null;
        }
        return false;
    }

    // 🔍 - 이름 중복 확인
    static boolean searchItem(ObjectDBIO manager, String key) {
        if (manager.getType() == Student.class) {
            return getStudent(manager, key) == null;
        } else if (manager.getType() == Employee.class) {
            return getEmployee(manager, key) == null;
        }
        return false;
    }

    // 🔍 - 1️⃣ 이름으로 학생 찾기
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

    // 🔍 - 2️⃣ 이름으로 직원 찾기
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

    // 🔍 - 1️⃣ 학번으로 학생 찾기
    static Student getStudent(ObjectDBIO<Student> manager, int key) {
        InterfaceIO<Student, Integer> io = new InterfaceIO<>();
        Student student = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Student>) manager).getObjects().stream()
                            .filter(s -> s.getSno().equals(item.getSno())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Student(param),
                key
        );
        return student;
    }

    // 🔍 - 2️⃣ 사번으로 직원 찾기
     static Employee getEmployee(ObjectDBIO<Employee> manager, int key) {
        InterfaceIO<Employee, Integer> io = new InterfaceIO<>();
        Employee employee = io.search(
                (item) -> {
                    // forEach 는 return 사용 불가
                    // forEach 대신 stream 사용 (filter + findFirst)
                    return ((ObjectManager<Employee>) manager).getObjects().stream()
                            .filter(s -> s.getEmpNo().equals(item.getEmpNo())) // 조건에 맞는 첫 번째 요소 필터
                            .findFirst() // 첫 번째 일치하는 요소 반환
                            .orElse(null); // 없으면 null 반환
                },

                (param) -> new Employee(param),
                key
        );
        return employee;
    }

}