package com.livewell.patient.resources;

import com.livewell.patient.model.Patient;
import com.livewell.patient.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
         patients.add(new Patient("Deen Jane"));
         patients.add(new Patient("Mohammed Khan"));
         patients.add(new Patient("King Kong"));
         patients.add(new Patient("Ronald Reagan"));
         patients.add(new Patient("Count Dracula"));
           patientRepository.saveAll(patients);
    }

    @RequestMapping ("/list")
    public Iterable<Patient> getPatients()
    {
        return patientRepository.findAll();
    }

    @RequestMapping("/getPatientIdByName")
    public @ResponseBody int getPatientId(@RequestParam(name = "name") String name)
    {
       Patient patient = patientRepository.findByName(name);
       if (patient != null){
           return patient.getId();
       }

       return 0;
    }

}
