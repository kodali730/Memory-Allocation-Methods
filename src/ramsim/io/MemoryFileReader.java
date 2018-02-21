package ramsim.io;

import ramsim.ram.MemorySlot;
import ramsim.ram.Process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class MemoryFileReader {
    private String fileName;

    private int listSize;
    private List<MemorySlot> memorySlotList = new ArrayList<>();

    public MemoryFileReader(String fileName){
        this.fileName = fileName;
    }

    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String sCurrentLine;

            listSize = Integer.valueOf(br.readLine());
            int id = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] slotData = sCurrentLine.split(" ");
                int begin = Integer.valueOf(slotData[0]);
                int end = Integer.valueOf(slotData[1]);

                MemorySlot memorySlot = new MemorySlot(id,begin,end);
                this.memorySlotList.add(memorySlot);
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<MemorySlot> getMemorySlotList() {
        List<MemorySlot> clonedMemorySlotList = new ArrayList<>();
        for (MemorySlot memorySlot : memorySlotList) {
            clonedMemorySlotList.add(this.cloneMemorySlot(memorySlot));
        }
        return clonedMemorySlotList;
    }
    private MemorySlot cloneMemorySlot(MemorySlot memorySlot){
        return new MemorySlot(memorySlot.getId(),memorySlot.getStartAddress(),memorySlot.getEndAddress());
    }
}
