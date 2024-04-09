import java.util.Scanner;
import java.util.ArrayList;

public class DataController {
    private static ArrayList<Employee> list = new ArrayList<Employee>();

    public static  ArrayList<Employee> getList() {
        return list;
    }

    public static void setList(ArrayList<Employee> newList) {
        list = newList;
    }

    public static void clearList() {
        list.clear();
    }
        
    public static void dataAdd(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else { 
            Employee employee = new Employee();

            employee.setId(list.size() + 1);

            System.out.print("\nInput Surname: ");
            employee.setSurname(scanner.nextLine().trim());

            System.out.print("Input Name: ");
            employee.setName(scanner.nextLine().trim());

            System.out.print("Input Title: ");
            employee.setTitle(scanner.nextLine().trim());

            System.out.print("Input Salary: ");
            Double salary;
        
            try {
                salary = Double.valueOf(scanner.nextLine().trim());

                if (salary >= 0) {
                    employee.setSalary(salary);
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
                    employee.setExperience(experience);
                } else {
                    MenuController.printInvalid();
                    System.out.println();
                }

            } catch (Exception e) {
                MenuController.printInvalid();
                System.out.println();
            }

            System.out.print("Input City: ");
            employee.setCity(scanner.nextLine().trim());

            if (list.add(employee)) {
                System.out.println("\nSuccessfully added: " + employee.getName() + " " + employee.getSurname());
            } else {
                System.out.println("\nWas not added: " + employee.getName() + " " + employee.getSurname());
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
                        Employee employee = list.get(i);

                        employee.setId(list.get(i).getId());
            
                        System.out.print("\nInput Surname: ");
                        employee.setSurname(scanner.nextLine().trim());
            
                        System.out.print("Input Name: ");
                        employee.setName(scanner.nextLine().trim());
            
                        System.out.print("Input Title: ");
                        employee.setTitle(scanner.nextLine().trim());
            
                        System.out.print("Input Salary: ");
                        Double salary;
                    
                        try {
                            salary = Double.valueOf(scanner.nextLine().trim());
            
                            if (salary >= 0) {
                                employee.setSalary(salary);
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
                                employee.setExperience(experience);
                            } else {
                                MenuController.printInvalid();
                                System.out.println();
                            }
            
                        } catch (Exception e) {
                            MenuController.printInvalid();
                            System.out.println();
                        }
            
                        System.out.print("Input City: ");
                        employee.setCity(scanner.nextLine().trim());
                        
                        System.out.println("\nSuccessfully changed: " + employee.getName() + " " + employee.getSurname());
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
                        Employee employee = list.get(i);

                        System.out.println("\n1. ID: " + employee.getId()
                        + "\n2. Surname: " + employee.getSurname()
                        + "\n3. Name: " + employee.getName()
                        + "\n4. Title: " + employee.getTitle()
                        + "\n5. Salary: " + employee.getSalary()
                        + "\n6. Experience: " + employee.getExperience()
                        + "\n7. City: " + employee.getCity());
                        
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
                ArrayList<Employee> listUnexperienced = new ArrayList<Employee>();

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
                            Employee employee = listUnexperienced.get(i);

                            System.out.println("\n1. ID: " + employee.getId()
                            + "\n2. Surname: " + employee.getSurname()
                            + "\n3. Name: " + employee.getName()
                            + "\n4. Ttile: " + employee.getTitle()
                            + "\n5. Salary: " + employee.getSalary()
                            + "\n6. Experience: " + employee.getExperience()
                            + "\n7. City: " + employee.getCity());
                            
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
