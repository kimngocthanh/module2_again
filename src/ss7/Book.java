package ss7;

public abstract class Book implements IBook{
    private String nameBook;
    private String publishingCompany;
    private double publishingYear;

    public Book() {

    }

    public Book(String nameBook, String publishingCompany, double publishingYear) {
        this.nameBook = nameBook;
        this.publishingCompany = publishingCompany;
        this.publishingYear = publishingYear;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public double getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(double publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameBook='" + nameBook + '\'' +
                ", publishingCompany='" + publishingCompany + '\'' +
                ", publishingYear=" + publishingYear +
                '}';
    }
}
