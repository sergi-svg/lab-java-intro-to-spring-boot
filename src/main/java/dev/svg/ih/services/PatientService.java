package dev.svg.ih.services;

import dev.svg.ih.model.Patient;
import dev.svg.ih.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientsById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientsByDateOfBirth(String dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }

    public List<Patient> getPatientsByAdmittedBy(String admittedBy) {
        return patientRepository.findPatientsByAdmittedBy(Integer.parseInt(admittedBy));
    }

    public List<Patient> getPatientsByDateOfBirthAndAdmittedBy(String dateOfBirth, String admittedBy) {
        return patientRepository.findByDateOfBirthAndAdmittedBy(dateOfBirth, Integer.parseInt(admittedBy));
    }

}
