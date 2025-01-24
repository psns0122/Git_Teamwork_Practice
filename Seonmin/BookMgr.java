package Day13.Home;

public class BookMgr {
    Book[] booklist = new Book[5];
    public BookMgr(Book[] booklist) {
      this.booklist = booklist;

    }

    public void printBooklist(){

        for(int i=0;i<booklist.length;i++){
            System.out.println(booklist[i].getTitle());
            System.out.println();

        }

    }

    public void printTotalPrice(){
        int sum = 0;

        for(int i=0;i<booklist.length;i++){
            sum += booklist[i].getPrice();
        }
        System.out.println("전체 책 가격의  : " + sum);


    }
}
