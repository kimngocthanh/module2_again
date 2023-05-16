package ss7;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0]= new NaturalBook("0","0",0,"0");
        books[1]= new NaturalBook("1","1",1,"1");
        books[2]= new NaturalBook("2","2",2,"2");
        books[3]= new NaturalBook("3","3",3,"3");
        books[4]= new NaturalBook("4","4",4,"4");
        for (Book b : books) {
            b.display();
        }
    }
}
