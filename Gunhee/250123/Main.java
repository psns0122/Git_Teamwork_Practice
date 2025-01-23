package day12;

import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Inheritance01 i01 = new Inheritance01();

        // 추가 요구사항 : 숫자를 입력받아서 연산하기
        bw.write("첫번째 정수를 입력하세요 : "); bw.flush();
        int x = Integer.parseInt(br.readLine());
        bw.write("두번째 정수를 입력하세요 : "); bw.flush();
        int y = Integer.parseInt(br.readLine());

        // 추가 요구사항 : 연산자 종류를 선택 가능하게
        bw.write("다음중 연산자의 종류를 고르세요 (+,-,*) : "); bw.flush();
        char op = String.valueOf(br.readLine()).charAt(0);

        switch (op) {
            case '+':
                bw.write(String.format("두 수의 덧셈 : %d\n", i01.addition(x, y))); bw.flush();
                break;
            case '-':
                if (x < y) {
                    int temp = x;
                    x = y;
                    y = x;
                }

                bw.write(String.format("두 수의 뺄셈 : %d\n", i01.subtraction(x, y))); bw.flush();
                break;
            case '*':
                bw.write(String.format("두 수의 곱셈 : %d\n", i01.multiplication(x, y))); bw.flush();
                break;
            default:
                bw.write("잘못된 연산자입니다.");
        }
    }
}
