import java.io.IOException;
import java.util.function.Function;

public abstract class ObjectIO {
    abstract void readDB() throws IOException;
    abstract void pushDB() throws IOException;
}
