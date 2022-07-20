package com.seanjung.contracts;


import java.util.Set;

public class HospitalUpdateMessage {
    private Set<String> patientNames;
    private Set<String> doctorNames;
    private HospitalDTO hospital;

    public HospitalUpdateMessage(Set<String> patientNames, Set<String> doctorNames, HospitalDTO hospital) {
        this.patientNames = patientNames;
        this.doctorNames = doctorNames;
        this.hospital = hospital;
    }

    public Set<String> getPatientNames() {
        return patientNames;
    }

    public Set<String> getDoctorNames() {
        return doctorNames;
    }

    public HospitalDTO getHospital() {
        return hospital;
    }
}
