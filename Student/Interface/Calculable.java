package Interface;

/**
 * 성적 계산 기능을 제공하기 위한 함수형 인터페이스입니다.
 */
@FunctionalInterface
public interface Calculable {
    /**
     * 계산 기능을 수행하는 메서드입니다.
     * 주어진 점수들을 기반으로 계산 결과를 반환합니다.
     *
     * @param korean 국어 점수
     * @param math 수학 점수
     * @param english 영어 점수
     * @param science 과학 점수
     * @return 계산된 결과 값 (예: 총점)
     */
    int calculate(int korean, int math, int english, int science);
}