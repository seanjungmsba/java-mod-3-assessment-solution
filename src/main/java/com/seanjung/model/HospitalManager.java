package com.seanjung.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seanjung.model.exception.DataException;
import java.util.*;
import java.util.stream.Collectors;

public class HospitalManager implements HealthcareProvider{

    private final Hospital hospital;
    public HospitalManager(Hospital hospital) {
        this.hospital = hospital;
    }
    public void setName(String name) {
        this.hospital.setName(name);
    }
    public void addDoctor(Specialty specialty, Doctor doctor) {
        Optional<Department> department = hospital.getDepartmentBySpecialty(specialty);
        if (department.isPresent()) {
           department.get().addDoctor(doctor);
        } else {
            Department newDepartment = new Department(specialty);
            newDepartment.addDoctor(doctor);
            hospital.addDepartment(newDepartment);
        }
    }

    @Override
    public void addPatient(Patient patient) {
        if(this.hasPatient(patient.getName())) {
            throw new DataException("Patient already exists with this name!");
        }
        Department department = hospital.getDepartmentBySpecialty(patient.getAilment().getSpecialty()).orElseThrow(() -> new DataException("We don't serve your disease yet."));
        department.addPatient(patient);
    }


    @Override
    public void treatPatient(String patientName) {
        if (!this.hasPatient(patientName)) {
            throw new DataException("I can't find this patient!");
        }
        this.hospital.treatPatient(patientName);
    }

    @Override
    public boolean hasPatient(String patientName) {
        return this.hospital.hasPatient(patientName);
    }

    @Override
    public Set<Doctor> getDoctors() {
        return this.hospital.getDoctors();
    }

    @Override
    public Set<Patient> getPatients() {
        return this.hospital.getPatients();
    }


    public Set<String> getPatientNames() {
        return this.getPatients().stream().map(Patient::getName).collect(Collectors.toSet());
    }

    @JsonIgnore
    public Set<String> getDoctorNames() {
        return this.getDoctors().stream().map(Doctor::getName).collect(Collectors.toSet());
    }

    public Hospital getHospital() {
        return this.hospital;
    }
}
