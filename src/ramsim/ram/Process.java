package ramsim.ram;

/**
 * Created by algis on 17.21.10.
 */
public class Process {
    private final int id;
    private final int size;

    public Process(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
