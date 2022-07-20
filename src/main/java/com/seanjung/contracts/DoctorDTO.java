package com.seanjung.contracts;

import lombok.Data;
import java.util.Set;

@Data
public class DoctorDTO {
    private String name;
    private Set<PatientDTO> patients;
}
