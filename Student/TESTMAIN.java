import java.io.IOException;

public class TESTMAIN {
    public static void main(String[] args) {
        ObjectIO m = StudentDBIO.getInstance();

        readDB(m);
        m.output(0);
        System.out.println("-----------------");
        m.output(m.search("2017103985"));
        m.output(m.search("1111111111"));
        m.input("2025102004 신입생 100 100 100 100 0 0 NONE");
        m.input("0000000000 신입생 100 100 100 100 0 0 NONE");
        System.out.println("-----------------");
        m.output(0);
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
