package com.jaymansmann.application;

import com.jaymansmann.contracts.HospitalUpdateMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class ProjectObservable {
    private List<ProjectObserver> observers;

    public ProjectObservable() {
        this.observers = new ArrayList<>();
    }

    public final void addObserver(ProjectObserver observer) {
        this.observers.add(observer);
    }

    protected final void notifyObservers(HospitalUpdateMessage state) {
        this.observers.forEach(observer -> observer.onUpdate(state));
    }
}
