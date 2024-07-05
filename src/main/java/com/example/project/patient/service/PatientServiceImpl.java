package com.example.project.patient.service;

import com.example.project.files.ResponseModel;
import com.example.project.patient.entity.Patient;
import com.example.project.patient.repository.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.project.files.ApplicationConstants.*;

@Transactional
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public ResponseModel addPatient(@Valid Patient patient) {
        if (patient != null) {
            Patient savedPatient = patientRepository.save(patient);
            return ResponseModel.builder()
                    .status(HttpStatus.OK)
                    .currentServerTime(LocalDateTime.now())
                    .response(savedPatient)
                    .messageCode(PATIENT_ADD_MESSAGE)
                    .build();
        }
        return ResponseModel.builder()
                .status(HttpStatus.BAD_REQUEST)
                .currentServerTime(LocalDateTime.now())
                .messageCode(PATIENT_NOT_ADDED)
                .build();
    }

    @Override
    public ResponseModel deletePatient(Long id) {
        if (patientRepository.findById(id).isPresent() && patientRepository.findById(id).get().isActive()) {
            patientRepository.deletePatientById(id);
            return ResponseModel.builder()
                    .status(HttpStatus.OK)
                    .currentServerTime(LocalDateTime.now())
                    .messageCode(PATIENT_DELETE_MESSAGE)
                    .build();
        } else {
            return ResponseModel.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .currentServerTime(LocalDateTime.now())
                    .messageCode(PATIENT_NOT_FOUND_MESSAGE)
                    .build();
        }
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
}
