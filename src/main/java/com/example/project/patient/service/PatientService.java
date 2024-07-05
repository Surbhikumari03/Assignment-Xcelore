package com.example.project.patient.service;

import com.example.project.files.ResponseModel;
import com.example.project.patient.entity.Patient;

import java.util.Optional;

public interface PatientService {

        public ResponseModel addPatient(Patient patient);

        public ResponseModel deletePatient(Long id);

        public Optional<Patient> getPatientById(Long id);
}
