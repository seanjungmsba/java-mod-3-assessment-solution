package com.seanjung.contracts;

import lombok.Data;
import java.util.Set;
@Data
public class HospitalDTO {
    private String name;
    private Set<DepartmentDTO> departments;
}
