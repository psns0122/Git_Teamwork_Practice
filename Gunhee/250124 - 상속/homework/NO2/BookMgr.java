package day13.homework.NO2;

public class BookMgr {
    Book[] booklist;

    public BookMgr(Book[] booklist) {
        this.booklist = new Book[booklist.length];
        for (int i = 0; i < booklist.length; i++) {
            this.booklist[i] = new Book(booklist[i].getTitle(), booklist[i].getPrice());
        }
    }

    public void printBooklist(){
        for (int i = 0; i < this.booklist.length; i++) {
            System.out.println(this.booklist[i].getTitle());
        }
    }

    public void printTotalPrice(){
        int total = 0;
        for (int i = 0; i < this.booklist.length; i++) {
            total += this.booklist[i].getPrice();
        }
        System.out.println("전체 책 가격의 합 : " + total);

    }
}
