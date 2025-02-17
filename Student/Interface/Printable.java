package Interface;

/**
 * 객체 출력 기능을 제공하기 위한 함수형 인터페이스입니다.
 *
 * @param <T> 출력할 객체의 타입
 */
@FunctionalInterface
public interface Printable<T> {
    /**
     * 출력 기능을 수행하는 메서드입니다.
     * 주어진 객체를 출력합니다.
     *
     * @param item 출력할 객체
     */
    void printObject(T item);
}
