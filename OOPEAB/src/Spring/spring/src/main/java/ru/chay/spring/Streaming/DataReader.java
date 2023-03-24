package ru.chay.spring.Streaming;

import java.io.FileNotFoundException;

public interface DataReader {
    String reader() throws FileNotFoundException;
}
