package ramsim.allocation;

import ramsim.ram.MemorySlot;

import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class FirstFitAllocation implements AllocationAlgorithm {
    @Override
    public MemorySlot chooseSlot(ramsim.ram.Process process, List<MemorySlot> memorySlots) {
        for (MemorySlot memorySlot : memorySlots) {
            if(memorySlot.size() >= process.getSize()){
                return memorySlot;
            }
        }
        return null;
    }
}
