import java.io.Serializable;

public class Watch implements Serializable {
    protected enum Type {
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

    protected void setId(int id) {
        this.id = id;
    }

    protected void setCompany(String company) {
        this.company = company;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected void setType(Type type) {
        this.type = type;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected void setCountry(String country) {
        this.country = country;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    public String returnDataFields() {
        return this.company + " " + this.model;
    }

    public void printlnDataFields() {
        System.out.println(
            "\n1. ID: " + getId() +
            "\n2. Company: " + getCompany() +
            "\n3. Model: " + getModel() +
            "\n4. Type: " + getType() +
            "\n5. Price: " + getPrice() +
            "\n6. Country: " + getCountry() +
            "\n7. Year: " + getYear());
    }

    public void inputDataFields() {
        String line;
        
        System.out.print("\nInput Company: ");
        setCompany(MenuController.returnScannerNextLineTrim());

        System.out.print("Input Model: ");
        setModel(MenuController.returnScannerNextLineTrim());

        System.out.println(
            "\nSelect Type: " +
            "\n1. " + Type.ELECTRONIC +
            "\n2. " + Type.MECHANICAL);
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
    
        switch (line) {
            case "1":
                setType(Type.ELECTRONIC);
                break;

            case "2":
                setType(Type.MECHANICAL);
                break;

            default:
                MenuController.printlnInvalid();
        }

        System.out.print("Input Price: ");
        Double price;
    
        try {
            price = Double.valueOf(MenuController.returnScannerNextLineTrim());

            if (price >= 0) {
                setPrice(price);
            } else {
                MenuController.printlnInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenuController.printlnInvalid();
            System.out.println();
        }

        System.out.print("Input Country: ");
        setCountry(MenuController.returnScannerNextLineTrim());

        System.out.print("Input Year: ");
        Integer year;
    
        try {
            year = Integer.valueOf(MenuController.returnScannerNextLineTrim());

            if (year >= 0) {
                setYear(year);
            } else {
                MenuController.printlnInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenuController.printlnInvalid();
            System.out.println();
        }
    }
}
