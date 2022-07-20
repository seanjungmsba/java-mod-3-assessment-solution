package com.seanjung.model;

import com.seanjung.contracts.HospitalDTO;
import com.seanjung.contracts.HospitalUpdateMessage;
import com.seanjung.application.ProjectObservable;
import com.seanjung.utility.Jsonifier;
import com.seanjung.utility.Mapper;

public class Model extends ProjectObservable {
    private HospitalManager hospitalManager;
    public void start(String jsonData) {
        this.hospitalManager = new HospitalManager(Jsonifier.getInstance().convertToObject(jsonData, Hospital.class));
        notifyObservers(buildHospitalUpdateMessage());
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalManager.setName(hospitalName);
        notifyObservers(buildHospitalUpdateMessage());
    }

    public void addDoctor(String name, Specialty specialty) {
        Doctor doctor = new Doctor(name);
        this.hospitalManager.addDoctor(specialty, doctor);
        notifyObservers(buildHospitalUpdateMessage());
    }

    public void addPatient(String name, Ailment ailment) {
        Patient patient = new Patient(name, ailment);
        this.hospitalManager.addPatient(patient);
        notifyObservers(buildHospitalUpdateMessage());
    }

    public void treatPatient(String patientName) {
        this.hospitalManager.treatPatient(patientName);
        notifyObservers(buildHospitalUpdateMessage());
    }

    private HospitalUpdateMessage buildHospitalUpdateMessage() {
        return new HospitalUpdateMessage(hospitalManager.getPatientNames(), hospitalManager.getDoctorNames(), Mapper.getInstance().map(hospitalManager.getHospital(), HospitalDTO.class));
    }

}
