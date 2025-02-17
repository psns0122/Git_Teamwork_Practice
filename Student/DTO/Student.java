package DTO;

import Interface.Calculable;

/**
 * 학생(Student) 클래스입니다.
 * 학생의 학번, 이름, 성적 및 성적 계산 기능을 포함합니다.
 */
public class Student implements Comparable<Student> {
    /** 학번 */
    private String sno;
    /** 이름 */
    private String name;
    /** 국어 점수 */
    private int korean;
    /** 영어 점수 */
    private int english;
    /** 수학 점수 */
    private int math;
    /** 과학 점수 */
    private int science;
    /** 총점 */
    private int total;
    /** 평균 */
    private float average;
    /** 학점 */
    private String grade;

    //====총점, 평균, 성적 구하는 메소드=====

    /**
     * 총점을 계산하는 메서드입니다.
     *
     * @param calculable 성적 계산을 위한 람다식
     * @return 총점 int
     */
    public int sum(Calculable calculable) {
        return calculable.calculate(korean,math,english,science);
    }

    /**
     * 평균을 계산하는 메서드입니다.
     *
     * @return 평균 점수
     */
    public float avg() {
        return total/4.0f;
    }

    /**
     * 학점을 계산하는 메서드입니다.
     *
     * @return 학점(A, B, C, D, F) string
     */
    public String grade(){
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    //====생성자===========================

    /**
     * 기본 생성자입니다.
     */
    public Student() {}

    /**
     * 이름을 인자로 받는 생성자입니다.
     *
     * @param name 학생 이름
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * 학번을 인자로 받는 생성자입니다.
     *
     * @param sno 학생 학번
     */
    public Student(int sno) {
        this.sno = String.format("%010d", sno);
    }

    //====오버라이딩 함수==================

    /**
     * 학번을 기준으로 학생을 비교하는 메서드입니다.
     *
     * @param o 비교할 학생 객체
     * @return 비교 결과 (정렬용)
     */
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

    /**
     * 학생 정보를 문자열로 반환합니다.
     *
     * @return 학생 정보 문자열
     */
    @Override
    public String toString() {
        return sno + " " + name + " " +
                korean + " " + english + " " + math + " " + science + " " +
                total + " " + average + " " + grade;
    }

    /**
     * equals 메서드 - 학번을 기준으로 두 학생의 동일성을 비교합니다.
     *
     * @param obj 비교할 객체
     * @return 학번이 같으면 true, 다르면 false
     */
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

    /**
     * hashCode 메서드 - 학번을 기반으로 해시코드를 생성합니다.
     *
     * @return 학번의 해시코드
     */
    @Override
    public int hashCode() {
        return sno.hashCode();
    }

    //====getter, setter 함수============

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
