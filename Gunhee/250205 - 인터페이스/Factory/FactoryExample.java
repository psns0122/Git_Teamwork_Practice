package day03.Factory;

public class FactoryExample {

    public static void main(String[] args) {
        // ===== 1st Car Factory Information
        // Factory Name: CarABC
        // openHour: 7 AM, closeHour: 9 PM
        CarFactory CarABC = new CarFactory("CarABC", 7, 21);
        // ===== 2nd Car Factory Information
        // Factory Name: CarXYZ
        // openHour: 8 AM, closeHour: 7 PM
        CarFactory CarXYZ = new CarFactory("CarXYZ", 8, 19);
        // ===== 1st TV Factory Information
        // Factory Name: TVABC
        // openHour: 8 AM, closeHour: 5 PM
        TVFactory TVABC = new TVFactory("TVABC", 8, 17);
        // ===== 2nd TV Factory Information
        // Factory Name: TVXYZ
        // openHour: 9 AM, closeHour: 6 PM
        TVFactory TVXYZ = new TVFactory("TVXYZ", 9, 18);

        FactoryExample ex = new FactoryExample();
        // 각 공장 별로기술력값에 따른 하루 생산량과 파트너 사 협력 시 추가 생산량을 알아본다
        ex.getResult(CarABC, 'A', CarXYZ);
        ex.getResult(CarXYZ, 'B', CarABC);
        ex.getResult(TVABC, 'A', TVXYZ);
        ex.getResult(TVXYZ, 'B', TVABC);

    }

    public void getResult(Factory mainFactory, char mainFactorySkill, IWorkingTogether partner) {

        System.out.println("* " + mainFactory.getFactoryName() +
                " 공장의 하루 생산량과 파트너 공장 협력 시 추가 생산량은 다음과 같다.");

        // 공장의 하루 생산량
        System.out.println("하루 생산량 = " + mainFactory.makeProducts(mainFactorySkill));

        // 파트너 공장의 협력시 추가 생산량
//        try {
//            Factory tempFactory = (Factory) partner;
//            System.out.println("파트너 공장 [" + tempFactory.getFactoryName() + "] 협력 시 추가 생산량 = " +
//                    ((IWorkingTogether)mainFactory).workTogether(partner));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("파트너 공장 [익명] 협력 시 추가 생산량 = " +
//                    ((IWorkingTogether)mainFactory).workTogether(partner));
//        }

        System.out.println("파트너 공장 [" + getName(partner) + "] 협력 시 추가 생산량 = " +
                ((IWorkingTogether)mainFactory).workTogether(partner));

        System.out.println("--------------------------------------------------------------");
    }

    public String getName(IWorkingTogether partner) {
        String nameTemp = "";
        if (partner instanceof CarFactory c) {
            nameTemp = c.getFactoryName();
        } else if (partner instanceof TVFactory t) {
            nameTemp =  t.getFactoryName();
        }
        return nameTemp;
    }

}
