import java.util.Scanner;

public class DataController {
    private static Watches watches = new Watches();

    public static Watches getData() {
        return watches;
    }

    public static void setData(Watches watches) {
        DataController.watches = watches;
    }

    public static void clearData() {
        watches.getArrayList().clear();
        watches.setIdCounter(1);
    }

    public static void printData(Watch watch) {
        System.out.println(
            "\n1. ID: " + watch.getId() +
            "\n2. Surname: " + watch.getSurname() +
            "\n3. Name: " + watch.getName() +
            "\n4. Ttile: " + watch.getTitle() +
            "\n5. Salary: " + watch.getSalary() +
            "\n6. Experience: " + watch.getExperience() +
            "\n7. City: " + watch.getCity());
    }

    public static void inputData(Scanner scanner, Watch watch) {
        System.out.print("\nInput Surname: ");
        watch.setSurname(scanner.nextLine().trim());

        System.out.print("Input Name: ");
        watch.setName(scanner.nextLine().trim());

        System.out.print("Input Title: ");
        watch.setTitle(scanner.nextLine().trim());

        System.out.print("Input Salary: ");
        Double salary;
    
        try {
            salary = Double.valueOf(scanner.nextLine().trim());

            if (salary >= 0) {
                watch.setSalary(salary);
            } else {
                MenusController.printInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
            System.out.println();
        }
        System.out.print("Input Experience: ");
        Integer experience;
    
        try {
            experience = Integer.valueOf(scanner.nextLine().trim());

            if (experience >= 0) {
                watch.setExperience(experience);
            } else {
                MenusController.printInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
            System.out.println();
        }
        System.out.print("Input City: ");
        watch.setCity(scanner.nextLine().trim());
    }

    public static boolean checkData(Watches watches) {
        if (watches.getArrayList().size() == 0) {
            System.out.println("\nNo watches found!");
            return false;
        } else {
            return true;
        }
    }
        
    public static void dataAdd(Scanner scanner) {
        if (!FilesController.checkFile()) {
            return;
        }
        Watch watch = new Watch();

        watch.setId(watches.getIdCounter());

        inputData(scanner, watch);

        if (watches.getArrayList().add(watch)) {
            System.out.println("\nSuccessfully added: " + watch.getName() + " " + watch.getSurname() + "!");

            watches.setIdCounter(watches.getIdCounter() + 1);
        } else {
            System.out.println("\nWas not added: " + watch.getName() + " " + watch.getSurname() + "!");
        }
    }

    public static void dataChange(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(watches)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < watches.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname());
        }
        System.out.println((watches.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < watches.getArrayList().size()) {
                Watch watch = watches.getArrayList().get(i);
    
                inputData(scanner, watch);
                
                System.out.println("\nSuccessfully changed: " + watch.getName() + " " + watch.getSurname() + "!");
            } else if (i == watches.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataRemove(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(watches)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < watches.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname());
        }
        System.out.println((watches.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < watches.getArrayList().size()) {
                System.out.println("\nAre you sure to remove: " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname() + "?"
                + "\n1. Yes"
                + "\n2. No");
                System.out.print("\n>");
                line = scanner.nextLine().trim();

                switch (line) {
                    case "1":
                    System.out.println("\nSuccessfully removed: " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname() + "!");
                    watches.getArrayList().remove(i.intValue());
                    break;

                    case "2":
                    System.out.println("\nWas not removed: " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname() + "!");
                    break;

                    default:
                    MenusController.printInvalid();
                }
            } else if (i == watches.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataShow(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(watches)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < watches.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + watches.getArrayList().get(i).getName() + " " + watches.getArrayList().get(i).getSurname());
        }
        System.out.println((watches.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < watches.getArrayList().size()) {
                Watch watch = watches.getArrayList().get(i);
                printData(watch);
                
            } else if (i == watches.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataShowUnexperienced(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(watches)) {
            return;
        }
        Watches employeesUnexperienced = new Watches();

        for (int i = 0; i < watches.getArrayList().size(); i++) {
            if (watches.getArrayList().get(i).getExperience() < 10) {
                employeesUnexperienced.getArrayList().add(watches.getArrayList().get(i));
            }
        }
        if (!checkData(employeesUnexperienced)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < employeesUnexperienced.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + employeesUnexperienced.getArrayList().get(i).getName() + " " + employeesUnexperienced.getArrayList().get(i).getSurname());
        }
        System.out.println((employeesUnexperienced.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < employeesUnexperienced.getArrayList().size()) {
                Watch watch = employeesUnexperienced.getArrayList().get(i);
                printData(watch);
                
            } else if (i == employeesUnexperienced.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }
}
