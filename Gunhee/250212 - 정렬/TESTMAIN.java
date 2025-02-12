import StudentIOInterface.StudentIO;
import StudentIOInterface.StudentOutput;

import java.io.IOException;

public class TESTMAIN {
    public static void main(String[] args) {
        ObjectIO m = StudentDBIO.getInstance();

        // DB에서 전체 학생 정보 읽어오기
        readDB(m);

        // DB에서 리스트로 옮겨온 데이터에 대해
        // 학번으로 정렬, 전체 옵션(null)로 출력 시도
        m.output(StudentIO.sortBySno, StudentIO.printAll);
        System.out.println("-----------------");

        // 검색 후 해당 학생만 출력 시도
        m.output(StudentIO.sortBySno, m.search("0000000000")); // 맨 처음 출력 시도
        m.output(StudentIO.sortBySno, m.search("2017103984")); // 맨 처음 출력 시도

        // 입력 시도
        m.input("2025102004 신입생 100 100 100 100 0 0 NONE");
        m.input("1100110111 신입생 100 100 100 100 0 0 NONE");
        System.out.println("-----------------");

        // 석차로 정렬, 전체 옵션(null)로 출력 시도
        m.output(StudentIO.sortByRank, StudentIO.printAll);

        // DB에 수정사항 저장하기
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
