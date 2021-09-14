package com.livewell.patient.resources;

import com.livewell.patient.model.Patient;
import com.livewell.patient.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientResourceClass {
    @Autowired // This means to get the bean called userRepository
    private PatientRepo patientRepository;

    public PatientResourceClass(PatientRepo patientRepository) {
        this.patientRepository = patientRepository;
         List<Patient> patients= new ArrayList<>();
         patients.add(new Patient("Zohra","Shaik", "Practitioner2"));
         patients.add(new Patient("Mohammed","Khan", "Practitioner2"));
         patients.add(new Patient("King","Kong", "Practitioner1"));
         patients.add(new Patient("Ronaldo", "Rest", "Practitioner2"));
         patients.add(new Patient("Count","Dracula","Practitioner1"));
         patientRepository.saveAll(patients);
    }

    @RequestMapping("/{practitionerId}")
    public @ResponseBody Iterable<Patient> getPatientsForPractitioner(@PathVariable("practitionerId") String practitionerId) {

       return patientRepository.findPatientsByPractitionerId(practitionerId);
    }

}
