import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class FileController {
    private static String filePath;

    public static String getFilePath() {
        return filePath;
    }

    public static String getFileName() {
        File file = new File(filePath);
        return file.getName();
    }

    public static long getFileLength() {
        File file = new File(filePath);
        return file.length();
    }
    
    public static void fileNew(Scanner scanner) {
        System.out.print("\nEnter file name: ");
        String fileName = scanner.nextLine().trim();
        
        if (fileName.length() == 0) {
            System.out.println("\nFile name can not be empty!");
        } else {
            fileName = fileName + ".data";
            File file = new File("data/" + fileName);
        
            if (file.exists()) {
                System.out.println("\nFile already exists: " + fileName + "!");
            } else {
                try {
                    file.getParentFile().mkdirs();

                    if (file.createNewFile()) {
                        System.out.println("\nSuccessfully created: " + fileName + "!");
                    } else {
                        System.out.println("\nWas not created: " + fileName + "!");
                    }

                } catch (Exception e) {
                    System.out.println("\nAn error has occurred!\n");
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void fileOpen(Scanner scanner) {
        if (filePath != null) {
            System.out.println("\nAlready open: " +getFileName() + "!");
        } else {
            File folder = new File("data");
            File[] list = folder.listFiles();
            
            if (list == null || list.length == 0) {
                System.out.println("\nNo files found!");
            } else {
                System.out.println();
    
                for (int i = 0; i < list.length; i++) {
                    System.out.println((i + 1) + ". " + list[i].getName());
                }
                System.out.println((list.length + 1) + ". Return to the Menu");
                System.out.print("\n>");
                String line = scanner.nextLine().trim();
                Integer i;
    
                try {
                    i = Integer.valueOf(line) - 1;
    
                    if (i >= 0 && i < list.length) {
                        filePath = list[i].getCanonicalPath();

                        if (getFileLength() == 0) {
                            System.out.println("\nSuccessfully opened: " + list[i].getName() + "!");
                        } else {
                            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));) {
                                DataController.setData((Data) ois.readObject());
                                System.out.println("\nSuccessfully opened: " + list[i].getName() + "!");
                            } catch (Exception e) {
                                System.out.println("\nAn error has occurred!\n");
                                System.out.println(e.getMessage());
                            }
                        }

                    } else if (i == list.length) {
                        MenuController.printReturn();
                    } else {
                        MenuController.printInvalid();
                    }

                } catch (Exception e) {
                    System.out.println("\nAn error has occurred!\n");
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void fileSaveAndClose() {
        if (filePath == null) {
            System.out.println("\nNo file open!");
        } else { 
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(DataController.getData());
                System.out.println("\nSuccessfully saved: " + getFileName() + "!");
                
                DataController.clearData();
                filePath = null;
            } catch (Exception e) {
                System.out.println("\nAn error has occurred!\n");
                System.out.println(e.getMessage());
            }
        }
    }

    public static void fileDelete(Scanner scanner) {
        File folder = new File("data");
        File[] list = folder.listFiles();
        
        if (list == null || list.length == 0) {
            System.out.println("\nNo files found!");
        } else {
            System.out.println();

            for (int i = 0; i < list.length; i++) {
                System.out.println((i + 1) + ". " + list[i].getName());
            }

            System.out.println((list.length + 1) + ". Return to the Menu");
            System.out.print("\n>");
            String line = scanner.nextLine().trim();
            Integer i;

            try {
                i = Integer.valueOf(line) - 1;

                if (i >= 0 && i < list.length) {
                    if (filePath != null && filePath.equals(list[i].getCanonicalPath())) {
                        System.out.println("\nAlready open: " + list[i].getName() + "!");
                    } else {
                        System.out.println("\nAre you sure to delete: " + list[i].getName() + "?"
                        + "\n1. Yes"
                        + "\n2. No");
                        System.out.print("\n>");
                        line = scanner.nextLine().trim();

                        switch (line) {
                            case "1":
                            if (list[i].delete()) {
                                System.out.println("\nSuccessfully deleted: " + list[i].getName() + "!");
                            } else {
                                System.out.println("\nWas not deleted: " + list[i].getName() + "!");
                            }
                            break;

                            case "2":
                            System.out.println("\nWas not deleted: " + list[i].getName() + "!");
                            break;

                            default:
                            MenuController.printInvalid();
                        }
                    }
                } else if (i == list.length) {
                    MenuController.printReturn();
                } else {
                    MenuController.printInvalid();
                }
            } catch (Exception e) {
                System.out.println("\nAn error has occurred!\n");
                System.out.println(e.getMessage());
            }
        }
    }
    
}
