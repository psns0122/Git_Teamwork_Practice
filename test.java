package day12;

import java.util.Scanner;

class Calculation {
    void addition(int a, int b){
        System.out.printf("두 수의 덧셈 : %d%n",a+b);
    }
    void subtraction(int a, int b){
        System.out.printf("두 수의 뺄셈 : %d%n",a-b);
    }
}

class Ingeritance01 extends Calculation{
    void multiplication(int a, int b){
        System.out.printf("두 수의 곱셈 : %d",a*b);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculation caluclation = new Calculation();
        Ingeritance01 obj = new Ingeritance01();

        System.out.println("두 수를 입력하시오");
        int a = sc.nextInt();
        int b = sc.nextInt();

        obj.addition(a,b);
        obj.subtraction(a,b);
        obj.multiplication(a,b);

    }
}





