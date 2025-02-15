package seonmin_0215.Interface;
@FunctionalInterface
public interface Calculable<Student> {
    public int calculate(int korean, int math, int english, int science);
}
