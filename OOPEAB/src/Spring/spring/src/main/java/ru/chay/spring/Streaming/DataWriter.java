package ru.chay.spring.Streaming;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataWriter {
    void writer(String s) throws IOException;
}
