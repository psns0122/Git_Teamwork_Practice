package day13.homework.NO2;

public class Book {

    private String title;
    private int price;

    Book() {
        this.title = "미제";
        this.price = 0;
    }

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

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
