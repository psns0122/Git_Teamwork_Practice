package Interface;

/**
 * 객체 추가 기능을 제공하기 위한 함수형 인터페이스입니다.
 *
 * @param <T> 추가할 객체의 타입
 */
@FunctionalInterface
public interface Addable<T> {
    /**
     * 객체 추가 기능을 수행하는 메서드입니다.
     * 주어진 객체를 리스트나 컬렉션에 추가합니다.
     *
     * @param item 추가할 객체
     */
    void addObject(T item);
}
