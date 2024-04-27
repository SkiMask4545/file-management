public class SmartWatches extends Watches {
    enum UsedOS {
        WATCHOS("watchOS"),
        WEAROS("Wear OS");

        private final String text;

        UsedOS(final String newText) {
            this.text = newText;
        }
        
        @Override
        public String toString() {
            return this.text;
        }
    }

    private static final long serialVersionUID = 2L;

    private String technology;
    private UsedOS usedOS;

    public SmartWatches() {
    }

    public SmartWatches(int newId, String newCompany, String newModel, Type newType, double newPrice, String newCountry, int newYear, String newTechnology, UsedOS newUsedOS) {
        super(newId, newCompany, newModel, newType, newPrice, newCountry, newYear);
        this.technology = newTechnology;
        this.usedOS = newUsedOS;
    }

    public String getTechnology() {
        return this.technology;
    }

    public UsedOS getUsedOS() {
        return this.usedOS;
    }

    public void setTechnology(String newTechnology) {
        this.technology = newTechnology;
    }

    public void setUsedOS(UsedOS newUsedOS) {
        this.usedOS = newUsedOS;
    }

}
