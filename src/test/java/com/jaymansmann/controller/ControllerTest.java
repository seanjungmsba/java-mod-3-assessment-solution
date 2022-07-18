package com.jaymansmann.controller;

import com.jaymansmann.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    private Model model;

    @InjectMocks
    private Controller controller;

    @Test
    public void onHospitalNameDecidedTest() {
        this.controller.onHospitalNameDecided("string");
        verify(model).setHospitalName("string");
    }

//    @Test
//    public void onDoctorRequestTest() {
//        this.controller.onDoctorRequest("docName", "docSpec");
//        verify(model).addDoctor("docName", "docSpec");
//    }
//
//    @Test
//    public void onPatientRequest() {
//        this.controller.onPatientRequest("patName", "patSpec");
//        verify(model).addPatient("patName", "patSpec");
//    }
}
