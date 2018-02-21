package ramsim.io;

import ramsim.ram.AllocatedProcess;
import ramsim.ram.Process;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by algis on 17.21.10.
 */
public class ProcessAllocationLog {

    private List<AllocatedProcess> allocatedProcesses = new ArrayList<>();
    private List<Process> unallocatedProcesses = new ArrayList<>();

    public void registerAllocation(AllocatedProcess allocatedProcess){
        this.allocatedProcesses.add(allocatedProcess);
    }

    public void registerFailture(Process process){

        this.unallocatedProcesses.add(process);
    }

    public List<String> requestLog(){
        List<String> log = new ArrayList<>();

        List<AllocatedProcess> copy = new ArrayList<>(this.allocatedProcesses);
        Collections.sort(copy);

        for (AllocatedProcess allocatedProcess : copy) {
            log.add(allocatedProcess.getStartAddress() + " " + allocatedProcess.getEndAddress() + " " + allocatedProcess.getProcess().getId());
        }
        if(unallocatedProcesses.size() == 0){
            log.add("-0");
        }
        else{
            String unallocatedIds = "";
            for (Process unallocatedProcess : unallocatedProcesses) {
                unallocatedIds += "," + unallocatedProcess.getId();
            }
            unallocatedIds = "-" + unallocatedIds.substring(1);
            log.add(unallocatedIds);
        }
        return log;
    }

    public void writeLog(String fileName){
        List<String> log = this.requestLog();
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : log) {
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
