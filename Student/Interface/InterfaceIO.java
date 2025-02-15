package Interface;

import java.util.function.Function;
import java.util.function.Supplier;

public class InterfaceIO<T, U> {

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

    // DB 에서 object 를 탐색하는 함수
    public T search(Searchable<T> searchable, Function<U, T> supplier, U param) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        T item = supplier.apply(param);
        searchable.searchObject(item);
        return item;
    }

    // objects 를 정렬하는 함수
    public void sort(Sortable sortable) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        sortable.sortObject();
    }

    // objects 를 출력하는 함수
    public void print(Printable<T> printable, Supplier<T> supplier) {
        // 사용예 : io.add(item -> {}, param -> {});
        T item = supplier.get();
        printable.printObject(item);
    }

    // object 를 출력하는 함수
    public void print(Printable<T> printable, T item) {
        // 사용예 : io.add(item -> {});
        printable.printObject(item);
    }

    // 수정
    // 삭제

}
