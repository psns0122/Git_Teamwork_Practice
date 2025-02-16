package ObjectClass;
/**
 * 사원 정보를 저장하는 클래스
 */
public class Employee implements Comparable<Employee> {
    private String empNo;
    private String name;

    public Employee() {
    }

    public Employee(String name) {
    }

    public Employee(int empNo) {
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