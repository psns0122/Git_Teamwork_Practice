import java.io.IOException;

public abstract class ObjectIO {
    abstract void readDB() throws IOException;
    abstract void pushDB() throws IOException;

    abstract void input(String item);
    abstract void output(int sortType, int key);
    abstract int search(String key);
}
