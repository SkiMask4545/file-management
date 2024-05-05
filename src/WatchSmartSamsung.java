public class WatchSmartSamsung extends WatchSmart {
    enum PresenceOfAOD {
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

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public void setPresenceOfAOD(PresenceOfAOD presenceOfAOD) {
        this.presenceOfAOD = presenceOfAOD;
    }

}
