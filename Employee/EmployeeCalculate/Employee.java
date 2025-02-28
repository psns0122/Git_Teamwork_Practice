package EmployeeCalculate;

import java.util.Date;

public abstract class Employee {
    private String name;
    private String empNo;
    private String address;
    private String phone;
    private Date hireDate;


    public Employee(){

    }

    public Employee(String empNo, String name, String address, String phone, Date hireDate) {
        this.empNo = empNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hireDate = hireDate;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }







}
