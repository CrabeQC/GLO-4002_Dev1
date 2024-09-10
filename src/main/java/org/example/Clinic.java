package org.example;

import java.util.LinkedList;

public class Clinic {

    private LinkedList<Patient> patientsDoctor;
    private LinkedList<Patient> patientsRadiology;

    public Clinic(/* ... */) {
       patientsDoctor = new LinkedList<>();
       patientsRadiology = new LinkedList<>();
    }

    public void triagePatient(Patient patient) {
        patientsDoctor.addLast(patient);
        if (patient.needsRadiology()) {
            patientsRadiology.addLast(patient);
        }
    }

    public Patient getNextPatientDoctor() {
        return patientsDoctor.isEmpty() ? null : patientsDoctor.pop();
    }

    public Patient getNextPatientRadiology() {
        return patientsRadiology.isEmpty() ? null : patientsRadiology.pop();
    }
    // D'autres méthodes peuvent être nécessaires

}