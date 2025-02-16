import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * 메뉴에서 제공하는 기능을 모은 클래스
 */
@SuppressWarnings("unchecked")
public class Menu{
    /**
     * 정렬 기준을 나타내는 열거형
     */
    enum By {
        num, name, score
    }
    /**
     * 데이터를 추가하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param data 추가할 데이터
     * @return 추가 성공 여부
     */
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
    /**
     * 객체들을 정렬하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param type 정렬 기준
     */
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
    /**
     * 전체 데이터 출력 메서드
     * @param manager 데이터베이스 관리 객체
     */
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
    /**
     * 특정 항목을 검색하는 메서드 (학번 또는 사번 기준)
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 학번 또는 사번
     * @return 검색 결과 여부
     */
    // 🔍 - 번호 중복 확인
    static boolean searchItem(ObjectDBIO manager, int key) {
        if (manager.getType() == Student.class) {
            return getStudent(manager, key) != null;
        } else if (manager.getType() == Employee.class) {
            return getEmployee(manager, key) != null;
        }
        return false;
    }
    /**
     * 특정 항목을 검색하는 메서드 (이름 기준)
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 이름
     * @return 검색 결과 여부
     */
    // 🔍 - 이름 중복 확인
    static boolean searchItem(ObjectDBIO manager, String key) {
        if (manager.getType() == Student.class) {
            return getStudent(manager, key) == null;
        } else if (manager.getType() == Employee.class) {
            return getEmployee(manager, key) == null;
        }
        return false;
    }
    /**
     * 학번으로 학생을 검색하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 학번
     * @return 해당 학번의 학생 객체
     */
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

    /**
     * 사번으로 직원을 검색하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 사번
     * @return 해당 사번의 직원 객체
     */
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
    /**
     * 학번으로 학생을 검색하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 학번
     * @return 해당 학번의 학생 객체
     */
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
    /**
     * 이름으로 직원을 검색하는 메서드
     * @param manager 데이터베이스 관리 객체
     * @param key 검색할 이름
     * @return 해당 이름의 직원 객체
     */
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