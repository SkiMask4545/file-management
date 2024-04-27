import java.io.Serializable;

public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public void setId(int newId) {
        this.id = newId;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void setExperience(int newExperience) {
        this.experience = newExperience;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }
}
