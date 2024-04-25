package dev.svg.ih.repositories;

import dev.svg.ih.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirth(String dateOfBirth);

    List<Patient> findPatientsByAdmittedBy(int admittedBy);

    List<Patient> findByDateOfBirthAndAdmittedBy(String dateOfBirth, int doctor);

}
