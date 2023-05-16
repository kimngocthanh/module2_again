package ss5;

public class Staff {
    private String name;
    private String telephone;
    private String workingParts;
    //tính bao đóng
    private static final String NAME_COMPANY = "ABC";
    //static final vì tên công ty cố định


    public Staff(String name, String telephone, String workingParts) {
        this.name = name;
        this.telephone = telephone;
        this.workingParts = workingParts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", workingParts='" + workingParts + '\'' +
                ", nameCompany='" + NAME_COMPANY + '\'' +
                '}';
    }
}
