import java.io.Serializable;

public class Watch implements Serializable {
    enum Type {
        SMART("Smart"),
        ELECTRONIC("Electronic"),
        MECHANICAL("Mechanical");

        private final String string;

        Type(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }

    }

    private static final long serialVersionUID = 1L;

    private int id;
    private String company;
    private String model;
    private Type type;
    private double price;
    private String country;
    private int year;

    public int getId() {
        return this.id;
    }

    public String getCompany() {
        return this.company;
    }

    public String getModel() {
        return this.model;
    }

    public Type getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCountry() {
        return this.country;
    }

    public int getYear() {
        return this.year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
