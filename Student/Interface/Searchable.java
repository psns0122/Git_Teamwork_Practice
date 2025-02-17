package Interface;

/**
 * 객체 검색 기능을 제공하기 위한 함수형 인터페이스입니다.
 *
 * @param <T> 탐색할 객체의 타입
 */
@FunctionalInterface
public interface Searchable<T> {
    /**
     * 주어진 객체를 기반으로 탐색을 수행하는 메서드입니다.
     *
     * @param item 탐색할 기준 객체
     * @return 탐색된 결과 객체 (일치하는 항목이 없으면 null 반환)
     */
    T searchObject(T item);
}
