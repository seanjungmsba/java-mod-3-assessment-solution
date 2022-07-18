package com.jaymansmann.controller;


import com.jaymansmann.model.Ailment;
import com.jaymansmann.model.Model;
import com.jaymansmann.model.Specialty;

public class Controller {
    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void onHospitalNameDecided(String hospitalName) {
        this.model.setHospitalName(hospitalName);
    }

    public void onDoctorRequest(String doctorName, Specialty doctorSpecialty) {
        this.model.addDoctor(doctorName, doctorSpecialty);
    }

    public void onPatientRequest(String patientName, Ailment patientAilment) {
        this.model.addPatient(patientName, patientAilment);
    }

    public void selectPatientForTreatment(String patientName) {
        this.model.treatPatient(patientName);
    }
}
