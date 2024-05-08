public class WatchSmart extends Watch {
    protected enum UsedOS {
        WATCHOS("watchOS"),
        WEAROS("Wear OS");

        private final String string;

        UsedOS(final String string) {
            this.string = string;
        }
        
        @Override
        public String toString() {
            return this.string;
        }
    }

    private static final long serialVersionUID = 2L;

    private String technology;
    private UsedOS usedOS;

    public String getTechnology() {
        return this.technology;
    }

    public UsedOS getUsedOS() {
        return this.usedOS;
    }

    protected void setTechnology(String technology) {
        this.technology = technology;
    }

    protected void setUsedOS(UsedOS usedOS) {
        this.usedOS = usedOS;
    }

    @Override
    public void printlnDataFields() {
        System.out.println(
            "\n1. ID: " + getId() +
            "\n2. Company: " + getCompany() +
            "\n3. Model: " + getModel() +
            "\n4. Type: " + getType() +
            "\n5. Price: " + getPrice() +
            "\n6. Country: " + getCountry() +
            "\n7. Year: " + getYear() +
            "\n8. Technology: " + getTechnology() +
            "\n9. Used OS: " + getUsedOS());
    }

    @Override
    public void inputDataFields() {
        String line;

        System.out.print("\nInput Company: ");
        setCompany(MenuController.returnScannerNextLineTrim());

        System.out.print("Input Model: ");
        setModel(MenuController.returnScannerNextLineTrim());

        setType(Type.SMART);

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

        System.out.print("Input Technology: ");
        setTechnology(MenuController.returnScannerNextLineTrim());

        System.out.println(
            "\nSelect Used OS: " +
            "\n1. " + UsedOS.WATCHOS +
            "\n2. " + UsedOS.WEAROS);
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
    
        switch (line) {
            case "1":
                setUsedOS(UsedOS.WATCHOS);
                break;

            case "2":
                setUsedOS(UsedOS.WEAROS);
                break;

            default:
                MenuController.printlnInvalid();
        }
    }
}
