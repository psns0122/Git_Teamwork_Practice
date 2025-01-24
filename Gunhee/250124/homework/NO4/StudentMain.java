package day13.homework.NO4;

class Student {
    String name;
    String subject;
    int fee;
    double returnFee;

    Student(String name, String subject, int fee) {
        this.name = name;
        this.subject = subject;
        this.fee = fee;
    }

    void calcReturnFee() {
        if (this.subject.equals("javaprogram")) {
            this.returnFee = this.fee * ((double)(25)/100);
        } else if (this.subject.equals("jspprogram")) {
            this.returnFee = this.fee * ((double)(20)/100);
        }
    }

    void print() {
        System.out.printf("%s 씨의 과정명은 %s 이고 교육비는 %d 이며 환급금은 %.2f 입니다.\n", this.name, this.subject, this.fee, this.returnFee);
    }


}

public class StudentMain {
    public static void main(String args[]){
        Student stu = new Student("장동건", "jspprogram", 500000);
        stu.calcReturnFee();
        stu.print();
    }

}
