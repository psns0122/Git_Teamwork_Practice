import java.io.IOException;

public abstract class ObjectIO {
    abstract void readDB() throws IOException;
    abstract void pushDB() throws IOException;
}
