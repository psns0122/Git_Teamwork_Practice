import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.*;

public class Student implements Comparable<Student> {
    private String sno;
    private String name;
    private List<Integer> subject = new ArrayList<>();
    private int total;
    private float average;
    private String grade;

    @Override
    public int compareTo(Student o) {
        // 기본 정렬 규칙 : 학번
        return Integer.compare(Integer.parseInt(this.sno), Integer.parseInt(o.sno));
    }

    @Override
    public String toString() {
        String str = subject.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\t\t"));

        return sno + "\t" + name + "\t" +
                str + "\t\t" + total + "\t\t" + average + "\t" + grade;
    }

    // indexOf()가 학번 비교를 할 수 있도록 equals() 오버라이드
    @Override
    public boolean equals(Object obj) {
        // 같은 객체일 경우 true
        if (this == obj) return true;

        // 클래스 타입이 다르거나 null 이면 false
        if (obj == null || getClass() != obj.getClass()) return false;

        // 학번만 비교했을 때, 동일하면 true, 다르면 false
        Student student = (Student) obj;
        return sno.equals(student.sno);
    }

    @Override
    public int hashCode() {
        return sno.hashCode();
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSubject() {
        return subject;
    }

    public void setSubject(List<Integer> subject) {
        this.subject = subject;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
