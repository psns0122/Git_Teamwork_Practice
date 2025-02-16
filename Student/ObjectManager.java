import java.util.ArrayList;
import java.util.Iterator;

public class ObjectManager<T> extends ObjectDBIO<T> implements Iterable<T> {
    private ArrayList<T> objects = new ArrayList<>();

    protected ObjectManager(Class<T> type) {
        super(type);
    }

    // Iterable 인터페이스 메서드 구현
    @Override
    public Iterator<T> iterator() {
        return this.objects.iterator();
    }

    public ArrayList<T> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<T> objects) {
        this.objects = objects;
    }
}
