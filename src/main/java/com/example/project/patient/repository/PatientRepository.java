package com.example.project.patient.repository;

import com.example.project.patient.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findById(Long id);

    @Modifying
    @Query(value = "UPDATE Patient P SET P.isActive = false WHERE P.id =:id")
    void deletePatientById(Long id);
}
