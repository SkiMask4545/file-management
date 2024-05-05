public class WatchSmart extends Watch {
    enum UsedOS {
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

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public void setUsedOS(UsedOS usedOS) {
        this.usedOS = usedOS;
    }

}
