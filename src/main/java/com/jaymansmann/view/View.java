package com.jaymansmann.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaymansmann.contracts.HospitalUpdateMessage;
import com.jaymansmann.application.ProjectObserver;
import com.jaymansmann.controller.Controller;
import com.jaymansmann.io.MenuItem;
import com.jaymansmann.io.SimpleMenuItem;
import com.jaymansmann.io.UserInputService;
import com.jaymansmann.io.UserOutputService;
import com.jaymansmann.io.validation.BlankValidationRule;
import com.jaymansmann.model.Ailment;
import com.jaymansmann.model.Specialty;
import com.jaymansmann.model.exception.DataException;
import com.jaymansmann.view.output.HospitalOutputFactory;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class View implements ProjectObserver {
    private final UserInputService userInputService;
    private final UserOutputService userOutputService;
    private final Controller controller;

    private HospitalOutputFactory hospitalOutputFactory;

    public View(UserInputService userInputService, UserOutputService userOutputService, Controller controller, HospitalOutputFactory hospitalOutputFactory) {
        this.userInputService = userInputService;
        this.controller = controller;
        this.userOutputService = userOutputService;
        this.hospitalOutputFactory = hospitalOutputFactory;
    }

    @Override
    public void onUpdate(HospitalUpdateMessage state) {
        while(true) {
            try {
                if (state.getHospital().getName() == null) {
                    requestHospitalName();
                } else {
                    String choice = this.userInputService.getOption("What would you like to do? ", getMainMenuOptions(state));
                    if (MainMenuItem.QUIT.matches(choice)) {
                        userOutputService.displayText("Goodbye.");
                        System.exit(0);
                    } else if (MainMenuItem.ADD_DOCTOR.matches(choice)) {
                        requestDoctor();
                    } else if (MainMenuItem.TREAT_PATIENT.matches(choice)) {
                        requestTreatment(state.getPatientNames());
                    } else if (MainMenuItem.ADD_PATIENT.matches(choice)) {
                        requestPatient();
                    } else if (MainMenuItem.SHOW_WORLD.matches(choice)) {
                        displayWorld(state);
                    } else {
                        userOutputService.displayErrorText("What did you type?");
                    }
                }
            } catch (DataException e) {
                userOutputService.displayErrorText("OH NO! " + e.getMessage());
                onUpdate(state);
            } catch (JsonProcessingException e) {
                userOutputService.displayErrorText("OH NO! " + e.getMessage());
                return;
            }
        }
    }

    private Set<MenuItem> getMainMenuOptions(HospitalUpdateMessage state) {
        // Don't show menu options that aren't possible
        return MainMenuItem.getOptions().stream()
                .filter(Predicate.not(item -> item == MainMenuItem.ADD_PATIENT && state.getDoctorNames().isEmpty()))
                .filter(Predicate.not(item -> item == MainMenuItem.TREAT_PATIENT && state.getPatientNames().isEmpty()))
                .collect(Collectors.toSet());
    }

    private void requestHospitalName() {
        String hospitalName = userInputService.getInput("Give me a hospital name", new BlankValidationRule());
        this.controller.onHospitalNameDecided(hospitalName);
    }

    private void requestDoctor() {
        String doctorName = userInputService.getInput("[Adding Doctor] What is the new doctor's name?",
                new BlankValidationRule());
        String doctorSpecialty = userInputService.getOption("Give me that doc's specialty..", Specialty.valuesAsSet().stream().map(SimpleMenuItem::new).collect(Collectors.toSet()));
        this.controller.onDoctorRequest(doctorName, Specialty.valueOf(doctorSpecialty));
    }

    private void requestPatient() {
        String patientName = userInputService.getInput("[Adding Patient] What is the new patient's name?",
                new BlankValidationRule());
        String patientAilment = userInputService.getOption("Give me that patient's ailment.", Ailment.valuesAsSet().stream().map(SimpleMenuItem::new).collect(Collectors.toSet()));
        this.controller.onPatientRequest(patientName, Ailment.valueOf(patientAilment));
    }

    private void requestTreatment(Set<String> patientList) {
        String patientName = userInputService.getOption("Who should be treated next?", patientList.stream().map(SimpleMenuItem::new).collect(Collectors.toSet()));
        this.controller.selectPatientForTreatment(patientName);
    }

    private void displayWorld(HospitalUpdateMessage state) throws JsonProcessingException {
        userOutputService.displayText(this.hospitalOutputFactory.getHospitalDisplayService(HospitalOutputFactory.FANCY).displayHospital(state.getHospital()));
    }

}
