package casestudy.model;

public class Employee extends Person {
    private String level;
    private double wage;

    public Employee() {

    }

    public Employee(String id, String name, String date, String gender, String code, String telephone, String email, String level, double wage) {
        super(id, name, date, gender, code, telephone, email);
        this.level = level;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "level='" + level + '\'' +
                ", wage=" + wage +
                '}';
    }

    public String writeAndReadEmployee() {
        return super.getId() + "," + super.getName() + "," + super.getDate() + "," + super.getGender() + "," +
                super.getCode() + "," + super.getTelephone() + "," + super.getEmail() + "," + this.level + "," +
                this.wage;
    }
}

