import java.util.Scanner;

public class MenusController {
    private static Scanner scanner = new Scanner(System.in);

    private static void printMainMenu() {
        System.out.println("\nMENU"
            + "\n1. File"
            + "\n2. Data"
            + "\n3. Exit");
        System.out.print("\n>");
    }

    private static void printFileMenu() {
        System.out.println("\nFILE"
            + "\n1. New"
            + "\n2. Open"
            + "\n3. Save and Close"
            + "\n4. Delete"
            + "\n5. Return to the Menu");
        System.out.print("\n>");
    }

    private static void printDataMenu() {
        System.out.println("\nDATA"
            + "\n1. Add"
            + "\n2. Change"
            + "\n3. Remove"
            + "\n4. Show All"
            + "\n5. Show Unexperienced"
            + "\n6. Return to the Menu");
        System.out.print("\n>");
    }

    public static void printInvalid() {
        System.out.println("\nInvalid input!");
    }

    public static void printReturn() {
        System.out.println("\nReturning to the Menu...");
    }

    private static void printExit() {
        System.out.println("\nShutting down...\n");
    }

    private static void exit() {
        if (FilesController.getFilePath() != null) {
            System.out.println("\nAre you sure to exit without saving: " + FilesController.getFileName() + "?"
            + "\n1. Yes"
            + "\n2. No");
            System.out.print("\n>");
            String line = scanner.nextLine().trim();

            switch (line) {
                case "1":
                printExit();
                scanner.close();
                System.exit(0);
                break;

                case "2":
                break;

                default:
                printInvalid();
            }

        } else {
            printExit();
            scanner.close();
            System.exit(0);
        }
    }

    private static void switchDataMenu() {
        while (true) {
            printDataMenu();
            String line = scanner.nextLine().trim();
        
            switch (line) {
                case "1":
                DataController.dataAdd(scanner);
                break;

                case "2":
                DataController.dataChange(scanner);
                break;

                case "3":
                DataController.dataRemove(scanner);
                break;

                case "4":
                DataController.dataShowAll(scanner);
                break;

                case "5":
                DataController.dataShowUnexperienced(scanner);
                break;

                case "6":
                printReturn();
                break;

                default:
                printInvalid();
            }

            if (line.equals("6")) {
                break;
            }
            
        }
    }

    static void switchFileMenu() {
        while (true) {
            printFileMenu();
            String line = scanner.nextLine().trim();
        
            switch (line) {
                case "1":
                FilesController.fileNew(scanner);
                break;

                case "2":
                FilesController.fileOpen(scanner);
                break;

                case "3":
                FilesController.fileSaveAndClose();
                break;

                case "4":
                FilesController.fileDelete(scanner);
                break;

                case "5":
                printReturn();
                break;

                default:
                printInvalid();
            }

            if (line.equals("5")) {
                break;
            }
        }

    }

    static void switchMainMenu() {
        while (true) {
            printMainMenu();
            String line = scanner.nextLine().trim();
            
            switch (line) {
                case "1":
                    switchFileMenu();
                    break;

                case "2":
                    switchDataMenu();
                    break;

                case "3":
                    exit();
                    break;

                default:
                    printInvalid();
            }
        }
    }

    public static void display() {
        switchMainMenu();
    }

}
