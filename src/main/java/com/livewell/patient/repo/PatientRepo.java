package com.livewell.patient.repo;

import com.livewell.patient.model.Patient;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called patientRepository
// CRUD refers Create, Read, Update, Delete

public interface PatientRepo extends CrudRepository<Patient, Integer> {
    Iterable<Patient> findPatientsByPractitionerId(String practitionerId);
}

