import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class ObjectDBIO<T> extends ObjectIO {
    // 더블 싱글톤 (타입을 구분할 수 있도록 처리하기 위해 필수)
    private static final ConcurrentMap<Class<?>, ObjectDBIO<?>> INSTANCES = new ConcurrentHashMap<>();
    // 현재 객체의 제네릭 타입을 저장할 type 변수
    private final Class<T> type;

    // 생성자에서 생성당시부터 제네릭 타입을 받아옴
    protected ObjectDBIO(Class<T> type) {
        this.type = type;
    }

    // 현재 객체의 제네릭 타입을 반환
    public Class<T> getType() {
        return type;
    }

    // 주어진 클래스 타입에 해당하는 싱글톤 ObjectDBIO 인스턴스를 반환
    // 없으면 ObjectManager<T>를 생성해 INSTANCES 에 등록 후 반환
    @SuppressWarnings("unchecked")
    public static <T> ObjectDBIO<T> getInstance(Class<T> type) {
        return (ObjectDBIO<T>) INSTANCES.computeIfAbsent(type, key -> new ObjectManager<>(type));
    }

    // 현재 타입(T)에 해당하는 ObjectManager<T> 인스턴스를 INSTANCES 에서 반환
    // 해당 타입이 없으면 null 반환
    @SuppressWarnings("unchecked")
    private ObjectManager<T> getManager() {
        return (ObjectManager<T>) INSTANCES.get(type);
    }

    @Override
    void readDB() throws IOException {
        BufferedReader br = null;
        // 현재 제네릭타입에 해당하는 인스턴스를 확보
        ObjectManager<T> M = getManager();

        // 1️⃣ 만약 현재 타입이 Student 라면
        if (M.getType() == Student.class) {
            // StudentDB로 연결
            br = new BufferedReader(new FileReader("src/File/StudentDB.dat"));
            InterfaceIO<Student, String> io = new InterfaceIO<>();

            /// ////////////////////////////
            /// ////////////////////////////

            while (true) {
                // 한 줄씩 읽기
                String line = br.readLine();
                // 줄이 비어있으면 종료
                if (line == null) break;

                io.add(
                        (item) -> {
                            M.getObjects().add((T)item);
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

                        line
                );
            }

            /// ////////////////////////////
            /// ////////////////////////////

        // 2️⃣ 만약 현재 타입이 Employee 라면
        } else if (M.getType() == Employee.class) {
            // EmployeeDB로 연결
            br = new BufferedReader(new FileReader("src/File/EmployeeDB.dat"));
            InterfaceIO<Employee, String> io = new InterfaceIO<>();

            /// ////////////////////////////
            /// ////////////////////////////

            while (true) {
                // 한 줄씩 읽기
                String line = br.readLine();
                // 줄이 비어있으면 종료
                if (line == null) break;

                io.add(
                        (item) -> {
                            M.getObjects().add((T)item);
                        },

                        (param) -> {
                            Employee employee = new Employee(param);

                            // TODO 급여계산

                            return employee;
                        },

                        line
                );
            }

            /// ////////////////////////////
            /// ////////////////////////////
        }


        if (br != null) br.close();
    }

    @Override
    void pushDB() throws IOException {
        PrintWriter pw = null;
        ObjectManager<T> M = getManager();

        // 1️⃣ 만약 현재 타입이 Student 라면
        if (M.getType() == Student.class) {
            // StudentDB로 연결
            pw = new PrintWriter("src/File/StudentDB.dat");
            System.out.println("학생 push");

        // 2️⃣ 만약 현재 타입이 Employee 라면
        } else if (M.getType() == Employee.class) {
            // EmployeeDB로 연결
            pw = new PrintWriter("src/File/EmployeeDB.dat");
            System.out.println("직원 push");
        }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////

            // 제네릭 타입 T로 캐스팅 후 객체 리스트 반복
            for (T s : ((ObjectManager<T>) M)) {
                // 파일에 객체 정보를 출력
                System.out.println(s);
                pw.println(s);
            }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////

        if (pw != null) pw.close();
    }
}


