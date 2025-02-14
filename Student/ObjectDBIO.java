import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class ObjectDBIO<T> extends ObjectIO {
    // 타입별 싱글턴 인스턴스를 저장하는 맵
    private static final ConcurrentMap<Class<?>, ObjectDBIO<?>> INSTANCES;

    static {
        INSTANCES = new ConcurrentHashMap<>();

        // 미리 타입별 싱글톤
        INSTANCES.put(Student.class, new ObjectManager<Student>(Student.class));
        INSTANCES.put(Employee.class, new ObjectManager<Employee>(Employee.class));
    }

    @Override
    void readDB() throws IOException {
        // 파일 읽기
        BufferedReader br = null;

        ObjectManager<T> M = (ObjectManager<T>) INSTANCES.get(Student.class);

        // 1️⃣ 학생 데이터 처리
        if (M.getType() == Student.class) {
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
            // 학생 DB 연결
            br = new BufferedReader(new FileReader("src/File/StudentDB.dat"));

            while (true) {
                // 한 줄씩 읽기
                String line = br.readLine();
                // 줄이 비어있으면 종료
                if (line == null) break;

                InterfaceIO<Student, String> io = new InterfaceIO<>();
                io.add(
                        (item) -> {
                            M.getObjects().add((T)item);
                        },
                        (param) -> new Student(param),
                        line
                );
            }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
        }

        // 2️⃣ 직원 데이터 처리
        else if (M.getType() == Employee.class) {
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
            // 학생 DB 연결
            br = new BufferedReader(new FileReader("src/File/EmployeeDB.dat"));

            while (true) {
                // 한 줄씩 읽기
                String line = br.readLine();
                // 줄이 비어있으면 종료
                if (line == null) break;

                InterfaceIO<Employee, String> io = new InterfaceIO<>();
                io.add(
                        (item) -> {
                            M.getObjects().add((T)item);
                        },
                        (param) -> new Employee(param),
                        line
                );
            }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
        }

        br.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    void pushDB() throws IOException {
        PrintWriter pw = null;

        ObjectManager<T> M = (ObjectManager<T>) INSTANCES.get(Student.class);

        // 1️⃣ 학생 데이터 처리
        if (M.getType() == Student.class) {
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
            // 학생DB 연결
            pw = new PrintWriter("src/File/StudentDB.dat");

            // 제네릭 타입 T로 캐스팅 후 객체 리스트 반복
            for (T s : ((ObjectManager<T>) M)) {
                // 파일에 객체 정보를 출력
                System.out.println(s);
                pw.println(s);
            }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
        }

        // 2️⃣ 직원 데이터 처리
        else if (M.getType() == Employee.class) {
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
            // 직원DB 연결
            pw = new PrintWriter("src/File/EmployeeDB.dat");

            // 제네릭 타입 T로 캐스팅 후 객체 리스트 반복
            for (T s : ((ObjectManager<T>) M)) {
                // 파일에 객체 정보를 출력
                System.out.println(s);
                pw.println(s);
            }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////
        }

        pw.close();
    }

    @SuppressWarnings("unchecked")
    public static <T> ObjectDBIO<T> getInstance(Class<T> type) {
        // 타입별 싱글턴 관리 (computeIfAbsent 사용)
        return (ObjectDBIO<T>) INSTANCES.computeIfAbsent(type, key -> new ObjectDBIO<>());
    }

}
