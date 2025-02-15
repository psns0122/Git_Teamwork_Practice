package seonmin_0215.Interface;

import Interface.Addable;
import Interface.Printable;
import Interface.Searchable;
import Interface.Sortable;

import java.util.function.Function;
import java.util.function.Supplier;

public class InterfaceIO<T, U> {

    // DB 에 object 를 추가하는 함수
    // 3. param이 line 을 받아옴
    public void add(Addable<T> addable, Function<U, T> supplier, U param) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        // 4. param을 apply 함수로 전달 (-> supplier에 대한 람다식 구성 필요해짐)
        // 7. item을 전달 받음
        T item = supplier.apply(param);
        // 8. item을 addObject 함수로 전달 (-> addable에 대한 람다식 구성 필요해짐)
        addable.addObject(item);
    }

    // DB 에서 object 를 탐색하는 함수
    public void search(Searchable<T> searchable, Supplier<T> supplier) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        T item = supplier.get();
        searchable.searchObject(item);
    }

    // objects 를 정렬하는 함수
    public void sort(Sortable sortable) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        sortable.sortObject();
    }

    // object, 혹은 objects 를 출력하는 함수
    public void print(Printable<T> printable, Supplier<T> supplier) {
        // 사용예 : io.add(item -> System.out.println(item), Student::new);
        T item = supplier.get();
        printable.printObject(item);
    }

    // 수정
    // 삭제

}
