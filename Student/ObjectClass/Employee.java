package ObjectClass;

public class Employee implements Comparable<Employee> {
    private String empNo;
    private String name;

    public Employee() {
    }

    public Employee(String name) {
    }

    @Override
    public String toString() {
        return "Employee{}";
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
}