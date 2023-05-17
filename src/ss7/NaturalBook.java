package ss7;

public class NaturalBook extends Book {
    private String publicationObject;

    public NaturalBook(){

    }

    public NaturalBook(String nameBook, String publishingCompany, double publishingYear, String publicationObject) {
        super(nameBook, publishingCompany, publishingYear);
        this.publicationObject = publicationObject;
    }

    public String getPublicationObject() {
        return publicationObject;
    }

    public void setPublicationObject(String publicationObject) {
        this.publicationObject = publicationObject;
    }



    @Override
    public void display() {
        System.out.println(super.toString()+ "publicationObject"+ this.publicationObject);
    }
}
