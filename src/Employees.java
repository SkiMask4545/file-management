import java.io.Serializable;
import java.util.ArrayList;

public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Employee> list = new ArrayList<>();
    private int idCounter = 1;

    public ArrayList<Employee> getList() {
        return this.list;
    }

    public int getIdCounter() {
        return this.idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

}
