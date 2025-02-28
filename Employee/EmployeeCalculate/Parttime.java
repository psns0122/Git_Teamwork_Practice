package EmployeeCalculate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parttime extends Employee {
    private int hourwage;
    private int workhour;
    private int wage;


    public Parttime(String name, String empNo, String address, String phone, Date hiredate,int hourwage, int workhour){
        super(name, empNo, address, phone, hiredate);
        this.hourwage = hourwage;
        this.workhour = workhour;


    }

    public int calculateWage(){
        return hourwage * workhour;
    }



    public void printParttimeInfo(){
        System.out.println("이름: " + getName() +
                " | 사번: " + getEmpNo() +
                " | 주소: " + getAddress() +
                " | 폰번호: " + getPhone() +
                " | 입사일: " + getFormattedHireDate() +
                " | 시급: " + getHourwage() +
                " | 근무시간: " + getWorkhour() +
                " | 총급여: " + calculateWage()

        );
    }


    private String getFormattedHireDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(super.getHireDate());
    }


    public int getWorkhour() {
        return workhour;
    }

    public void setWorkhour(int workhour) {
        this.workhour = workhour;
    }

    public int getHourwage() {
        return hourwage;
    }

    public void setHourwage(int hourwage) {
        this.hourwage = hourwage;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
}
