package day01.homework2.NO2_2;

public class Video extends Content {
    // 생성자
    Video(String title, String genre) {
        // 부모 클래스 생성자 호출
        super(title);
        this.genre = genre;
    }

    // 추상 메소드 오버라이딩
    @Override
    void totalPrice() {
        switch(this.genre) {
            case "new":
                this.price = 2000;
                break;
            case "comic":
                this.price = 1500;
                break;
            case "child":
                this.price = 1000;
                break;
            default:
                this.price = 500;
        }
    }

    // 멤버 변수
    String genre;
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
