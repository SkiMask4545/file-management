import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 2L;

    private int id;
    private String surname;
    private String name;
    private String title;
    private double salary;
    private int experience;
    private String city;

    public int getId() {
        return this.id;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getCity() {
        return this.city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
