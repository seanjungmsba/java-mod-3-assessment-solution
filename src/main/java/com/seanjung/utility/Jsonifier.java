package com.seanjung.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonifier {
    private final ObjectMapper OBJECT_MAPPER;
    private static Jsonifier instance;
    private Jsonifier() {
        this.OBJECT_MAPPER = new ObjectMapper();
    }

    public static Jsonifier getInstance() {
        if (instance == null) {
            instance = new Jsonifier();
        }
        return instance;
    }

    public <T> String convertToJSON(T hospital) {
        try {
            return OBJECT_MAPPER.writeValueAsString(hospital);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem writing json.");
        }
    }

    public <T> T convertToObject(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem reading json.");
        }
    }

    public String prettyPrint(String json) throws JsonProcessingException {
        Object jsonObject = OBJECT_MAPPER.readValue(json, Object.class);
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    }


}
