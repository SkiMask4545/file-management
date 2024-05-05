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
