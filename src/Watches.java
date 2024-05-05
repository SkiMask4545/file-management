import java.io.Serializable;
import java.util.ArrayList;

public class Watches implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Watch> arrayList = new ArrayList<>();
    private int idCounter = 1;

    public ArrayList<Watch> getArrayList() {
        return this.arrayList;
    }

    public int getIdCounter() {
        return this.idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

}
