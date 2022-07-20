package com.seanjung.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Specialty {
    DERMATOLOGY(Integer.MAX_VALUE, false),
    ONCOLOGY(100, true),
    OBSTETRICS(40, true);
    private int numberOfTreatmentsToBeFullyCured;
    private boolean fullyCurable;
    Specialty(int numberOfTreatmentsToBeFullyCured, boolean fullyCurable) {
        this.numberOfTreatmentsToBeFullyCured = numberOfTreatmentsToBeFullyCured;
        this.fullyCurable = fullyCurable;
    }

    public int getNumberOfTreatmentsToBeFullyCured() {
        return numberOfTreatmentsToBeFullyCured;
    }

    public boolean isFullyCurable() {
        return fullyCurable;
    }

    public static Set<String> valuesAsSet() {
        return Stream.of(values()).map(Specialty::name).collect(Collectors.toSet());
    }
}
