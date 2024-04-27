public class SamsungSmartWatches extends SmartWatches {
    enum PresenceOfAOD {
        YES("Yes"),
        NO("No");

        private final String text;

        PresenceOfAOD(final String newText) {
            this.text = newText;
        }
        
        @Override
        public String toString() {
            return this.text;
        }
    }
    private static final long serialVersionUID = 3L;

    private int warranty;
    private PresenceOfAOD presenceOfAOD;

    public SamsungSmartWatches() {
    }

    public SamsungSmartWatches(int newId, String newCompany, String newModel, Type newType, double newPrice, String newCountry, int newYear, String newTechnology, UsedOS newUsedOS, int newWarranty, PresenceOfAOD newPresenceOfAOD) {
        super(newId, newCompany, newModel, newType, newPrice, newCountry, newYear, newTechnology, newUsedOS);
        this.warranty = newWarranty;
        this.presenceOfAOD = newPresenceOfAOD;
    }

    public int getWarranty() {
        return this.warranty;
    }

    public PresenceOfAOD getPresenceOfAOD() {
        return this.presenceOfAOD;
    }

    public void setWarranty(int newWarranty) {
        this.warranty = newWarranty;
    }

    public void setPresenceOfAOD(PresenceOfAOD newPresenceOfAOD) {
        this.presenceOfAOD = newPresenceOfAOD;
    }

}
