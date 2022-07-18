package com.jaymansmann.contracts;

import lombok.Data;

import java.util.Set;

@Data
public class DepartmentDTO {
    private String specialty;
    private Set<DoctorDTO> doctors;
}
