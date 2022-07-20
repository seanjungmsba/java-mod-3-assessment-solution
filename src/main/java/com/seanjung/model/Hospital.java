package com.seanjung.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Hospital implements HealthcareProvider {

    private Set<Department> departments;
    private String name;

    public Hospital() {
        this.departments = new HashSet<>();
    }


    public Optional<Department> getDepartmentBySpecialty(Specialty specialty) {
        return this.departments.stream().filter(department -> department.getSpecialty() == specialty).findFirst();
    }

    public void addDepartment(Department newDepartment) {
        this.departments.add(newDepartment);
    }

    @Override
    public void addPatient(Patient patient) {
        this.getDepartmentBySpecialty(patient.getAilment().getSpecialty()).ifPresent(department -> department.addPatient(patient));
    }

    @Override
    public void treatPatient(String patientName) {
        this.departments.forEach(department -> department.treatPatient(patientName));
    }

    @Override
    public boolean hasPatient(String patientName) {
        return this.departments.stream().anyMatch(department -> department.hasPatient(patientName));
    }

    @Override
    @JsonIgnore
    public Set<Doctor> getDoctors() {
        return this.departments.stream().flatMap(department -> department.getDoctors().stream()).collect(Collectors.toSet());
    }

    @Override
    @JsonIgnore
    public Set<Patient> getPatients() {
        return this.departments.stream().flatMap(department -> department.getPatients().stream()).collect(Collectors.toSet());
    }
}
