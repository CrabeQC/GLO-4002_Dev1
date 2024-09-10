package org.example;

public class Patient {

    private String name;
    private int gravity;
    private VisibleSymptom visibleSymptom;


    public Patient(String name, int gravity, VisibleSymptom visibleSymptom) {
        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;
    }

    public boolean needsRadiology() {
        return (this.visibleSymptom == VisibleSymptom.BROKEN_BONE || this.visibleSymptom == VisibleSymptom.SPRAIN);
    }

}
