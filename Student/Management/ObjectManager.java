package Management;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 객체를 관리하는 클래스입니다.
 * 제네릭 타입을 사용해 다양한 객체(Student, Employee 등)를 관리할 수 있습니다.
 * ObjectDBIO를 상속하며, Iterable 인터페이스를 구현해 반복 처리가 가능합니다.
 *
 * @param <T> 관리할 객체의 제네릭 타입
 */
public class ObjectManager<T> extends ObjectDBIO<T> implements Iterable<T> {
    /**
     * 관리할 객체들의 리스트입니다.
     */
    private ArrayList<T> objects = new ArrayList<>();

    /**
     * 생성자 - 제네릭 타입을 받아 ObjectDBIO를 초기화합니다.
     *
     * @param type 객체의 클래스 타입
     */
    protected ObjectManager(Class<T> type) {
        super(type);
    }

    /**
     * Iterable 인터페이스 구현 - 객체 리스트 반복
     *
     * @return 객체 리스트의 반복자(Iterator)
     */
    @Override
    public Iterator<T> iterator() {
        return this.objects.iterator();
    }

    /**
     * 객체 리스트를 반환합니다.
     *
     * @return 관리 중인 객체들의 리스트
     */
    public ArrayList<T> getObjects() {
        return objects;
    }

    /**
     * 객체 리스트를 설정합니다.
     *
     * @param objects 새롭게 설정할 객체 리스트
     */
    public void setObjects(ArrayList<T> objects) {
        this.objects = objects;
    }
}
