package Interface;

import java.util.function.Function;
import java.util.function.Supplier;
/**
 * 제네릭 타입에 맞춰 DB 작업을 수행하는 클래스
 * @param <T> 객체의 타입
 * @param <U> 입력 파라미터의 타입
 */
public class InterfaceIO<T, U> {
    /**
     * DB에 객체를 추가하는 함수
     * @param addable 객체를 추가하는 동작
     * @param supplier 객체를 생성하는 함수
     * @param param 객체 생성을 위한 파라미터
     */
    // DB 에 object 를 추가하는 함수
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
     * DB에서 객체를 검색하는 함수
     * @param searchable 객체를 검색하는 동작
     * @param supplier 객체를 생성하는 함수
     * @param param 검색을 위한 파라미터
     * @return 검색된 객체
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
     * 객체를 출력하는 함수
     * @param printable 객체를 출력하는 동작
     * @param supplier 객체를 생성하는 함수
     */
    public void print(Printable<T> printable, Supplier<T> supplier) {
        // 사용예 : io.add(item -> {}, param -> {});
        T item = supplier.get();
        printable.printObject(item);
    }

    /**
     * 객체를 출력하는 함수
     * @param printable 객체를 출력하는 동작
     * @param item 출력할 객체
     */
    public void print(Printable<T> printable, T item) {
        // 사용예 : io.add(item -> {});
        printable.printObject(item);
    }

    // 수정
    // 삭제

}
