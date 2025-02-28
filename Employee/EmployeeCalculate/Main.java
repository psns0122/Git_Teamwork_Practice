package EmployeeCalculate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        System.out.println("1. EmployeeCalculate.Fulltime | 2. EmployeeCalculate.Parttime | 번호를 입력하세요.\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if(choice == 1) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            List<Fulltime> employees = new ArrayList<>();
            employees.add(new Fulltime("Alice", "E001", "Seoul", "010-1234-5678", dateFormat.parse("2022-03-15"), 90, 3000000));
            employees.add(new Fulltime("Bob", "E002", "Busan", "010-2345-6789", dateFormat.parse("2019-04-23"), 85, 3200000));
            employees.add(new Fulltime("Charlie", "E003", "Daegu", "010-3456-7890", dateFormat.parse("2021-05-15"), 95, 3100000));
            employees.add(new Fulltime("David", "E004", "Incheon", "010-4567-8901", dateFormat.parse("2010-07-09"), 80, 2900000));
            employees.add(new Fulltime("Eve", "E005", "Gwangju", "010-5678-9012", dateFormat.parse("2012-09-15"), 88, 3300000));

            System.out.println("=== 성과 평가 결과 ===");

            // 정렬
            Fulltime.sortByPerformance(employees);

            // 성과 평가
            for (Fulltime employee : employees) {
                employee.calculateRankAndPercentage(employees); // 순위 및 백분율 계산
                employee.assignGrade(); // 성과 등급 부여
                employee.calculateSalaryIncrease(); // 월급 인상 계산
            }

            // 정보 출력
            for (Fulltime employee : employees) {
                employee.printFulltimeInfo();
            }

        }else if(choice == 2) {
            List<Parttime> parttimeEmployees = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parttimeEmployees.add(new Parttime("Alice", "P001", "Seoul", "010-1234-5678", dateFormat.parse("2023-01-15"), 10000, 160));
            parttimeEmployees.add(new Parttime("Bob", "P002", "Busan", "010-2345-6789", dateFormat.parse("2022-05-10"), 12000, 150));
            parttimeEmployees.add(new Parttime("Charlie", "P003", "Daegu", "010-3456-7890", dateFormat.parse("2021-10-25"), 11000, 140));
            parttimeEmployees.add(new Parttime("David", "P004", "Incheon", "010-4567-8901", dateFormat.parse("2023-07-05"), 9500, 180));
            parttimeEmployees.add(new Parttime("Eve", "P005", "Gwangju", "010-5678-9012", dateFormat.parse("2022-12-30"), 13000, 170));

            for (Parttime employee : parttimeEmployees) {

                employee.printParttimeInfo();
            }





        }



    }
}
