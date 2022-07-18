package com.jaymansmann.utility;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Mapper {
    private static Mapper INSTANCE;
    private ModelMapper modelMapper;
    private Mapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public synchronized static Mapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Mapper();
        }
        return INSTANCE;
    }

    public <R, S> R map(S sourceObject, Class<R> destinationClass) {
        return this.modelMapper.map(sourceObject, destinationClass);
    }


}
