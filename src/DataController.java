import java.util.Scanner;
import java.util.ArrayList;

public class DataController {
    private static Employees employees = new Employees();

    public static Employees getData() {
        return employees;
    }

    public static void setData(Employees employees) {
        DataController.employees = employees;
    }

    public static void clearData() {
        employees.getList().clear();
        employees.setIdCounter(1);
    }
        
    public static void dataAdd(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else { 
            Employee employee = new Employee();

            employee.setId(employees.getIdCounter());

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

            if (employees.getList().add(employee)) {
                System.out.println("\nSuccessfully added: " + employee.getName() + " " + employee.getSurname() + "!");

                employees.setIdCounter(employees.getIdCounter() + 1);
            } else {
                System.out.println("\nWas not added: " + employee.getName() + " " + employee.getSurname() + "!");
            }
        }
    }

    public static void dataChange(Scanner scanner) {
        if (FileController.getFilePath() == null) {
            System.out.println("\nNo file open!");
        } else {            
            if (employees.getList().size() == 0) {
                System.out.println("\nNo employees found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < employees.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname());
                }
                
                System.out.println((employees.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < employees.getList().size()) {
                        Employee employee = employees.getList().get(i);

                        employee.setId(employees.getList().get(i).getId());
            
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
                        
                        System.out.println("\nSuccessfully changed: " + employee.getName() + " " + employee.getSurname() + "!");
                    } else if (i == employees.getList().size()) {
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
            if (employees.getList().size() == 0) {
                System.out.println("\nNo employees found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < employees.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname());
                }
                
                System.out.println((employees.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < employees.getList().size()) {
                        System.out.println("\nAre you sure to remove: " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname() + "?"
                        + "\n1. Yes"
                        + "\n2. No");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();

                        switch (line) {
                            case "1":
                            System.out.println("\nSuccessfully removed: " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname() + "!");
                            employees.getList().remove(i.intValue());
                            break;

                            case "2":
                            System.out.println("\nWas not removed: " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname() + "!");
                            break;

                            default:
                            MenuController.printInvalid();
                        }
                    } else if (i == employees.getList().size()) {
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
            if (employees.getList().size() == 0) {
                System.out.println("\nNo employees found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < employees.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + employees.getList().get(i).getName() + " " + employees.getList().get(i).getSurname());
                }
                
                System.out.println((employees.getList().size() + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < employees.getList().size()) {
                        Employee employee = employees.getList().get(i);

                        System.out.println("\n1. ID: " + employee.getId()
                        + "\n2. Surname: " + employee.getSurname()
                        + "\n3. Name: " + employee.getName()
                        + "\n4. Title: " + employee.getTitle()
                        + "\n5. Salary: " + employee.getSalary()
                        + "\n6. Experience: " + employee.getExperience()
                        + "\n7. City: " + employee.getCity());
                        
                    } else if (i == employees.getList().size()) {
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
            if (employees.getList().size() == 0) {
                System.out.println("\nNo employees found!");
            } else {
                ArrayList<Employee> listUnexperienced = new ArrayList<>();

                for (int i = 0; i < employees.getList().size(); i++) {
                    if (employees.getList().get(i).getExperience() < 10) {
                        listUnexperienced.add(employees.getList().get(i));
                    }
                }

                if (listUnexperienced.size() == 0) {
                    System.out.println("\nNo employees found!");
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
