package Interface;

@FunctionalInterface
public interface Searchable<T> {
    T searchObject(T item);
}
