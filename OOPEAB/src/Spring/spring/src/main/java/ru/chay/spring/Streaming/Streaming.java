package ru.chay.spring.Streaming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Streaming {
    private DataReader dataReader;
    private DataWriter dataWriter;
    private List<Process> list;

    public Streaming(DataReader dataReader, DataWriter dataWriter, List<Process> list) {
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
        this.list = list;
    }
    public void compile() throws IOException {
        String tmp=dataReader.reader();
        for(Process<String> p:list){
            tmp=p.process(tmp);
        }
        dataWriter.writer(tmp);
    }
}
