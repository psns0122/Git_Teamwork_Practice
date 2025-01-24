package day13.homework.class실습;

public class BookMgr {
    Book[] booklist;

    public BookMgr(Book[] booklist){
        this.booklist = booklist;
    }
    public void printBooklist(){
        for(int i=0 ;i<booklist.length;i++){
            System.out.println(booklist[i].getTitle());
        }
    }
    public void printTotalPrice(){
        int sum = 0;
        for(int i=0 ;i<booklist.length;i++){

            //sum = sum+booklist[i].getprice();
            sum += booklist[i].getPrice();
        }
        System.out.println(sum);

    }
}
