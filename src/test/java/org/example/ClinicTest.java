package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.VisibleSymptom.MIGRAINE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClinicTest {

    Clinic clinic;

    @BeforeEach
    void setup() {
        clinic = new Clinic();
    }

    @Test
    void whenGetNextPatientDoctor_returnsNull(){
        assertNull(clinic.getNextPatientDoctor());
    }

    @Test
    void whenTriagePatient_PatientNextInLine(){
        Patient patient = new Patient("Joe", 4, MIGRAINE);
        clinic.triagePatient(patient);

        assertNotNull(clinic.getNextPatientDoctor());
    }

    @Test
    void whenTriageTwoPatient_PatientsNextInLineFIFO(){
        Patient patient1 = new Patient("Joe", 4, MIGRAINE);
        Patient patient2 = new Patient("John", 5, MIGRAINE);
        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);

        assertEquals(patient1, clinic.getNextPatientDoctor());
        assertEquals(patient2, clinic.getNextPatientDoctor());
    }

    @Test
    void whenTriageRadiologyPatient_PatientGetsRadiology(){
        Patient patient = mock();
        when(patient.needsRadiology()).thenReturn(true);
        clinic.triagePatient(patient);

        assertNotNull(clinic.getNextPatientRadiology());
    }


}
