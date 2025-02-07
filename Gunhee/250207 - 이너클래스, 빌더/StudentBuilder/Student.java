package day05.StudentBuilder;

import lombok.*;

@ToString
@Builder
public class Student {
    // 필수 멤버
    private int id;
    private String name;
    private String major;

    // 선택멤버
    private String grade = "freshman";
    private String phoneNumber;
    private String address;

    // lombok 빌더를 사용하기 1
    public static StudentBuilder StudentBuilder(int id, String name, String major) {
        return builder().id(id).name(name).major(major);
    }


}
