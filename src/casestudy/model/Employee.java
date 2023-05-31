package casestudy.model;

public class Employee extends Person {
    private String level;
    private String location;
    private double wage;

    public Employee() {

    }

    public Employee(String id, String name, String date, String gender, String code, String telephone, String email,
                    String level, String location, double wage) {
        super(id, name, date, gender, code, telephone, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
                ", location='" + location + '\'' +
                ", wage=" + wage +
                '}';
    }
}

