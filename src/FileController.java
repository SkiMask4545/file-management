import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class FileController {
    private static String filePath;

    public static String getFilePath() {
        return FileController.filePath;
    }

    private static void setFilePath(String filePath) {
        FileController.filePath = filePath;
    }

    public static String getFilePathName() {
        File file = new File(getFilePath());
        return file.getName();
    }

    public static long getFileLength() {
        File file = new File(getFilePath());
        return file.length();
    }

    public static boolean checkFileOpen() {
        if (getFilePath() == null) {
            System.out.println("\nNo file open!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkFilesExist(File[] fileList) {
        if (fileList == null || fileList.length == 0) {
            System.out.println("\nNo files found!");
            return false;
        } else {
            return true;
        }
    }
    
    public static void createFile() {
        System.out.print("\nEnter file name: ");
        String fileName = MenuController.returnScannerNextLineTrim();
        
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
                    MenuController.printlnError();
                    e.printStackTrace();
                }
            }
        }
    }

    public static void openFile() {
        String line;

        if (getFilePath() != null) {
            System.out.println("\nAlready open: " +getFilePathName() + "!");
        } else {
            File fileFolder = new File("files");
            File[] fileList = fileFolder.listFiles();
            
            if (!checkFilesExist(fileList)) {
                return;
            }
            System.out.println();

            for (int i = 0; i < fileList.length; i++) {
                System.out.println((i + 1) + ". " + fileList[i].getName());
            }
            System.out.println((fileList.length + 1) + ". Return");
            MenuController.printCmd();
            line = MenuController.returnScannerNextLineTrim();
            Integer i;

            try {
                i = Integer.valueOf(line) - 1;

                if (i >= 0 && i < fileList.length) {
                    setFilePath(fileList[i].getCanonicalPath());

                    if (getFileLength() == 0) {
                        System.out.println("\nSuccessfully opened: " + fileList[i].getName() + "!");
                    } else {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFilePath()));) {
                            DataController.setData((Data) ois.readObject());
                            System.out.println("\nSuccessfully opened: " + fileList[i].getName() + "!");
                        } catch (Exception e) {
                            MenuController.printlnError();
                            e.printStackTrace();
                        }
                    }
                } else if (i == fileList.length) {
                    MenuController.printlnReturn();
                } else {
                    MenuController.printlnInvalid();
                }
            } catch (Exception e) {
                MenuController.printlnError();
                e.printStackTrace();
            }
        }
    }

    public static void saveAndCloseFile() {
        if (!checkFileOpen()) {
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath()))) {
            oos.writeObject(DataController.getData());
            System.out.println("\nSuccessfully saved and closed: " + getFilePathName() + "!");
            
            DataController.clearData();
            setFilePath(null);
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        String line;
        File fileFolder = new File("files");
        File[] fileList = fileFolder.listFiles();
        
        if (!checkFilesExist(fileList)) {
            return;
        }
        System.out.println();

        for (int i = 0; i < fileList.length; i++) {
            System.out.println((i + 1) + ". " + fileList[i].getName());
        }
        System.out.println((fileList.length + 1) + ". Return");
        MenuController.printCmd();
        line = MenuController.returnScannerNextLineTrim();
        Integer i;

        try {
            i = Integer.valueOf(line) - 1;

            if (i >= 0 && i < fileList.length) {
                if (getFilePath() != null && getFilePath().equals(fileList[i].getCanonicalPath())) {
                    System.out.println("\nAlready open: " + fileList[i].getName() + "!");
                } else {
                    System.out.println("\nAre you sure to delete: " + fileList[i].getName() + "?"
                    + "\n1. Yes"
                    + "\n2. No");
                    MenuController.printCmd();
                    line = MenuController.returnScannerNextLineTrim();

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
                        MenuController.printlnInvalid();
                    }
                }
            } else if (i == fileList.length) {
                MenuController.printlnReturn();
            } else {
                MenuController.printlnInvalid();
            }
        } catch (Exception e) {
            MenuController.printlnError();
            e.printStackTrace();
        }
    }
}
