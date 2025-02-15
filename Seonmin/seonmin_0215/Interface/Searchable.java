package seonmin_0215.Interface;

@FunctionalInterface
public interface Searchable<T> {
    T searchObject(T item);
}
