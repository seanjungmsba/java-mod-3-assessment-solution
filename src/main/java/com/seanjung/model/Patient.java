package com.seanjung.model;

/*--------POJOs----------------*/
public class Patient {
    private String name;
    private int healthIndex;
    private Ailment ailment;

    public Patient() {}
    public Patient(String name, Ailment ailment) {
        this.name = name;
        this.healthIndex = ailment.getStartingIndex();
        this.ailment = ailment;
    }

    public String getName() {
        return name;
    }

    public int getHealthIndex() {
        return healthIndex;
    }

    public Ailment getAilment() {
        return ailment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }

    public void setAilment(Ailment ailment) {
        this.ailment = ailment;
    }

    public void treat(int healthBoost) {
        this.healthIndex += healthBoost;
    }

    @Override
    public String toString() {
        return "Patient " + name + " " + healthIndex + "/100 (" + ailment + ")";
    }


}
