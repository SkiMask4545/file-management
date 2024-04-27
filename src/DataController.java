import java.util.Scanner;
import java.util.ArrayList;

public class DataController {
    private static ArrayList<Employees> list = new ArrayList<Employees>();

    public static  ArrayList<Employees> getList() {
        return list;
    }

    public static void setList(ArrayList<Employees> newList) {
        list = newList;
    }

    public static void clearList() {
        list.clear();
    }
        
    public static void dataAdd(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else { 
            Employees employees = new Employees();

            employees.setId(list.size() + 1);

            System.out.print("\nInput Surname: ");
            employees.setSurname(scanner.nextLine().trim());

            System.out.print("Input Name: ");
            employees.setName(scanner.nextLine().trim());

            System.out.print("Input Title: ");
            employees.setTitle(scanner.nextLine().trim());

            System.out.print("Input Salary: ");
            Double salary;
        
            try {
                salary = Double.valueOf(scanner.nextLine().trim());

                if (salary >= 0) {
                    employees.setSalary(salary);
                } else {
                    MenuController.printInvalid();
                    System.out.println();
                }

            } catch (Exception e) {
                MenuController.printInvalid();
                System.out.println();
            }

            System.out.print("Input Experience: ");
            Integer experience;
        
            try {
                experience = Integer.valueOf(scanner.nextLine().trim());

                if (experience >= 0) {
                    employees.setExperience(experience);
                } else {
                    MenuController.printInvalid();
                    System.out.println();
                }

            } catch (Exception e) {
                MenuController.printInvalid();
                System.out.println();
            }

            System.out.print("Input City: ");
            employees.setCity(scanner.nextLine().trim());

            if (list.add(employees)) {
                System.out.println("\nSuccessfully added: " + employees.getName() + " " + employees.getSurname());
            } else {
                System.out.println("\nWas not added: " + employees.getName() + " " + employees.getSurname());
            }
        }
    }

    public static void dataChange(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (list.size() == 0) {
                System.out.println("\nNo data found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getSurname());
                }
                
                System.out.println((list.size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < list.size()) {
                        Employees employees = list.get(i);

                        employees.setId(list.get(i).getId());
            
                        System.out.print("\nInput Surname: ");
                        employees.setSurname(scanner.nextLine().trim());
            
                        System.out.print("Input Name: ");
                        employees.setName(scanner.nextLine().trim());
            
                        System.out.print("Input Title: ");
                        employees.setTitle(scanner.nextLine().trim());
            
                        System.out.print("Input Salary: ");
                        Double salary;
                    
                        try {
                            salary = Double.valueOf(scanner.nextLine().trim());
            
                            if (salary >= 0) {
                                employees.setSalary(salary);
                            } else {
                                MenuController.printInvalid();
                                System.out.println();
                            }
            
                        } catch (Exception e) {
                            MenuController.printInvalid();
                            System.out.println();
                        }
            
                        System.out.print("Input Experience: ");
                        Integer experience;
                    
                        try {
                            experience = Integer.valueOf(scanner.nextLine().trim());
            
                            if (experience >= 0) {
                                employees.setExperience(experience);
                            } else {
                                MenuController.printInvalid();
                                System.out.println();
                            }
            
                        } catch (Exception e) {
                            MenuController.printInvalid();
                            System.out.println();
                        }
            
                        System.out.print("Input City: ");
                        employees.setCity(scanner.nextLine().trim());
                        
                        System.out.println("\nSuccessfully changed: " + employees.getName() + " " + employees.getSurname());
                    } else if (i == list.size()) {
                        MenuController.printReturn();
                    } else {
                        MenuController.printInvalid();
                    }

                } catch (Exception e) {
                    MenuController.printInvalid();
                }
            }
        }
    }

    public static void dataRemove(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (list.size() == 0) {
                System.out.println("\nNo data found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getSurname());
                }
                
                System.out.println((list.size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < list.size()) {
                        System.out.println("\nAre you sure to remove: " + list.get(i).getName() + " " + list.get(i).getSurname() + "?"
                        + "\n1. Yes"
                        + "\n2. No");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();

                        switch (line) {
                            case "1":
                            System.out.println("\nSuccessfully removed: " + list.get(i).getName() + " " + list.get(i).getSurname());
                            list.remove(i.intValue());
                            break;

                            case "2":
                            System.out.println("\nWas not removed: " + list.get(i).getName() + " " + list.get(i).getSurname() + "!");
                            break;

                            default:
                            MenuController.printInvalid();
                        }
                    } else if (i == list.size()) {
                        MenuController.printReturn();
                    } else {
                        MenuController.printInvalid();
                    }

                } catch (Exception e) {
                    MenuController.printInvalid();
                }
            }
        }
    }

    public static void dataShowAll(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (list.size() == 0) {
                System.out.println("\nNo data found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getSurname());
                }
                
                System.out.println((list.size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < list.size()) {
                        Employees employees = list.get(i);

                        System.out.println("\n1. ID: " + employees.getId()
                        + "\n2. Surname: " + employees.getSurname()
                        + "\n3. Name: " + employees.getName()
                        + "\n4. Title: " + employees.getTitle()
                        + "\n5. Salary: " + employees.getSalary()
                        + "\n6. Experience: " + employees.getExperience()
                        + "\n7. City: " + employees.getCity());
                        
                    } else if (i == list.size()) {
                        MenuController.printReturn();
                    } else {
                        MenuController.printInvalid();
                    }

                } catch (Exception e) {
                    MenuController.printInvalid();
                }
            }
        }
    }

    public static void dataShowUnexperienced(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (list.size() == 0) {
                System.out.println("\nNo data found!");
            } else {
                ArrayList<Employees> listUnexperienced = new ArrayList<Employees>();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getExperience() < 10) {
                        listUnexperienced.add(list.get(i));
                    }
                }

                if (listUnexperienced.size() == 0) {
                    System.out.println("\nNo data found!");
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
                            Employees employees = listUnexperienced.get(i);

                            System.out.println("\n1. ID: " + employees.getId()
                            + "\n2. Surname: " + employees.getSurname()
                            + "\n3. Name: " + employees.getName()
                            + "\n4. Ttile: " + employees.getTitle()
                            + "\n5. Salary: " + employees.getSalary()
                            + "\n6. Experience: " + employees.getExperience()
                            + "\n7. City: " + employees.getCity());
                            
                        } else if (i == listUnexperienced.size()) {
                            MenuController.printReturn();
                        } else {
                            MenuController.printInvalid();
                        }

                    } catch (Exception e) {
                        MenuController.printInvalid();
                    }
                }
            }
        }
    }
}
