import java.io.IOException;

/**
 * 각종 입출력(IO)을 위한 추상 클래스입니다.
 * 데이터베이스, 혹은 파일의 읽기 및 저장 기능을 제공하며,
 * 하위 클래스(ObjectDBIO)가 구체적인 기능을 구현합니다.
 */
public abstract class ObjectIO {
    /**
     * 데이터베이스에서 데이터를 읽어오는 추상 메서드입니다.
     * 하위 클래스에서 구체적으로 구현됩니다.
     *
     * @throws IOException 입출력 과정에서 오류가 발생한 경우
     */
    abstract void readDB() throws IOException;

    /**
     * 데이터베이스에 데이터를 저장하는 추상 메서드입니다.
     * 하위 클래스에서 구체적으로 구현됩니다.
     *
     * @throws IOException 입출력 과정에서 오류가 발생한 경우
     */
    abstract void pushDB() throws IOException;
}
