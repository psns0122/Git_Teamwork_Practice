import java.io.IOException;
import java.util.function.Function;
/**
 * 데이터베이스 입출력을 위한 추상 클래스
 */
public abstract class ObjectIO {
    /**
     * 데이터베이스에서 데이터를 읽어오는 추상 메서드
     * @throws IOException 파일 읽기 오류 발생 시
     */
    abstract void readDB() throws IOException;
    /**
     * 데이터를 데이터베이스에 저장하는 추상 메서드
     * @throws IOException 파일 쓰기 오류 발생 시
     */
    abstract void pushDB() throws IOException;
}
