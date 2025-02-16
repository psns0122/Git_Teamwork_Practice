import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Menu{
    enum By {
        num, name, score
    }

    static final int STUDENT = 1;
    static final int EMPLOYEE = 2;

    static final int ADD = 1;
    static final int SEARCH = 2;
    static final int PRINT = 3;
    static final int SAVE = 4;

    static Scanner sc = new Scanner(System.in);

    static void startSystem() throws IOException {
        int choice;

        while (true) {
            System.out.println();
            System.out.println("\t------------------------------");
            System.out.println("\t-       학교 관리 시스템       -");
            System.out.println("\t------------------------------");
            System.out.println("\t1. 학생관리\t\t2. 직원관리");
            System.out.println("\t3. 시스템 종료");
            System.out.println();
            System.out.print("\t입력: "); choice = sc.nextInt();

            if (choice == STUDENT) {
                // 학생관리
                ObjectDBIO<Student> manager = ObjectDBIO.getInstance(Student.class);
                Menu.studentSystem(manager);
            } else if (choice == EMPLOYEE) {
                // 직원관리
                ObjectDBIO<Employee> manager = ObjectDBIO.getInstance(Employee.class);
//            Menu.employeeSystem(manager);
            } else {
                System.out.println("\t학교 관리 시스템을 종료합니다.");
                break;
            }
        }
    }

    static void studentSystem(ObjectDBIO manager) throws IOException {
        int choice;

        // StudentDB 파일에서 정보 읽어오기
        manager.readDB();

        while (true) {
            System.out.println();
            System.out.println("\t------------------------------");
            System.out.println("\t-       학생 관리 시스템       -");
            System.out.println("\t------------------------------");
            System.out.println("\t1. 학생 등록\t\t2. 학생 검색");
            System.out.println("\t3. 전체학생 출력\t4. 변경사항 저장");
            System.out.println("\t5. 시스템 종료");
            System.out.println();
            System.out.print("\t입력: "); choice = sc.nextInt();
            System.out.println();

            // 1️⃣ 학생 등록
            if (choice == ADD) {
                StringBuffer item = new StringBuffer();
                System.out.println("\t등록할 학생 정보를 순서대로 입력하세요.");

                System.out.print("\t학번 : ");
                int sno = sc.nextInt();
                if (searchItem(manager, sno)) {
                    System.out.println("\n\t이미 존재하는 학번입니다.");
                    continue;
                } else {
                    item.append(sno + " ");
                }

                System.out.print("\t이름 : "); item.append(sc.next() + " ");
                System.out.print("\t국어점수 : "); item.append(checkValidScore(sc.nextInt()) + " ");
                System.out.print("\t수학점수 : "); item.append(checkValidScore(sc.nextInt()) + " ");
                System.out.print("\t과학점수 : "); item.append(checkValidScore(sc.nextInt()) + " ");
                System.out.print("\t영어점수 : "); item.append(checkValidScore(sc.nextInt()));

                String constItem = item.toString();
                addItem(manager, constItem);
                System.out.println("\t\n학생 [" + constItem + "] 등록을 성공적으로 마쳤습니다.");
            }

            // 2️⃣ 학생 검색
            else if (choice == SEARCH) {
                String key;

                System.out.println("\t검색할 학생의 학번 혹은 이름을 입력하세요.");
                System.out.println();
                System.out.print("\t검색어 : "); key = sc.next();

                if (key.matches("\\d+")) {
                    int sno = Integer.parseInt(key);
                    if (searchItem(manager, sno)) {
                        System.out.println("\n학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");
                        System.out.println(getStudent(manager, sno));
                    } else {
                        System.out.println("\n\t학번 " + sno + " 를 찾을 수 없습니다.");
                    }
                } else {
                    if (searchItem(manager, key)) {
                        System.out.println("\n학번\t\t이름\t국어\t영어\t수학\t과학\t총점\t평균\t학점");
                        System.out.println(getStudent(manager, key));
                    } else {
                        System.out.println("\n\t학생 " + key + " 를 찾을 수 없습니다.");
                    }
                }
            }

            // 3️⃣ 전체학생 출력
            else if (choice == PRINT) {
                int printType;

                // 3-1. 정렬
                System.out.println("\t정렬 방식을 선택하세요.");
                System.out.println("\t1. 학번순\t2. 이름순\t3. 성적순");
                System.out.println();
                System.out.print("\t입력: "); printType = sc.nextInt();

                switch (printType) {
                    case 1:
                        sort(manager, By.num);
                        break;
                    case 2:
                        sort(manager, By.name);
                        break;
                    case 3:
                        sort(manager, By.score);
                        break;
                }

                // 3-2. 출력
                System.out.println();
                printAll(manager);
            }
            // 4️⃣ 변경사항 저장
            else if (choice == SAVE) {
                manager.pushDB();
                System.out.println("\t성공적으로 저장 되었습니다.");
            }

            else {
                System.out.println("\t학생 관리 시스템을 종료합니다.");
                break;
            }
        }
    }

    static int checkValidScore(int score) {
        if (score < 0) {
            return 0;
        } else if (score > 100) {
            return 100;
        } else {
            return score;
        }
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
            return getStudent(manager, key) != null;
        } else if (manager.getType() == Employee.class) {
            return getEmployee(manager, key) != null;
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