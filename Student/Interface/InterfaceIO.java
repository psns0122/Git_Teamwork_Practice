package Interface;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * InterfaceIO 클래스입니다.
 * 다양한 기능 인터페이스(Addable, Searchable, Printable 등)를 호출하여
 * 객체 추가, 탐색, 출력 등의 작업을 수행할 수 있도록 합니다.
 *
 * @param <T> 처리할 객체의 타입
 * @param <U> 입력 데이터의 타입
 */
public class InterfaceIO<T, U> {

    /**
     * 객체를 추가하는 메서드입니다.
     *
     * @param addable 객체 추가 인터페이스 (람다식으로 구현)
     * @param supplier 객체 생성 인터페이스 (람다식으로 구현)
     * @param param 입력 데이터 (예: 문자열)
     */
    // 3. param이 line 을 받아옴
    public void add(Addable<T> addable, Function<U, T> supplier, U param) {
        // 사용예 : io.add(item -> {}, param -> {}, param);
        // 4. param을 apply 함수로 전달 (-> supplier에 대한 람다식 구성 필요해짐)
        // 7. item을 전달 받음
        T item = supplier.apply(param);
        // 8. item을 addObject 함수로 전달 (-> addable에 대한 람다식 구성 필요해짐)
        addable.addObject(item);
    }

    /**
     * 객체를 탐색하는 메서드입니다.
     *
     * @param searchable 객체 탐색 인터페이스 (람다식으로 구현)
     * @param supplier 객체 생성 인터페이스 (람다식으로 구현)
     * @param param 탐색할 키 값
     * @return 탐색된 객체 또는 null
     */
    public T search(Searchable<T> searchable, Function<U, T> supplier, U param) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        T item = supplier.apply(param);
        // item 은 임시 객체,
        // searchable.searchObject()가 찾은 실제 객체 반환
        return searchable.searchObject(item);
    }

//    // objects 를 정렬하는 함수
//    public void sort(Sortable sortable) {
//        // 사용예 : io.add(item -> System.out.println(item), Student::new);
//        sortable.sortObject();
//    }

    /**
     * 객체를 출력하는 메서드입니다.
     *
     * @param printable 객체 출력 인터페이스 (람다식으로 구현)
     * @param supplier 객체 생성 인터페이스 (람다식으로 구현)
     */
    public void print(Printable<T> printable, Supplier<T> supplier) {
        // 사용예 : io.add(item -> {}, param -> {});
        T item = supplier.get();
        printable.printObject(item);
    }

    // 수정
    // 삭제
}
