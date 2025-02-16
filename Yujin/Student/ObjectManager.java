import java.util.ArrayList;
import java.util.Iterator;

/**
 * 제네릭 타입의 객체를 관리하는 클래스
 * @param <T> 객체의 제네릭 타입
 */
public class ObjectManager<T> extends ObjectDBIO<T> implements Iterable<T> {
    /**
     * 객체 리스트
     */
    private ArrayList<T> objects = new ArrayList<>();

    /**
     * 생성자 - 제네릭 타입을 받아 초기화
     * @param type 제네릭 타입 클래스 객체
     */
    protected ObjectManager(Class<T> type) {
        super(type);
    }

    /**
     * 객체 리스트에 항목을 추가하는 메서드
     * @param item 추가할 객체
     */
    public void addObjectList(T item) {
        objects.add(item);
    }

    /**
     * Iterable 인터페이스 구현 - 객체 리스트 반복
     * @return 객체 리스트의 반복자
     */
    @Override
    public Iterator<T> iterator() {
        return this.objects.iterator();
    }
    /**
     * 객체 리스트 반환
     * @return 객체 리스트
     */
    public ArrayList<T> getObjects() {
        return objects;
    }
    /**
     * 객체 리스트 설정
     * @param objects 설정할 객체 리스트
     */
    public void setObjects(ArrayList<T> objects) {
        this.objects = objects;
    }
}
