package ss7;

public class SocialBook extends Book implements IBook{
    private String author;

    public SocialBook() {

    }

    public SocialBook(String nameBook, String publishingCompany, double publishingYear, String author) {
        super(nameBook, publishingCompany, publishingYear);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public void display() {
        System.out.println(super.toString()+"author"+ author);
    }
}
