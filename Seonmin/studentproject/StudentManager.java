import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StudentManager extends StudentDBIO { //StudentDBIO를 상속받음
    private ArrayList<Student> studentList = new ArrayList<Student>(); //studentList라는 ArrayList 생성

    // 리스트에 대한 접근 (입력, 출력, 찾기 등)
    //studentDBIO에서 find, sort, add, print, printAllStudent 추상메소드 상속 받아서 오버라이딩
    @Override
    public int findStudent(Object sno) {
        if(sno instanceof String){
            String stuNo = (String)sno;
        }
        for (int i = 0; i < studentList.size(); i++) { //i는 0부터 시작해 
            if (studentList.get(i).getSno().equals(sno)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sortStudent() {
        Collections.sort(studentList);
    }
    @Override
    public void addStudent(Object item) throws IllegalArgumentException {
        if(!(item instanceof String)){
            throw new IllegalArgumentException("잘못된 값입니다");
        }

        Student s = new Student();

        StringTokenizer st = new StringTokenizer((String)item);
        String studentID = st.nextToken();

        if (this.findStudent(studentID) != -1) {
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

    @Override
    public void printStudent(Object index) {
        System.out.println(studentList.get((Integer) index));
    }

    @Override
    public void printAll() {
        for (Student student : studentList) {
            System.out.println(student);
        }
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

}
