import java.io.IOException;

public class TESTMAIN {
    public static void main(String[] args) {
        ObjectIO m = StudentDBIO.getInstance();

        readDB(m);
        m.output();
        System.out.println("-----------------");
        System.out.println(m.search("2017103985"));
        m.input("2025102004 신입생 100 100 100 100 0 0 NONE");
        System.out.println("-----------------");
        m.output();
        pushDB(m);
    }

    public static void pushDB(ObjectIO m) {
        if (m instanceof StudentDBIO) {
            StudentDBIO s = (StudentDBIO) m;
            try {
                s.pushDB();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readDB(ObjectIO m) {
        if (m instanceof StudentDBIO) {
            StudentDBIO s = (StudentDBIO) m;
            try {
                s.readDB();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
