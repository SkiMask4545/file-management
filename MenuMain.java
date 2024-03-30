import java.util.Scanner;

public class MenuMain {

    public static void diplay(Scanner scanner) {
        while (true) {
            System.out.println("\nMAIN MENU\n1. File\n2. Edit\n3. View\n4. Exit");
            System.out.print("\n>");
            String line = scanner.nextLine().trim();
            
            switch (line) {
                case "1":
                    while (true) {
                        System.out.println("\nFILE\n1. New\n2. Open\n3. Delete\n4. Return to the Main Menu");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            MenuFile.fileNew(scanner);
                            break;

                            case "2":
                            MenuFile.fileOpen(scanner);
                            break;

                            case "3":
                            MenuFile.fileDelete(scanner);
                            break;

                            case "4":
                            System.out.println("\nReturning to the Main Menu...");
                            break;

                            default:
                            System.out.println("\nUnknown command!");
                        }
                        if (line.equals("4")) {
                            break;
                        }
                    }
                    break;

                case "2":
                    while (true) {
                        System.out.println("\nEDIT\n1. Add\n2. Change\n3. Erase\n4. Return to the Main Menu");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            MenuEdit.editAdd(scanner);
                            break;

                            case "2":
                            MenuEdit.editChange(scanner);
                            break;

                            case "3":
                            MenuEdit.editErase(scanner);
                            break;

                            case "4":
                            System.out.println("\nReturning to the Menu...");
                            break;

                            default:
                            System.out.println("\nUnknown command!");
                        }
                        if (line.equals("4")) {
                            break;
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.println("\nVIEW\n1. Show all\n2. Display employees who have less than 10 years of experience\n3. Return to the Menu");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            MenuView.viewShowAll();
                            break;

                            case "2":
                            MenuView.viewShowExp();
                            break;

                            case "3":
                            System.out.println("\nReturning to the Menu...");
                            break;

                            default:
                            System.out.println("\nUnknown command");
                        }
                        if (line.equals("3")) {
                            break;
                        }
                    }
                    break;

                case "4":
                    System.out.println("\nShutting down...\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nUnknown command!");
            }
        }
    }
}
