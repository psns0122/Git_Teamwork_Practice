import StudentIOInterface.StudentIO;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class StudentManager extends StudentDBIO {
    private ArrayList<Student> studentList = new ArrayList<Student>();

    // 리스트에 대한 접근 (입력, 출력, 찾기 등)
    @Override
    public int findStudent(String sno) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSno().equals(sno)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sortStudent(int sortType) {
        // 학생을 학번에 따라 정렬
        if (sortType == StudentIO.sortBySno) {
            Collections.sort(studentList);
        } else {
            // 학생을 석차에 따라 정렬
            studentList.sort(Comparator.comparing(Student::getTotal).reversed());
        }
    }

    @Override
    public void addStudent(String item) {
        Student s = new Student();

        StringTokenizer st = new StringTokenizer(item);
        String studentID = st.nextToken();

        if (this.findStudent(studentID) != -1) {
            return;
        }

        // 학번, 이름 입력
        s.setSno(studentID);
        s.setName(st.nextToken());

        // 성적 입력
        s.getSubject().add(Integer.parseInt(st.nextToken()));
        s.getSubject().add(Integer.parseInt(st.nextToken()));
        s.getSubject().add(Integer.parseInt(st.nextToken()));
        s.getSubject().add(Integer.parseInt(st.nextToken()));

        // 성적 계산
        this.calcTotal(s);
        this.calcAverage(s);
        this.calcGrade(s);

        studentList.add(s);
    }

    // 특정 학생 출력
    @Override
    public void printBy(int key) {
        System.out.println(studentList.get(key));
    }

    // 전체 학생 출력
    @Override
    public void printAll() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // 성적 합계 계산
    void calcTotal(Student student) {
        student.setTotal(student.getSubject().stream().mapToInt(Integer::intValue).sum());
    }

    // 성적 평균 계산
    void calcAverage(Student student) {
        student.setAverage((float) student.getTotal() / 4);
    }

    // 성적 학점 계산
    void calcGrade(Student student) {
        switch ((int) (student.getAverage() / 10)) {
            case 10:
            case 9:
                student.setGrade("A");
                break;
            case 8:
                student.setGrade("B");
                break;
            case 7:
                student.setGrade("C");
                break;
            case 6:
                student.setGrade("D");
                break;
            default:
                student.setGrade("F");
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

}
