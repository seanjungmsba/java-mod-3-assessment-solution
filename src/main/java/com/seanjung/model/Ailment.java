package com.seanjung.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Ailment {

    MESOTHELIOMA(Specialty.ONCOLOGY, 1, 50),
    PREGNANCY(Specialty.OBSTETRICS, 1, 60),
    ACNE(Specialty.DERMATOLOGY, 1, 90),
    SKIN_CANCER(Specialty.DERMATOLOGY, 5, 75),
    UNIDENTIFIED_SKIN_FUNGUS(Specialty.DERMATOLOGY, 3, 70);

    private Specialty specialty;
    private int gainsFromTreatment;
    private int startingIndex;

    Ailment(Specialty specialty, int gainsFromTreatment, int startingIndex) {
        this.specialty = specialty;
        this.gainsFromTreatment = gainsFromTreatment;
        this.startingIndex = startingIndex;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public int getGainsFromTreatment() {
        return gainsFromTreatment;
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public static Set<String> valuesAsSet() {
        return Stream.of(values()).map(Ailment::name).collect(Collectors.toSet());
    }

}
