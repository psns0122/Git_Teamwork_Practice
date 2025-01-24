package Day13.Home;

public class Book {
    private String title;
    private int price;

    Book(String name, int price) {
        this.title = name;
        this.price = price;
    }
    Book(){}


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
