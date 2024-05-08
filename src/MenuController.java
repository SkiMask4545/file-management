import java.util.Scanner;

public class MenuController {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return MenuController.scanner;
    }

    public static String returnScannerNextLineTrim() {
        return getScanner().nextLine().trim();
    }

    public static void printCmd() {
        System.out.print("\n>");
    }

    public static void printlnInvalid() {
        System.out.println("\nInvalid input!");
    }

    public static void printlnError() {
        System.out.println("\nAn error has occurred!\n");
    }

    public static void printlnReturn() {
        System.out.println("\nReturning...");
    }

    private static void printlnExit() {
        System.out.println("\nShutting down...\n");
    }

    public static void display() {
        mainMenu();
    }

    private static void mainMenu() {
        String line;

        while (true) {
            System.out.println(
                "\nMain Menu" +
                "\n1. File" +
                "\n2. Data" +
                "\n3. Exit");
            printCmd();
            line = returnScannerNextLineTrim();
            
            switch (line) {
                case "1":
                    fileMenu();
                    break;

                case "2":
                    dataMenu();
                    break;

                case "3":
                    if (FileController.getFilePath() != null) {
                        System.out.println(
                            "\nAre you sure to exit without saving: " + FileController.getFilePathName() + "?" +
                            "\n1. Yes" +
                            "\n2. No");
                        printCmd();
                        line = returnScannerNextLineTrim();
            
                        switch (line) {
                            case "1":
                                printlnExit();
                                getScanner().close();
                                System.exit(0);
                                break;
            
                            case "2":
                                break;
            
                            default:
                                printlnInvalid();
                        }
                    } else {
                        printlnExit();
                        getScanner().close();
                        System.exit(0);
                    }
                    break;

                default:
                    printlnInvalid();
            }
        }
    }
    
    static void fileMenu() {
        String line;

        while (true) {
            System.out.println(
                "\nFiles Menu" +
                "\n1. New" +
                "\n2. Open" +
                "\n3. Save and Close" +
                "\n4. Delete" +
                "\n5. Return");
            printCmd();
            line = returnScannerNextLineTrim();
        
            switch (line) {
                case "1":
                    FileController.createFile();
                    break;

                case "2":
                    FileController.openFile();
                    break;

                case "3":
                    FileController.saveAndCloseFile();
                    break;

                case "4":
                    FileController.deleteFile();
                    break;

                case "5":
                    printlnReturn();
                    break;

                default:
                    printlnInvalid();
            }
            if (line.equals("5")) {
                break;
            }
        }
    }

    private static void dataMenu() {
        String line;

        while (true) {
            System.out.println(
                "\nData Menu" +
                "\n1. Add" +
                "\n2. Change" +
                "\n3. Remove" +
                "\n4. Show" +
                "\n5. Show USA Watches" +
                "\n6. Show Smart Watches" +
                "\n7. Return");
            printCmd();
            line = returnScannerNextLineTrim();
        
            switch (line) {
                case "1":
                    DataController.addData();
                    break;

                case "2":
                    DataController.changeData();
                    break;

                case "3":
                    DataController.removeData();
                    break;

                case "4":
                    DataController.showData();
                    break;

                case "5":
                    DataController.showDataUSA();
                    break;

                case "6":
                    DataController.showDataSmart();
                    break;

                case "7":
                    printlnReturn();
                    break;

                default:
                    printlnInvalid();
            }
            if (line.equals("7")) {
                break;
            }
        }
    }
}
