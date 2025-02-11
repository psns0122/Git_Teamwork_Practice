import java.io.*;

public abstract class StudentDBIO extends ObjectIO implements StudentIO {
    private static final StudentDBIO INSTANCE;

    static {
        INSTANCE = new StudentManager();
    }

    protected StudentDBIO() { }

    // DB에서 데이터 읽어오는 함수 (READ)
    void readDB() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/StudentDB.dat"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            this.addStudent(line);
        }
        br.close();
    }

    // DB에 데이터 넣는 함수 (PUSH)
    void pushDB() throws IOException {
        StudentManager sm = (StudentManager) INSTANCE;
        PrintWriter pw = new PrintWriter("src/StudentDB.dat");
        for(Student s : sm.getStudentList()) {
            pw.println(s);
        }
        pw.close();
    }

    @Override
    public void input(String item) {
        this.addStudent(item);
    }

    @Override
    public void output() {
        this.sortStudent();
        this.printStudent();
    }

    @Override
    public Student search(String key) {
        return this.findStudent(key);
    }

    static StudentDBIO getInstance() {
        return INSTANCE;
    }

    public abstract Student findStudent(String sno);
    public abstract void sortStudent();
    public abstract void addStudent(String item);
    public abstract void printStudent();
}
