package Interface;
/**
 * 추가할 수 있는 객체를 정의하는 함수형 인터페이스
 * @param <T> 객체의 타입
 */
@FunctionalInterface
public interface Addable<T> {
    void addObject(T item);
}
