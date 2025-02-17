package ObjectClass;

/**
 * 직원(Employee) 클래스입니다.
 * 직원의 사번, 이름 및 기본 기능을 포함합니다.
 */
public class Employee implements Comparable<Employee> {
    /** 사번 */
    private String empNo;
    /** 이름 */
    private String name;

    //====생성자===========================

    /** 기본 생성자입니다. */
    public Employee() {}

    /**
     * 이름을 인자로 받는 생성자입니다.
     *
     * @param name 직원 이름
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * 사번을 인자로 받는 생성자입니다.
     *
     * @param empNo 직원 사번
     */
    public Employee(int empNo) {
        this.empNo = String.format("%06d", empNo);
    }

    //====오버라이딩 함수==================

    /**
     * 사번을 기준으로 직원을 비교하는 메서드입니다.
     * @param o 비교할 직원 객체
     * @return 비교 결과 (정렬용)
     */
    @Override
    public int compareTo(Employee o) {
        return this.empNo.compareTo(o.empNo);
    }

    /**
     * 직원 정보를 문자열로 반환합니다.
     * @return 직원 정보 문자열
     */
    @Override
    public String toString() {
        return String.format("사번: %s, 이름: %s", empNo, name);
    }

    /**
     * equals 메서드 - 사번을 기준으로 두 직원의 동일성을 비교합니다.
     * @param obj 비교할 객체
     * @return 사번이 같으면 true, 다르면 false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empNo.equals(employee.empNo);
    }

    /**
     * hashCode 메서드 - 사번을 기반으로 해시코드를 생성합니다.
     * @return 사번의 해시코드
     */
    @Override
    public int hashCode() {
        return empNo.hashCode();
    }

    //====getter, setter 함수============

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