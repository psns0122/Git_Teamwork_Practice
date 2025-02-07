package day05.StudentBuilder;

public class StudentMain {
    public static void main(String[] args) {
        // lombok 빌더를 사용하기 1
        Student p1 = Student.StudentBuilder(101, "parkgunhee", "computer").address("test").build();
        System.out.println(p1);

        Student p2 = Student.StudentBuilder(102, "hong", "computer").address("test").grade("4").phoneNumber("010-8127-2572").build();
        System.out.println(p2);
    }
}
