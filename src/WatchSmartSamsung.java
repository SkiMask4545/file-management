public class WatchSmartSamsung extends WatchSmart {
    protected enum PresenceOfAOD {
        YES("Yes"),
        NO("No");

        private final String string;

        PresenceOfAOD(final String string) {
            this.string = string;
        }
        
        @Override
        public String toString() {
            return this.string;
        }
    }

    private static final long serialVersionUID = 3L;

    private int warranty;
    private PresenceOfAOD presenceOfAOD;

    public int getWarranty() {
        return this.warranty;
    }

    public PresenceOfAOD getPresenceOfAOD() {
        return this.presenceOfAOD;
    }

    protected void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    protected void setPresenceOfAOD(PresenceOfAOD presenceOfAOD) {
        this.presenceOfAOD = presenceOfAOD;
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
            "\n9. Used OS: " + getUsedOS() +
            "\n10. Warranty: " + getWarranty() +
            "\n11. Presence of AOD: " + getPresenceOfAOD());
    }

    @Override
    public void inputDataFields() {
        String line;

        setCompany("Samsung");

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

        setUsedOS(UsedOS.WEAROS);

        System.out.print("Input Warranty: ");
        Integer warranty;
    
        try {
            warranty = Integer.valueOf(MenuController.returnScannerNextLineTrim());

            if (warranty >= 0) {
                setWarranty(warranty);
            } else {
                MenuController.printlnInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenuController.printlnInvalid();
            System.out.println();
        }

        System.out.println(
            "\nSelect Presence of AOD: " +
            "\n1. " + PresenceOfAOD.YES +
            "\n2. " + PresenceOfAOD.NO);
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
    
        switch (line) {
            case "1":
                setPresenceOfAOD(PresenceOfAOD.YES);
                break;

            case "2":
                setPresenceOfAOD(PresenceOfAOD.NO);
                break;

            default:
                MenuController.printlnInvalid();
        }
    }
}
