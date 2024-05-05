import java.util.Scanner;
import java.util.ArrayList;

public class DataController {
    private static Watches watches = new Watches();

    public static Watches getData() {
        return watches;
    }

    public static void setData(Watches watches) {
        DataController.watches = watches;
    }

    public static void clearData() {
        watches.getList().clear();
        watches.setIdCounter(1);
    }
        
    public static void dataAdd(Scanner scanner) {
        if (FilesController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else { 
            Watch watch = new Watch();

            watch.setId(watches.getIdCounter());

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

            if (watches.getList().add(watch)) {
                System.out.println("\nSuccessfully added: " + watch.getName() + " " + watch.getSurname() + "!");

                watches.setIdCounter(watches.getIdCounter() + 1);
            } else {
                System.out.println("\nWas not added: " + watch.getName() + " " + watch.getSurname() + "!");
            }
        }
    }

    public static void dataChange(Scanner scanner) {
        if (FilesController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (watches.getList().size() == 0) {
                System.out.println("\nNo watches found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < watches.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname());
                }
                
                System.out.println((watches.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < watches.getList().size()) {
                        Watch watch = watches.getList().get(i);

                        watch.setId(watches.getList().get(i).getId());
            
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
                        
                        System.out.println("\nSuccessfully changed: " + watch.getName() + " " + watch.getSurname() + "!");
                    } else if (i == watches.getList().size()) {
                        MenusController.printReturn();
                    } else {
                        MenusController.printInvalid();
                    }

                } catch (Exception e) {
                    MenusController.printInvalid();
                }
            }
        }
    }

    public static void dataRemove(Scanner scanner) {
        if (FilesController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (watches.getList().size() == 0) {
                System.out.println("\nNo watches found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < watches.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname());
                }
                
                System.out.println((watches.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < watches.getList().size()) {
                        System.out.println("\nAre you sure to remove: " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname() + "?"
                        + "\n1. Yes"
                        + "\n2. No");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();

                        switch (line) {
                            case "1":
                            System.out.println("\nSuccessfully removed: " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname() + "!");
                            watches.getList().remove(i.intValue());
                            break;

                            case "2":
                            System.out.println("\nWas not removed: " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname() + "!");
                            break;

                            default:
                            MenusController.printInvalid();
                        }
                    } else if (i == watches.getList().size()) {
                        MenusController.printReturn();
                    } else {
                        MenusController.printInvalid();
                    }

                } catch (Exception e) {
                    MenusController.printInvalid();
                }
            }
        }
    }

    public static void dataShowAll(Scanner scanner) {
        if (FilesController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (watches.getList().size() == 0) {
                System.out.println("\nNo watches found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < watches.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + watches.getList().get(i).getName() + " " + watches.getList().get(i).getSurname());
                }
                
                System.out.println((watches.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < watches.getList().size()) {
                        Watch watch = watches.getList().get(i);

                        System.out.println("\n1. ID: " + watch.getId()
                        + "\n2. Surname: " + watch.getSurname()
                        + "\n3. Name: " + watch.getName()
                        + "\n4. Title: " + watch.getTitle()
                        + "\n5. Salary: " + watch.getSalary()
                        + "\n6. Experience: " + watch.getExperience()
                        + "\n7. City: " + watch.getCity());
                        
                    } else if (i == watches.getList().size()) {
                        MenusController.printReturn();
                    } else {
                        MenusController.printInvalid();
                    }

                } catch (Exception e) {
                    MenusController.printInvalid();
                }
            }
        }
    }

    public static void dataShowUnexperienced(Scanner scanner) {
        if (FilesController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (watches.getList().size() == 0) {
                System.out.println("\nNo watches found!");
            } else {
                ArrayList<Watch> listUnexperienced = new ArrayList<>();

                for (int i = 0; i < watches.getList().size(); i++) {
                    if (watches.getList().get(i).getExperience() < 10) {
                        listUnexperienced.add(watches.getList().get(i));
                    }
                }

                if (listUnexperienced.size() == 0) {
                    System.out.println("\nNo watches found!");
                } else {
                    System.out.println();
        
                    for (int i = 0; i < listUnexperienced.size(); i++) {
                        System.out.println((i + 1) + ". " + listUnexperienced.get(i).getName() + " " + listUnexperienced.get(i).getSurname());
                    }
                    
                    System.out.println((listUnexperienced.size() + 1) + ". Return to the Menu");
                    System.out.print("\n>");
                    String line = scanner.nextLine().trim();
                    Integer i;
        
                    try {
                        i = Integer.valueOf(line) - 1;
        
                        if (i >= 0 && i < listUnexperienced.size()) {
                            Watch watch = listUnexperienced.get(i);

                            System.out.println("\n1. ID: " + watch.getId()
                            + "\n2. Surname: " + watch.getSurname()
                            + "\n3. Name: " + watch.getName()
                            + "\n4. Ttile: " + watch.getTitle()
                            + "\n5. Salary: " + watch.getSalary()
                            + "\n6. Experience: " + watch.getExperience()
                            + "\n7. City: " + watch.getCity());
                            
                        } else if (i == listUnexperienced.size()) {
                            MenusController.printReturn();
                        } else {
                            MenusController.printInvalid();
                        }

                    } catch (Exception e) {
                        MenusController.printInvalid();
                    }
                }
            }
        }
    }
    
}
