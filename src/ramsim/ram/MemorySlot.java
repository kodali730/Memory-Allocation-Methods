package ramsim.ram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class MemorySlot {
    private int id;
    private int startAddress;
    private int endAddress;
    private int tailAddress;
    private List<AllocatedProcess> allocatedProcesses = new ArrayList<>();

    public MemorySlot(int id, int startAddress,int endAddress) {
        this.id = id;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.tailAddress = startAddress;
    }

    public int getId() {
        return id;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getEndAddress() {
        return endAddress;
    }

    public int size(){
        return endAddress - tailAddress;
    }

    public AllocatedProcess allocate(Process process){
        if(this.size() < process.getSize())
            throw new IllegalStateException();
        AllocatedProcess allocatedProcess = new AllocatedProcess(process,this.tailAddress);
        this.tailAddress = allocatedProcess.getEndAddress();
        this.allocatedProcesses.add(allocatedProcess);
        return allocatedProcess;
    }

    @Override
    public String toString() {
        return "MemorySlot{" +
                "id=" + id +
                ", startAddress=" + startAddress +
                ", endAddress=" + endAddress +
                ", allocatedProcessCount=" + this.allocatedProcesses.size() +
                ", availableSpace=" + this.size() +
                '}';
    }
}
