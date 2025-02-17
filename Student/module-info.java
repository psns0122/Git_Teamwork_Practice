/**
 * Student Management Module
 *
 * <p>이 모듈은 학생 및 직원 관리 프로그램을 제공합니다.</p>
 *
 */
module StudentManagement {
    // 🌟 1. 외부에 공개할 패키지 (API용)
    exports Interface;
    exports Management;
    exports DTO;

    // 🔒 2. 내부 전용 패키지 (Reflection용으로만 공개)
    opens File;

}
