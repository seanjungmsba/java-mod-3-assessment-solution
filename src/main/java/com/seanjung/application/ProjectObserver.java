package com.seanjung.application;
import com.seanjung.contracts.HospitalUpdateMessage;

public interface ProjectObserver {
    void onUpdate(HospitalUpdateMessage state);
}
