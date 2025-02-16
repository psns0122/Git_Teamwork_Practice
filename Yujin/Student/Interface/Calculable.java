package Interface;
/**
 * 계산을 할 수 있는 함수형 인터페이스
 */
@FunctionalInterface
public interface Calculable {
    /**
     * 4개의 과목을 바탕으로 총합을 계산하는 메서드
     * @param korean 국어 점수
     * @param math 수학 점수
     * @param english 영어 점수
     * @param science 과학 점수
     * @return 총합
     */
    int calculate(int korean, int math, int english, int science);
}