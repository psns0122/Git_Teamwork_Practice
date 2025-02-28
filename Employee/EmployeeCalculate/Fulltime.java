package EmployeeCalculate;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Fulltime extends Employee {
// 데이터베이스에 들어가지 않아도 되는 필드는 추가하지 않는 것을 권장

    private int result; // 실적
    private char resultGrade; // 성과등급
    private int basicSalary; // 인상 전 월급
    private int rank; // 순위
    private double percentage; // 백분율
    private int salaryIncreaseAmount; // 인상된 월급 금액

    public Fulltime(){

    }

    public Fulltime(String name, String empNo, String address, String phone, Date hiredate,
                    int result, int basicSalary){
        super(name, empNo, address, phone, hiredate);
        this.result = result;
        this.resultGrade = 'N'; // 기본값
        this.basicSalary = basicSalary;
    }

    //  실적을 기준으로 내림차순 정렬하는 메서드
    public static void sortByPerformance(List<Fulltime> employees) {
        employees.sort(Comparator.comparingInt(Fulltime::getResult).reversed());
    }

    // 순위 및 백분율 계산하는 메서드
    public void calculateRankAndPercentage(List<Fulltime> employees) {
        int totalEmployee = employees.size();
        this.rank = employees.indexOf(this) + 1; // 1위부터 시작
        this.percentage = ((double) rank / totalEmployee) * 100;
    }

    //  성과 등급 부여하는 메서드
    public void assignGrade() {
        if (percentage <= 10) {
            this.resultGrade = 'A';
        } else if (percentage <= 30) {
            this.resultGrade = 'B';
        } else if (percentage <= 50) {
            this.resultGrade = 'C';
        } else {
            this.resultGrade = 'F';
        }
    }

    // 성과 등급에 따라 월급 인상 계산하는 메서드
    public void calculateSalaryIncrease() {
        double increaseRate;
        switch (resultGrade) {
            case 'A': increaseRate = 0.10; break; // 10% 인상
            case 'B': increaseRate = 0.07; break; // 7% 인상
            case 'C': increaseRate = 0.03; break; // 3% 인상
            default: increaseRate = 0.0; break; //  인상 없음
        }
        this.salaryIncreaseAmount = (int) (basicSalary * increaseRate);
        this.basicSalary += salaryIncreaseAmount; // 인상된 월급 적용
    }

    // ⃣ 직원 정보 출력 메서드
    public void printFulltimeInfo() {
        System.out.println("이름: " + getName() +
                " | 사번: " + getEmpNo() +
                " | 주소: " + getAddress() +
                " | 폰번호: " + getPhone() +
                " | 입사일: " + getFormattedHireDate() +
                " | 실적: " + result +
                " | 순위: " + rank +
                " | 백분율: " + String.format("%.2f", percentage) + "%" +
                " | 성과: " + resultGrade +
                " | 기존 월급: " + (basicSalary - salaryIncreaseAmount) +
                " | 인상된 월급: " + basicSalary);
    }

    // 입사일을 yyyy-MM-dd 형식으로 변환하여 출력하는 메서드
    public String getFormattedHireDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(super.getHireDate());
    }





    public char getResultGrade() {
        return resultGrade;
    }

    public void setResultGrade(char resultGrade) {
        this.resultGrade = resultGrade;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
