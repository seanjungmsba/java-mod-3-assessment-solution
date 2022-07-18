package com.jaymansmann.application;

import com.jaymansmann.contracts.HospitalUpdateMessage;

public interface ProjectObserver {
    void onUpdate(HospitalUpdateMessage state);
}
