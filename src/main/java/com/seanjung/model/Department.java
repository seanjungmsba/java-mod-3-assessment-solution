package com.seanjung.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seanjung.model.exception.DataException;
import lombok.Getter;
import lombok.Setter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class Department implements HealthcareProvider {
    private Specialty specialty;
    private Set<Doctor> doctors;

    public Department(Specialty specialty) {
        this();
        this.specialty = specialty;
    }

    public Department() {
        this.doctors = new HashSet<>();
    }

    @Override
    @JsonIgnore
    public Set<Patient> getPatients() {
        return doctors.stream().flatMap(doctor -> doctor.getPatients().stream()).collect(Collectors.toSet());
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    @Override
    public void addPatient(Patient patient) {
        Doctor doctor = this.doctors.stream().min(Comparator.comparingInt(doc -> doc.getPatients().size())).orElseThrow(() -> new DataException("Can't find a doctor!"));
        doctor.addPatient(patient);
    }

    @Override
    public void treatPatient(String patientName) {
        this.doctors.forEach(doctor -> doctor.treatPatient(patientName));
    }

    @Override
    public boolean hasPatient(String patientName) {
        return this.doctors.stream().anyMatch(doctor -> doctor.hasPatient(patientName));
    }

}
