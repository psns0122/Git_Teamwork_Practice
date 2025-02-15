package ObjectClass;

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

    //====총점, 평균, 성적 구하는 메소드=====

    public int sum(Calculable calculable) {
        return calculable.calculate(korean,math,english,science);
    }

    public float avg() {
        return total/4.0f;
    }

    public String grade(){
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    //====================================

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

    public Student(int sno) {
        this.sno = Integer.toString(sno);
    }

    @Override
    public int compareTo(Student o) {
        // 기본 정렬 : 성적순으로 정렬
        //return Integer.compare(o.total,this.total);
        if (this.total < o.total) {
            return 1;
        } else if (this.total == o.total) {
            if (this.name.charAt(0) > o.name.charAt(0)) {
                return 1;
            } else {
            }
            return -1;
        }return -1;
    }

    @Override
    public String toString() {
        return sno + " " + name + " " +
                korean + " " + english + " " + math + " " + science + " " +
                total + " " + average + " " + grade;
    }

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
