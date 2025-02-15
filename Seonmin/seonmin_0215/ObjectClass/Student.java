package seonmin_0215.ObjectClass;

import Interface.Calculable;

public class Student implements Comparable<Student> {
    private String sno;
    private String name;
    private int korean;
    private int english;
    private int math;
    private int science;
    private int total;
    private float average;
    private String grade;

    public Student() {}

    public Student(String line) {
        String[] parts = line.split(" ");
        this.sno = parts[0];
        this.name = parts[1];
        this.korean = Integer.parseInt(parts[2]);
        this.english = Integer.parseInt(parts[3]);
        this.math = Integer.parseInt(parts[4]);
        this.science = Integer.parseInt(parts[5]);
    }

    public Student(String sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    public Student(String sno, String name, int science, int korean, int english, int math) {
        this.sno = sno;
        this.name = name;
        this.science = science;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(Integer.parseInt(this.sno), Integer.parseInt(o.sno));
    }

    @Override
    public String toString() {
        return sno + " " + name + " " +
                korean + " " + english + " " + math + " " + science + " " +
                total + " " + average + " " + grade;
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
    //================총점, 평균, 성적 구하는 메소드======

    public int sum(Calculable calculable) {
        return calculable.calculate(korean,math,english,science);

    }

    public float avg(Calculable calculable) {
        return sum(calculable)/4.0f;

    }

    public String grade(){
        double avg = this.average;
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";

    }

    //==========================

    @Override
    public int hashCode() {
        return sno.hashCode();
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

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
