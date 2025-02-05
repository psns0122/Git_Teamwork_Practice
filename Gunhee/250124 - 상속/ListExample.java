package day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    // bad example
    // ArrayList를 처리하는 메서드
    public void processArrayList(ArrayList<String> list) {
        list.add("ArrayList Item 1");
        list.add("ArrayList Item 2");
        System.out.println("ArrayList: " + list);
    }

    // bad example
    // LinkedList를 처리하는 메서드
    public void processLinkedList(LinkedList<String> list) {
        list.add("LinkedList Item 1");
        list.add("LinkedList Item 2");
        System.out.println("LinkedList: " + list);
    }

    // good example
    // List 인터페이스를 사용하는 메서드
    public void processList(List<String> list) {
        list.add("Common Item 1");
        list.add("Common Item 2");
        System.out.println("List (Interface): " + list);
    }

    // 메인 메서드로 테스트
    public static void main(String[] args) {
        ListExample example = new ListExample();

        // bad example
        // ArrayList 테스트
        ArrayList<String> arrayList = new ArrayList<>();
        example.processArrayList(arrayList);

        // bad example
        // LinkedList 테스트
        LinkedList<String> linkedList = new LinkedList<>();
        example.processLinkedList(linkedList);

        // good example
        // List 인터페이스 테스트 - ArrayList
        List<String> listAsArrayList = new ArrayList<>();
        example.processList(listAsArrayList);

        // good example
        // List 인터페이스 테스트 - LinkedList
        List<String> listAsLinkedList = new LinkedList<>();
        example.processList(listAsLinkedList);
    }
}
