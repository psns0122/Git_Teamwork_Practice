import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StudentManager extends StudentDBIO {
    private ArrayList<Student> studentList = new ArrayList<Student>();

    // 리스트에 대한 접근 (입력, 출력, 찾기 등)
    @Override
    public Student findStudent(String sno) {
        for (Student student : studentList) {
            if (student.getSno().equals(sno)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void printStudent() {
        for(Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void sortStudent() {
        Collections.sort(studentList);
    }
    @Override
    public void addStudent(String item) {
        Student s = new Student();

        StringTokenizer st = new StringTokenizer(item);
        String studentID = st.nextToken();

        if (this.findStudent(studentID) != null) {
            return;
        }

        s.setSno(studentID);
        s.setName(st.nextToken());
        s.setKorean(Integer.parseInt(st.nextToken()));
        s.setEnglish(Integer.parseInt(st.nextToken()));
        s.setMath(Integer.parseInt(st.nextToken()));
        s.setScience(Integer.parseInt(st.nextToken()));
        this.calcTotal(s);
        this.calcAverage(s);
        this.calcGrade(s);

        studentList.add(s);
    }

    // 성적 계산
    void calcTotal(Student student) {
        student.setTotal(student.getKorean() + student.getEnglish() + student.getMath() + student.getScience());
    }

    void calcAverage(Student student) {
        student.setAverage((float) student.getTotal() / 4);
    }

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

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
