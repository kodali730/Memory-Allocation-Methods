package ramsim.allocation;

import ramsim.ram.MemorySlot;
import ramsim.ram.Process;

import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public interface AllocationAlgorithm {
    MemorySlot chooseSlot(Process process,List<MemorySlot> memorySlots);
}
