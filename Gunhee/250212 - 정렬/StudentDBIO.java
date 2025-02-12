import StudentIOInterface.StudentIO;

import java.io.*;

public abstract class StudentDBIO extends ObjectIO implements StudentIO {
    private static final StudentDBIO INSTANCE;

    static {
        INSTANCE = new StudentManager();
    }

    protected StudentDBIO() { }

    // DB에서 데이터 읽어오는 함수 (READ)
    @Override
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
    @Override
    void pushDB() throws IOException {
        StudentManager sm = (StudentManager) INSTANCE;
        PrintWriter pw = new PrintWriter("src/StudentDB.dat");
        for(Student s : sm.getStudentList()) {
            pw.println(s);
        }
        pw.close();
    }

    @Override
    void input(String item) {
        // DB INPUT
        this.addStudent(item);
    }

    @Override
    void output(int sortType, int key) {
        if (key == StudentIO.printAll) {
            // sortType 에 따라 새롭게 정렬
            this.sortStudent(sortType);

            // 전체 학생 출력
            printHead();
            this.printAll();
        }

        else {
            if (key == -1) {
                // 학생을 찾을 수 없을 때
                System.out.println("can not find student");
            }
            else {
                // 리스트 인덱스가 key 에 해당하는 학생만 출력
                printHead();
                this.printBy(key);
            }
        }
    }

    @Override
    int search(String key) {
        return this.findStudent(key);
    }

    static StudentDBIO getInstance() {
        return INSTANCE;
    }

    private void printHead() {
        System.out.println("학번\t\t\t이름\t\t국어\t\t영어\t\t수학\t\t과학\t\t합계\t\t평균\t\t학점");
    }

    public abstract int findStudent(String sno);
    public abstract void sortStudent(int sortType);
    public abstract void addStudent(String item);
    public abstract void printBy(int index);
    public abstract void printAll();
}
