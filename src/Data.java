import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Employees> list = new ArrayList<>();
    private int idCounter = 1;

    public ArrayList<Employees> getList() {
        return this.list;
    }

    public int getIdCounter() {
        return this.idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

}
