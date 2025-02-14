import java.io.IOException;

public abstract class ObjectIO {
    abstract void readDB() throws IOException; //DB 파일을 읽어오는 추상메소드
    abstract void pushDB() throws IOException; //DB로 파일을 업로드하는 추상메소드

    abstract void input(String item);//item 문자열을 받아 입력하는 추상메소드
    abstract void output(Integer type);//정수형 type을 받아 출력하는 추상메소드
    abstract int search(String key);// key(학번) 문자열을 받아 사원 or 학생을 찾는 추상 메소드
}
