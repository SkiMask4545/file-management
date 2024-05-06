import java.util.Scanner;
import java.util.ArrayList;

public class DataController {
    private static Employees employees = new Employees();

    public static Watches getData() {
        return employees;
    }

    public static void setData(Watches employees) {
        DataController.employees = employees;
    }

    public static void clearData() {
        employees.getArrayList().clear();
        employees.setIdCounter(1);
    }

    public static void printData(Employee employee) {
        System.out.println(
            "\n1. ID: " + employee.getId() +
            "\n2. Surname: " + employee.getSurname() +
            "\n3. Name: " + employee.getName() +
            "\n4. Ttile: " + employee.getTitle() +
            "\n5. Salary: " + employee.getSalary() +
            "\n6. Experience: " + employee.getExperience() +
            "\n7. City: " + employee.getCity());
    }

    public static void inputData(Scanner scanner, Employee employee) {
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
                employee.setExperience(experience);
            } else {
                MenusController.printInvalid();
                System.out.println();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
            System.out.println();
        }
        System.out.print("Input City: ");
        employee.setCity(scanner.nextLine().trim());
    }

    public static boolean checkData(Employees employees) {
        if (employees.getArrayList().size() == 0) {
            System.out.println("\nNo employees found!");
            return false;
        } else {
            return true;
        }
    }
        
    public static void dataAdd(Scanner scanner) {
        if (!FilesController.checkFile()) {
            return;
        }
        Employee employee = new Employee();

        employee.setId(employees.getIdCounter());

        inputData(scanner, employee);

        if (employees.getArrayList().add(employee)) {
            System.out.println("\nSuccessfully added: " + employee.getName() + " " + employee.getSurname() + "!");

            employees.setIdCounter(employees.getIdCounter() + 1);
        } else {
            System.out.println("\nWas not added: " + employee.getName() + " " + employee.getSurname() + "!");
        }
    }

    public static void dataChange(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(employees)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < employees.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname());
        }
        System.out.println((employees.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < employees.getArrayList().size()) {
                Employee employee = employees.getArrayList().get(i);
    
                inputData(scanner, employee);
                
                System.out.println("\nSuccessfully changed: " + employee.getName() + " " + employee.getSurname() + "!");
            } else if (i == employees.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataRemove(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(employees)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < employees.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname());
        }
        System.out.println((employees.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < employees.getArrayList().size()) {
                System.out.println("\nAre you sure to remove: " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname() + "?"
                + "\n1. Yes"
                + "\n2. No");
                System.out.print("\n>");
                line = scanner.nextLine().trim();

                switch (line) {
                    case "1":
                    System.out.println("\nSuccessfully removed: " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname() + "!");
                    employees.getArrayList().remove(i.intValue());
                    break;

                    case "2":
                    System.out.println("\nWas not removed: " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname() + "!");
                    break;

                    default:
                    MenusController.printInvalid();
                }
            } else if (i == employees.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataShow(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(employees)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < employees.getArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + employees.getArrayList().get(i).getName() + " " + employees.getArrayList().get(i).getSurname());
        }
        System.out.println((employees.getArrayList().size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < employees.getArrayList().size()) {
                Employee employee = employees.getArrayList().get(i);
                printData(employee);
                
            } else if (i == employees.getArrayList().size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }

    public static void dataShowUnexperienced(Scanner scanner) {
        if (!FilesController.checkFile() || !checkData(employees)) {
            return;
        }
        Employees employeesUnexperienced = new Employees;

        for (int i = 0; i < employees.getArrayList().size(); i++) {
            if (employees.getArrayList().get(i).getExperience() < 10) {
                employeesUnexperienced.getArrayList.add(employees.getArrayList().get(i));
            }
        }
        if (!checkData(employeesUnexperienced)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < employeesUnexperienced.getArrayList.size(); i++) {
            System.out.println((i + 1) + ". " + employeesUnexperienced.getArrayList.get(i).getName() + " " + employeesUnexperienced.getArrayList.get(i).getSurname());
        }
        System.out.println((employeesUnexperienced.getArrayList.size() + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < employeesUnexperienced.getArrayList.size()) {
                Employee employee = employeesUnexperienced.getArrayList.get(i);
                printData(employee);
                
            } else if (i == employeesUnexperienced.getArrayList.size()) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printInvalid();
        }
    }
}
