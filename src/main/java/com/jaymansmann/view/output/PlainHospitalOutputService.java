package com.jaymansmann.view.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaymansmann.contracts.HospitalDTO;
import com.jaymansmann.utility.Jsonifier;

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
