package Interface;
/**
 * 객체를 출력할 수 있는 함수형 인터페이스
 * @param <T> 출력할 객체의 타입
 */
@FunctionalInterface
public interface Printable<T> {
    void printObject(T student);
}
