package Interface;
/**
 * 객체를 검색할 수 있는 함수형 인터페이스
 * @param <T> 객체의 타입
 */
@FunctionalInterface
public interface Searchable<T> {
    T searchObject(T item);
}
