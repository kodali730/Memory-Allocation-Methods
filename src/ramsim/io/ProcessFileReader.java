package ramsim.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ramsim.ram.Process;
/**
 * Created by algis on 17.21.10.
 */

public class ProcessFileReader {
    private String fileName;

    private int listSize;
    private List<Process> processList = new ArrayList<>();

    public ProcessFileReader(String fileName){
        this.fileName = fileName;
    }

    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String sCurrentLine;

            listSize = Integer.valueOf(br.readLine());
            int id = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] data = sCurrentLine.split(" ");
                Process process = new Process(Integer.valueOf(data[0]),Integer.valueOf(data[1]));
                this.processList.add(process);
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Process> getProcessList() {
        List<Process> clonedProcessList = new ArrayList<>();
        for (Process process : processList) {
            clonedProcessList.add(this.cloneProcess(process));
        }
        return clonedProcessList;
    }
    private Process cloneProcess(Process process){
        return new Process(process.getId(),process.getSize());
    }
}

