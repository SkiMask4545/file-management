import java.util.Scanner;

public class Menu {

    public static void diplay(Scanner scanner) {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. File");
            System.out.println("2. Edit");
            System.out.println("3. View");
            System.out.println("4. Exit");
            System.out.print(">");
            String line = scanner.nextLine().trim();
            
            switch (line) {
                case "1":
                    while (true) {
                        System.out.println("File");
                        System.out.println("1. New");
                        System.out.println("2. Open");
                        System.out.println("3. Delete");
                        System.out.println("4. Return to the Menu");
                        System.out.print(">");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            File.fileNew(scanner);
                            break;

                            case "2":
                            File.fileOpen(scanner);
                            break;

                            case "3":
                            File.fileDelete(scanner);
                            break;

                            case "4":
                            System.out.println("Returning to the Menu...");
                            break;

                            default:
                            System.out.println("Unknown command!");
                        }
                        if (line.equals("4")) {
                            break;
                        }
                    }
                    break;

                case "2":
                    while (true) {
                        System.out.println("Edit");
                        System.out.println("1. Add");
                        System.out.println("2. Change");
                        System.out.println("3. Erase");
                        System.out.println("4. Return to the Menu");
                        System.out.print(">");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            Edit.editAdd(scanner);
                            break;

                            case "2":
                            Edit.editChange(scanner);
                            break;

                            case "3":
                            Edit.editErase(scanner);
                            break;

                            case "4":
                            System.out.println("Returning to the Menu...");
                            break;

                            default:
                            System.out.println("Unknown command!");
                        }
                        if (line.equals("4")) {
                            break;
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.println("View");
                        System.out.println("1. Show all");
                        System.out.println("2. Display employees who have less than 10 years of experience");
                        System.out.println("3. Return to the Menu");
                        System.out.print(">");
                        line = scanner.nextLine().trim();
                    
                        switch (line) {
                            case "1":
                            View.viewShowAll();
                            break;

                            case "2":
                            View.viewShowExp();
                            break;

                            case "3":
                            System.out.println("Returning to the Menu...");
                            break;

                            default:
                            System.out.println("Unknown command");
                        }
                        if (line.equals("3")) {
                            break;
                        }
                    }
                    break;

                case "4":
                    System.out.println("Shutting down...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unknown command!");
            }
        }
    }
}
