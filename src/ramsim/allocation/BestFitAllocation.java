package ramsim.allocation;

import ramsim.ram.MemorySlot;
import ramsim.ram.Process;

import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class BestFitAllocation implements AllocationAlgorithm {
    @Override
    public MemorySlot chooseSlot(Process process, List<MemorySlot> memorySlots) {
        MemorySlot bestMemorySlot = null;
        for (MemorySlot memorySlot : memorySlots) {
            if(process.getSize() <= memorySlot.size()){
                if(bestMemorySlot == null || memorySlot.size() < bestMemorySlot.size()){
                    bestMemorySlot = memorySlot;
                }
            }
        }
        return bestMemorySlot;
    }
}
