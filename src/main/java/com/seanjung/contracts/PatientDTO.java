package com.seanjung.contracts;

import lombok.Data;

@Data
public class PatientDTO {
    private String name;
    private int healthIndex;
    private String ailment;
}
