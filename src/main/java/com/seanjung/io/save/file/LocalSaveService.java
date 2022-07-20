package com.seanjung.io.save.file;

import com.seanjung.contracts.HospitalUpdateMessage;
import com.seanjung.io.UserOutputService;
import com.seanjung.utility.Jsonifier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalSaveService implements  SaveService {
    private final static String LOCAL_FILE = "hospital_data.json";

    private UserOutputService userOutputService;

    public LocalSaveService(UserOutputService userOutputService) {
        this.userOutputService = userOutputService;
    }

    @Override
    public void save(String json) throws IOException {
        Path path = Paths.get(LOCAL_FILE);
        Files.writeString(path, json);
    }

    @Override
    public String read() throws IOException  {
        try {
            Path path = Paths.get(LOCAL_FILE);
            if(path.toFile().exists()) {
                return Files.readString(path);
            }
            return "";
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void onUpdate(HospitalUpdateMessage state) {
        try {
            this.save(Jsonifier.getInstance().convertToJSON(state.getHospital()));
        } catch (IOException e) {
            this.userOutputService.displayErrorText("Error " + e.getMessage());
        }
    }
}
