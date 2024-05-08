import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Watch> arrayList = new ArrayList<>();
    private int idCounter = 0;

    public ArrayList<Watch> getArrayList() {
        return this.arrayList;
    }

    public int getIdCounter() {
        return this.idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public boolean checkDataExist() {
        if (getArrayList().size() == 0) {
            System.out.println("\nNo data found!");
            return false;
        } else {
            return true;
        }
    }
}
