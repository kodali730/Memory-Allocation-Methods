package ramsim.ram;

import ramsim.allocation.AllocationAlgorithm;
import ramsim.io.ProcessAllocationLog;

import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class RAM {

    private List<Process> processes;
    private List<MemorySlot> memorySlots;
    private AllocationAlgorithm allocationAlgorithm;
    private ProcessAllocationLog processAllocationLog = new ProcessAllocationLog();

    public RAM(List<Process> processes, List<MemorySlot> memorySlots, AllocationAlgorithm allocationAlgorithm) {
        this.processes = processes;
        this.memorySlots = memorySlots;
        this.allocationAlgorithm = allocationAlgorithm;
    }

    public void allocate(){
        System.out.println("RAM ALLOCATOR USING " + allocationAlgorithm.getClass().getSimpleName());

        this.printSystemState();
        System.out.println("  START ALLOCATION ROUTINE");
        for (Process process : processes) {
            MemorySlot memorySlot = allocationAlgorithm.chooseSlot(process, memorySlots);
            if(memorySlot != null){
                System.out.println("    ALLOCATING " + process + " TO " + memorySlot);
                AllocatedProcess allocatedProcess = memorySlot.allocate(process);
                processAllocationLog.registerAllocation(allocatedProcess);
            }
            else{
                System.out.println("    UNABLE TO ALLOCATE " + process);
                processAllocationLog.registerFailture(process);
            }
        }
    }

    private void printSystemState(){
        this.printProcesses("  ");
        this.printMemorySlots("  ");
    }

    private void printProcesses(String offset){
        System.out.println(offset + "LIST OF PROCESSES");
        for (Process process : processes) {
            System.out.println(offset + "  " + process);
        }
    }
    private void printMemorySlots(String offset){
        System.out.println(offset + "LIST OF MEMORY SLOTS");
        for (MemorySlot memorySlot2 : memorySlots) {
            System.out.println(offset + "  "  + memorySlot2);
        }
    }

    public ProcessAllocationLog getProcessAllocationLog() {
        return processAllocationLog;
    }
}


