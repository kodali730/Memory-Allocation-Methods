package ramsim;

import ramsim.allocation.AllocationAlgorithm;
import ramsim.allocation.BestFitAllocation;
import ramsim.allocation.FirstFitAllocation;
import ramsim.allocation.WorstFitAllocation;
import ramsim.io.MemoryFileReader;
import ramsim.io.ProcessAllocationLog;
import ramsim.io.ProcessFileReader;
import ramsim.ram.MemorySlot;
import ramsim.ram.Process;
import ramsim.ram.RAM;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<AllocationAlgorithm> algorithmList = new ArrayList<>();
        algorithmList.add(new FirstFitAllocation());
        algorithmList.add(new BestFitAllocation());
        algorithmList.add(new WorstFitAllocation());

        ProcessFileReader processFileReader = new ProcessFileReader("proc1.txt");
        processFileReader.readFile();
        MemoryFileReader memoryFileReader = new MemoryFileReader("mem1.txt");
        memoryFileReader.readFile();

        for (AllocationAlgorithm allocationAlgorithm : algorithmList) {
            List<Process> processes = processFileReader.getProcessList();
            List<MemorySlot> memorySlots = memoryFileReader.getMemorySlotList();

            RAM ram = new RAM(processes,memorySlots,allocationAlgorithm);
            ram.allocate();

            ProcessAllocationLog processAllocationLog = ram.getProcessAllocationLog();
            List<String> log = processAllocationLog.requestLog();
            System.out.println("RESULT");
            for (String s : log) {
                System.out.println("  " + s);
            }
            System.out.println();

            processAllocationLog.writeLog("out1.txt");
        }

    }
}
