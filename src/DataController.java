public class DataController {
    private static Data data = new Data();

    public static Data getData() {
        return DataController.data;
    }

    public static void setData(Data data) {
        DataController.data = data;
    }

    public static void clearData() {
        getData().getArrayList().clear();
        getData().setIdCounter(0);
    }

    public static void addData(Watch watch) {
        watch.setId(getData().getIdCounter() + 1);
        watch.inputDataFields();

        if (getData().getArrayList().add(watch)) {
            System.out.println("\nSuccessfully added: " + watch.returnDataFields() + "!");

            getData().setIdCounter(getData().getIdCounter() + 1);
        } else {
            System.out.println("\nWas not added: " + watch.returnDataFields() + "!");
        }
    }

    public static void addData() {
        String line;

        if (!FileController.checkFileOpen()) {
            return;
        }

        while (true) {
            System.out.println(
                "\nSelect item to add: " +
                "\n1. Watch" +
                "\n2. Smart Watch" +
                "\n3. Return");
            MenuController.printCmd();
            line = MenuController.returnScannerNextLineTrim();
        
            switch (line) {
                case "1":
                    Watch watch = new Watch();
                    addData(watch);
                    break;

                case "2":
                    while (true) {
                        System.out.println(
                            "\nSelect item to add: " +
                            "\n1. Smart Watch" +
                            "\n2. Samsung Smart Watch" +
                            "\n3. Return");
                        MenuController.printCmd();
                        line = MenuController.returnScannerNextLineTrim();
                    
                        switch (line) {
                            case "1":
                                WatchSmart watchSmart = new WatchSmart();
                                addData(watchSmart);
                                break;
            
                            case "2":
                                while (true) {
                                    System.out.println(
                                        "\nSelect item to add: " +
                                        "\n1. Samsung Smart Watch" +
                                        "\n2. Return");
                                    MenuController.printCmd();
                                    line = MenuController.returnScannerNextLineTrim();
                                
                                    switch (line) {
                                        case "1":
                                            WatchSmartSamsung watchSmartSamsung = new WatchSmartSamsung();
                                            addData(watchSmartSamsung);
                                            break;
                        
                                        case "2":
                                            MenuController.printlnReturn();
                                            break;
                        
                                        default:
                                            MenuController.printlnInvalid();
                                    }
                                    if (line.equals("1") || line.equals("2")) {
                                        break;
                                    }
                                }
                                break;
            
                            case "3":
                                MenuController.printlnReturn();
                                break;
            
                            default:
                                MenuController.printlnInvalid();
                        }
                        if (line.equals("1") || line.equals("3")) {
                            break;
                        }
                    }
                    break;

                case "3":
                    MenuController.printlnReturn();
                    break;

                default:
                    MenuController.printlnInvalid();
            }
            if (line.equals("1") || line.equals("3")) {
                break;
            }
        }
    }

    public static void changeData() {
        String line;

        if (!FileController.checkFileOpen() || !getData().checkDataExist()) {
            return;
        }
        System.out.println();

        for (int i = 0; i < getData().getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + getData().getArrayList().get(i).returnDataFields());
        }
        System.out.println((getData().getArrayList().size() + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < getData().getArrayList().size()) {
                getData().getArrayList().get(i).inputDataFields();
                
                System.out.println("\nSuccessfully changed: " + getData().getArrayList().get(i).returnDataFields() + "!");
            } else if (i == getData().getArrayList().size()) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }

    public static void removeData() {
        String line;

        if (!FileController.checkFileOpen() || !data.checkDataExist()) {
            return;
        }
        System.out.println();

        for (int i = 0; i < getData().getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + getData().getArrayList().get(i).returnDataFields());
        }
        System.out.println((getData().getArrayList().size() + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < getData().getArrayList().size()) {
                System.out.println("\nAre you sure to remove: " + getData().getArrayList().get(i).returnDataFields() + "?"
                + "\n1. Yes"
                + "\n2. No");
                MenuController.printCmd();
                line = MenuController.returnScannerNextLineTrim();

                switch (line) {
                    case "1":
                    System.out.println("\nSuccessfully removed: " + getData().getArrayList().get(i).returnDataFields() + "!");
                    getData().getArrayList().remove(i.intValue());
                    break;

                    case "2":
                    System.out.println("\nWas not removed: " + getData().getArrayList().get(i).returnDataFields() + "!");
                    break;

                    default:
                    MenuController.printlnInvalid();
                }
            } else if (i == getData().getArrayList().size()) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }

    public static void showData() {
        String line;

        if (!FileController.checkFileOpen() || !data.checkDataExist()) {
            return;
        }
        System.out.println();

        for (int i = 0; i < getData().getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + getData().getArrayList().get(i).returnDataFields());
        }
        System.out.println((getData().getArrayList().size() + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < getData().getArrayList().size()) {
                getData().getArrayList().get(i).printlnDataFields();
                
            } else if (i == getData().getArrayList().size()) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }

    public static void showDataUSA() {
        String line;

        if (!FileController.checkFileOpen() || !data.checkDataExist()) {
            return;
        }
        Data dataUSA = new Data();

        for (int i = 0; i < getData().getArrayList().size(); i++) {
            if (getData().getArrayList().get(i).getCountry().equals("USA")) {
                dataUSA.getArrayList().add(getData().getArrayList().get(i));
            }
        }
        if (!dataUSA.checkDataExist()) {
            return;
        }
        System.out.println();

        for (int i = 0; i < dataUSA.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + dataUSA.getArrayList().get(i).returnDataFields());
        }
        System.out.println((dataUSA.getArrayList().size() + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < getData().getArrayList().size()) {
                dataUSA.getArrayList().get(i).printlnDataFields();
                
            } else if (i == dataUSA.getArrayList().size()) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }

    public static void showDataSmart() {
        String line;

        if (!FileController.checkFileOpen() || !data.checkDataExist()) {
            return;
        }
        Data dataSmart = new Data();

        for (int i = 0; i < getData().getArrayList().size(); i++) {
            if (getData().getArrayList().get(i).getType().toString().equals("Smart")) {
                dataSmart.getArrayList().add(getData().getArrayList().get(i));
            }
        }
        if (!dataSmart.checkDataExist()) {
            return;
        }
        System.out.println();

        for (int i = 0; i < dataSmart.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + dataSmart.getArrayList().get(i).returnDataFields());
        }
        System.out.println((dataSmart.getArrayList().size() + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < getData().getArrayList().size()) {
                dataSmart.getArrayList().get(i).printlnDataFields();
                
            } else if (i == dataSmart.getArrayList().size()) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }
}
