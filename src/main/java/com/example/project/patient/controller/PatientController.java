package com.example.project.patient.controller;

import com.example.project.files.ResponseModel;
import com.example.project.patient.entity.Patient;
import com.example.project.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.project.files.ApplicationConstants.*;

@RestController
@RequestMapping(PATIENT_API)
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping(ADD)
    public ResponseModel addPatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping(DELETE)
    public ResponseModel deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }
}
