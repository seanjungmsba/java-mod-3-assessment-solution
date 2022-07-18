package com.jaymansmann.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaymansmann.model.exception.DataException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class Doctor implements HealthcareProvider {
    private String name;

    private Set<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new HashSet<>();
    }

    @Override
    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    @Override
    public void treatPatient(String patientName) {
        if(!hasPatient(patientName)) {
            return;
        }
        Patient treatMe = this.patients.stream().filter(patient -> patient.getName().equalsIgnoreCase(patientName)).findFirst().orElseThrow(() -> new DataException("Can't find patient"));
        treatMe.treat(treatMe.getAilment().getGainsFromTreatment());
        if(treatMe.getHealthIndex() >= 100) {
            this.patients.remove(treatMe);
        }
    }

    @Override
    public boolean hasPatient(String patientName) {
        return this.patients.stream().anyMatch(patient -> patient.getName().equalsIgnoreCase(patientName));
    }

    @Override
    @JsonIgnore
    public Set<Doctor> getDoctors() {
        return Set.of(this);
    }

}
