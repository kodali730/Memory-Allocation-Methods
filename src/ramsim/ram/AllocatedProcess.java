package ramsim.ram;

/**
 * Created by algis on 17.21.10.
 */
public class AllocatedProcess implements Comparable<AllocatedProcess>{
    private final Process process;
    private final int startAddress;
    private final int endAddress;

    public AllocatedProcess(Process process, int startAddress) {
        this.process = process;
        this.startAddress = startAddress;
        this.endAddress = startAddress +process.getSize();
    }

    public Process getProcess() {
        return process;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getEndAddress() {
        return endAddress;
    }

    public int getSize(){
        return this.process.getSize();
    }

    @Override
    public String toString() {
        return "AllocatedProcess{" +
                "process=" + process +
                ", startAddress=" + startAddress +
                ", endAddress=" + endAddress +
                '}';
    }

    @Override
    public int compareTo(AllocatedProcess o) {
        return Integer.valueOf(this.startAddress).compareTo(Integer.valueOf(o.getStartAddress()));
    }
}
