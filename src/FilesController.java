import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class FilesController {
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

    public static boolean checkFile() {
        if (filePath == null) {
            System.out.println("\nNo file open!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkFiles(File[] fileList) {
        if (fileList == null || fileList.length == 0) {
            System.out.println("\nNo files found!");
            return false;
        } else {
            return true;
        }
    }
    
    public static void fileNew(Scanner scanner) {
        System.out.print("\nEnter file name: ");
        String fileName = scanner.nextLine().trim();
        
        if (fileName.length() == 0) {
            System.out.println("\nFile name can not be empty!");
        } else {
            fileName = fileName + ".data";
            File file = new File("files/" + fileName);
        
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
                    MenusController.printError();
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void fileOpen(Scanner scanner) {
        if (filePath != null) {
            System.out.println("\nAlready open: " +getFileName() + "!");
        } else {
            File fileFolder = new File("files");
            File[] fileList = fileFolder.listFiles();
            
            if (!checkFiles(fileList)) {
                return;
            }
            System.out.println();

            for (int i = 0; i < fileList.length; i++) {
                System.out.println((i + 1) + ". " + fileList[i].getName());
            }
            System.out.println((fileList.length + 1) + ". Return");
            System.out.print("\n>");
            String line = scanner.nextLine().trim();
            Integer i;

            try {
                i = Integer.valueOf(line) - 1;

                if (i >= 0 && i < fileList.length) {
                    filePath = fileList[i].getCanonicalPath();

                    if (getFileLength() == 0) {
                        System.out.println("\nSuccessfully opened: " + fileList[i].getName() + "!");
                    } else {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));) {
                            DataController.setData((Watches) ois.readObject());
                            System.out.println("\nSuccessfully opened: " + fileList[i].getName() + "!");
                        } catch (Exception e) {
                            MenusController.printError();
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (i == fileList.length) {
                    MenusController.printReturn();
                } else {
                    MenusController.printInvalid();
                }
            } catch (Exception e) {
                MenusController.printError();
                System.out.println(e.getMessage());
            }
        }
    }

    public static void fileSaveAndClose() {
        if (!checkFile()) {
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(DataController.getData());
            System.out.println("\nSuccessfully saved: " + getFileName() + "!");
            
            DataController.clearData();
            filePath = null;
        } catch (Exception e) {
            MenusController.printError();
            System.out.println(e.getMessage());
        }
    }

    public static void fileDelete(Scanner scanner) {
        File fileFolder = new File("files");
        File[] fileList = fileFolder.listFiles();
        
        if (!checkFiles(fileList)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < fileList.length; i++) {
            System.out.println((i + 1) + ". " + fileList[i].getName());
        }
        System.out.println((fileList.length + 1) + ". Return");
        System.out.print("\n>");
        String line = scanner.nextLine().trim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < fileList.length) {
                if (filePath != null && filePath.equals(fileList[i].getCanonicalPath())) {
                    System.out.println("\nAlready open: " + fileList[i].getName() + "!");
                } else {
                    System.out.println("\nAre you sure to delete: " + fileList[i].getName() + "?"
                    + "\n1. Yes"
                    + "\n2. No");
                    System.out.print("\n>");
                    line = scanner.nextLine().trim();

                    switch (line) {
                        case "1":
                        if (fileList[i].delete()) {
                            System.out.println("\nSuccessfully deleted: " + fileList[i].getName() + "!");
                        } else {
                            System.out.println("\nWas not deleted: " + fileList[i].getName() + "!");
                        }
                        break;

                        case "2":
                        System.out.println("\nWas not deleted: " + fileList[i].getName() + "!");
                        break;

                        default:
                        MenusController.printInvalid();
                    }
                }
            } else if (i == fileList.length) {
                MenusController.printReturn();
            } else {
                MenusController.printInvalid();
            }
        } catch (Exception e) {
            MenusController.printError();
            System.out.println(e.getMessage());
        }
    }
}
