package day13.homework.class실습;

public class Book {
    private String title;
    private int price;

    //생성자
    public Book(){}
    public Book(String title, int price){
        this.title=title;
        this.price=price;
    }

    //getter&setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
