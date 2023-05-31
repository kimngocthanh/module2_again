package casestudy.model;

public class Customer extends Person {
    private String typeCustomer;
    public String address;

    public Customer() {

    }

    public Customer(String id, String name, String date, String gender, String code, String telephone, String email,
                    String typeCustomer, String address) {
        super(id, name, date, gender, code, telephone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
