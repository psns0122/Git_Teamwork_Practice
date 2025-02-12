package day03.interfaceEx.ex05.P3;

public class DaoExample {

    public static void dbWork(DataAccessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        //dbwork 호출
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }
}
