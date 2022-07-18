package com.jaymansmann.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


public interface HealthcareProvider {
    void addPatient(Patient patient);
    void treatPatient(String patientName);

    boolean hasPatient(String patientName);

    Set<Doctor> getDoctors();
    Set<Patient> getPatients();
}
