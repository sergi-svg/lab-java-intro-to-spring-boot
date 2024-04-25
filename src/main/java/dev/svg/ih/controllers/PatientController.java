package dev.svg.ih.controllers;

import dev.svg.ih.model.Patient;
import dev.svg.ih.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getDoctorsById(@PathVariable("id") Long id) {
        return patientService.getPatientsById(id);
    }

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(@RequestParam Optional<String> dateOfBirth, @RequestParam Optional<String> admittedBy) {
        if (dateOfBirth.isPresent() && admittedBy.isPresent()) {
            return patientService.getPatientsByDateOfBirthAndAdmittedBy(dateOfBirth.get(), admittedBy.get());
        } else if (dateOfBirth.isPresent()) {
            return patientService.getPatientsByDateOfBirth(dateOfBirth.get());
        } else if (admittedBy.isPresent()) {
            return patientService.getPatientsByAdmittedBy(admittedBy.get());
        } else {
            return patientService.getAllPatients();
        }
    }

}
