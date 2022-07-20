package com.seanjung.view.output;

public class HospitalOutputFactory  {
    private PlainHospitalOutputService plainHospitalOutputService;

    private FancyHospitalOutputService fancyHospitalOutputService;

    // public static final ints are how Java developers made a list of options back before Enums existed.
    public static final int FANCY = 1;
    public static final int PLAIN = 0;

    public HospitalOutputFactory(PlainHospitalOutputService plainHospitalOutputService, FancyHospitalOutputService fancyHospitalOutputService) {
        this.plainHospitalOutputService = plainHospitalOutputService;
        this.fancyHospitalOutputService = fancyHospitalOutputService;
    }

    public HospitalOutputService getHospitalDisplayService(int type) {
        switch(type) {
            case FANCY:
                return fancyHospitalOutputService;
            case PLAIN:
            default:
              return plainHospitalOutputService; // I only made one HospitalOutputService so far.
        }
    }
}
