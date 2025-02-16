import Interface.InterfaceIO;
import ObjectClass.Employee;
import ObjectClass.Student;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
/**
 * 제네릭 타입을 활용한 데이터베이스 입출력 관리 클래스
 * @param <T> 객체의 제네릭 타입
 */
public class ObjectDBIO<T> extends ObjectIO {
    /**
     * 클래스 타입별 싱글톤 인스턴스를 저장하는 맵
     */
    // 더블 싱글톤 (타입을 구분할 수 있도록 처리하기 위해 필수)
    private static final ConcurrentMap<Class<?>, ObjectDBIO<?>> INSTANCES = new ConcurrentHashMap<>();
    /**
     * 현재 객체의 제네릭 타입을 저장하는 변수
     */
    private final Class<T> type;
    /**
     * 생성자 - 제네릭 타입을 받아 초기화
     * @param type 제네릭 타입 클래스 객체
     */
    protected ObjectDBIO(Class<T> type) {
        this.type = type;
    }
    /**
     * 현재 객체의 제네릭 타입을 반환
     * @return 제네릭 타입 클래스 객체
     */
    public Class<T> getType() {
        return type;
    }
    /**
     * 주어진 클래스 타입에 해당하는 싱글톤 ObjectDBIO 인스턴스를 반환
     * @param type 제네릭 타입 클래스 객체
     * @return 해당 타입의 ObjectDBIO 인스턴스
     */
    // 주어진 클래스 타입에 해당하는 싱글톤 ObjectDBIO 인스턴스를 반환
    // 없으면 ObjectManager<T>를 생성해 INSTANCES 에 등록 후 반환
    @SuppressWarnings("unchecked")
    public static <T> ObjectDBIO<T> getInstance(Class<T> type) {
        return (ObjectDBIO<T>) INSTANCES.computeIfAbsent(type, key -> new ObjectManager<>(type));
    }

    /**
     * 현재 타입(T)에 해당하는 ObjectManager<T> 인스턴스를 반환
     * @return ObjectManager 인스턴스 또는 null
     */
    @SuppressWarnings("unchecked")
    private ObjectManager<T> getManager() {
        return (ObjectManager<T>) INSTANCES.get(type);
    }
    /**
     * 데이터베이스에서 데이터를 읽어오는 메서드
     * @throws IOException 파일 읽기 오류 발생 시
     */
    @Override
    void readDB() throws IOException {
        BufferedReader br = null;
        // 현재 제네릭타입에 해당하는 인스턴스를 확보
        ObjectManager<T> M = getManager();

        // 1️⃣ 만약 현재 타입이 Student 라면
        if (M.getType() == Student.class) {
            // StudentDB로 연결
            br = new BufferedReader(new FileReader("File/StudentDB.dat"));

        // 2️⃣ 만약 현재 타입이 Employee 라면
        } else if (M.getType() == Employee.class) {
            // EmployeeDB로 연결
            br = new BufferedReader(new FileReader("File/EmployeeDB.dat"));
        }

        /// ////////////////////////////
        /// ////////////////////////////

        while (true) {
            // 한 줄씩 읽기
            String line = br.readLine();
            // 줄이 비어있으면 종료
            if (line == null) break;

            Menu.addItem(M, line);
        }

        /// ////////////////////////////
        /// ////////////////////////////


        if (br != null) br.close();
    }
    /**
     * 데이터베이스에 데이터를 저장하는 메서드
     * @throws IOException 파일 쓰기 오류 발생 시
     */
    @Override
    void pushDB() throws IOException {
        PrintWriter pw = null;
        ObjectManager<T> M = getManager();

        // 1️⃣ 만약 현재 타입이 Student 라면
        if (M.getType() == Student.class) {
            // StudentDB로 연결
            pw = new PrintWriter("File/StudentDB.dat");

        // 2️⃣ 만약 현재 타입이 Employee 라면
        } else if (M.getType() == Employee.class) {
            // EmployeeDB로 연결
            pw = new PrintWriter("File/EmployeeDB.dat");
        }
            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////

            // 제네릭 타입 T로 캐스팅 후 객체 리스트 반복
            for (T s : ((ObjectManager<T>) M)) {
                // 파일에 객체 정보를 출력
                pw.println(s);
            }

            /// /////////////////////////////////////////////
            /// /////////////////////////////////////////////

        if (pw != null) pw.close();
    }
}


