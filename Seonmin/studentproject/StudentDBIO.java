import java.io.*;

public abstract class StudentDBIO extends ObjectIO implements StudentIO {
    private static final StudentDBIO INSTANCE;

    static {
        INSTANCE = new StudentManager();
    }

    protected StudentDBIO() { } //StudentDBIO 기본 생성자

    // DB에서 데이터 읽어오는 함수 (READ)
    // objectIO 추상메소드를 구현
    @Override
    void readDB() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/StudentDB.dat"));// 학생 데이터 파일 입력
        while (true) {
            String line = br.readLine(); //BufferedReader로 한줄씩 계속 읽어들이기
            if (line == null) break; // 읽어들일 것이 없다면 break
            this.addStudent(line); //addStudent(String item)는 StudentInput 인터페이스의 메소드
        }
        br.close(); //끝났으면 닫기
    }

    // DB에 데이터 넣는 함수 (PUSH)
    //ObjectIO pushDB() 추상메소드를 구현
    @Override
    void pushDB() throws IOException {
        StudentManager sm = (StudentManager) INSTANCE; //INSTANCE는 StudentDBIO 타입이므로 Manager 로 다운캐스팅
        PrintWriter pw = new PrintWriter("src/StudentDB.dat"); // PrintWriter는 텍스트 출력에 사용되는 클래스
        for(Student s : sm.getStudentList()) { //StudentList는 StudentManager의 private ArrayList
            pw.println(s);
        }
        pw.close();
    }

    // objectIO의 input(String item), output(int type), search(String key) 추상메소드를 구현

    @Override
    void input(String item) {
        // DB INPUT
        this.addStudent(item);
    }

    @Override
    void output(Integer type) {
        //DB OUTPUT
        if (type == null) { // 받아온 정수타입이 null이라면 모두 출력하고 리턴
            this.printAll(); //StudentOutput 인터페이스의 printAll() 추상메소드
            return;
        }

        if (type == -1) { //받아온 정수타입이 -1(오류가 나면?, 일치하는게 없다면?)
            System.out.println("can not find student");
        } else if (type >= 0) { // 받아온 정수타입이 0보다 크다면 그 타입의 학생을 출력
            this.printStudent(type); // StudentOutput 인터페이스의 printStudent(int index) 추상메소드
        }
    }

    @Override
    int search(String key) {
        return this.findStudent(key);
    }
    //DB SEARCH: String key(학번)을 받아서 SeachStudent 인터페이스의 추상메소드인 findStudent에 key를 매개변수로 넣어 리턴


    static StudentDBIO getInstance() {
        return INSTANCE;
    } // static 메서드는 인스턴스 없이 호출가능, StudentDBIO의 INSTANCE를 불러오는 메소드


    // find, sort, add, print, printAll을 한번 더 추상메소드로 선언함으로써 StudentManager로 떠넘김

    public abstract int findStudent(Object sno);
    public abstract void sortStudent();

    public abstract void printStudent(Object index);

    public abstract void addStudent(Object item) throws IllegalArgumentException;

    public abstract void printAll();
}
