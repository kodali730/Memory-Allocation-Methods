package ramsim.allocation;

import ramsim.ram.MemorySlot;
import ramsim.ram.Process;

import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class WorstFitAllocation implements AllocationAlgorithm {
    @Override
    public MemorySlot chooseSlot(Process process, List<MemorySlot> memorySlots) {
        MemorySlot bestMemorySlot = null;
        for (MemorySlot memorySlot : memorySlots) {
            if(bestMemorySlot == null || memorySlot.size() > bestMemorySlot.size()){
                bestMemorySlot = memorySlot;
            }
        }
        if(bestMemorySlot != null){
            if(bestMemorySlot.size() >= process.getSize())
                return bestMemorySlot;
        }
        return null;
    }
}
