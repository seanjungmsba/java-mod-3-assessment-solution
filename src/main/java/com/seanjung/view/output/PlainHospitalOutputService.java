package com.seanjung.view.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seanjung.contracts.HospitalDTO;
import com.seanjung.utility.Jsonifier;

public class PlainHospitalOutputService implements  HospitalOutputService {


    @Override
    public String displayHospital(HospitalDTO hospital) {
        try {
            return Jsonifier.getInstance().prettyPrint(Jsonifier.getInstance().convertToJSON(hospital));
        } catch (JsonProcessingException e) {
            return "ERROR: " + e.getMessage();
        }
    }
}
