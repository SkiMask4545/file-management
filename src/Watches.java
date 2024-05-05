import java.io.Serializable;

public class Watches implements Serializable {
    enum Type {
        SMART("Smart"),
        ELECTRONIC("Electronic"),
        MECHANICAL("Mechanical");

        private final String text;

        Type(final String newText) {
            this.text = newText;
        }

        @Override
        public String toString() {
            return this.text;
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

    public void setId(int newId) {
        this.id = newId;
    }

    public void setCompany(String newCompany) {
        this.company = newCompany;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public void setType(Type newType) {
        this.type = newType;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setCountry(String newCountry) {
        this.country = newCountry;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }

}
