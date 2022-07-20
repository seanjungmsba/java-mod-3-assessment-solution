package com.seanjung.io.save.file;

import com.seanjung.application.ProjectObserver;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SaveService extends ProjectObserver {
    void save(String json) throws FileNotFoundException, IOException;
    String read() throws IOException;
}
