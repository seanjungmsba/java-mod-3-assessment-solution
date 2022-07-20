package com.seanjung.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Queue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class HospitalTest {

    @InjectMocks
    private HospitalManager hospitalManager;

    @Mock
    private Map<String, Map<Doctor, Queue<Patient>>> specialtyToDepartment;

//    @Test
//    public void addDoctor_specialtyExists() {
//        // arrange (I'm going to use mocked maps and make them behave the way I want)
//        ReflectionTestUtils.setField(hospital, "specialtyToDepartment", specialtyToDepartment);
//        when(specialtyToDepartment.containsKey(any())).thenReturn(true);
//        Map<Doctor, Queue<Patient>> department = mock(Map.class);
//        when(specialtyToDepartment.get("spec")).thenReturn(department);
//        Doctor doctor = new Doctor("doc", "spec");
//
//        // act (call the method I want to test)
//        hospital.addDoctor(doctor);
//
//        // assert (did I call the methods on the maps that I expected?)
//        verify(specialtyToDepartment).get("spec");
//        verify(department).put(eq(doctor), any());
//    }
//
//
//    @Test
//    public void addDoctor_specialtyDoesNotExist() {
//        // arrange (I'm going to use a mocked map and make it behave the way I want)
//        ReflectionTestUtils.setField(hospital, "specialtyToDepartment", specialtyToDepartment);
//        when(specialtyToDepartment.containsKey(any())).thenReturn(false);
//        Doctor doctor = new Doctor("doc", "spec");
//
//        // act (call the method I want to test)
//        hospital.addDoctor(doctor);
//
//        // assert (did I call the methods on the maps that I expected?)
//        verify(specialtyToDepartment, never()).get("spec");
//        verify(specialtyToDepartment).put(eq("spec"), any());
//
//    }

    // I'd also need tests for addPatient, getDoctorCount, getPatientCount, and probably toString
}
