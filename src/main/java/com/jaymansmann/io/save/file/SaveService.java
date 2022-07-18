package com.jaymansmann.io.save.file;

import com.jaymansmann.application.ProjectObserver;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SaveService extends ProjectObserver {
    void save(String json) throws FileNotFoundException, IOException;
    String read() throws IOException;
}
