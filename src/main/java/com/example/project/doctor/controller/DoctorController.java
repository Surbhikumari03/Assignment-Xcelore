package com.example.project.doctor.controller;

import com.example.project.doctor.entity.Doctor;
import com.example.project.doctor.service.DoctorService;
import com.example.project.files.ResponseModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.project.files.ApplicationConstants.*;

@RestController
@RequestMapping(DOCTOR_API)
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(ADD)
    public ResponseModel addDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping(DELETE)
    public ResponseModel deleteDoctor(@PathVariable Long id) {
        return doctorService.deleteDoctor(id);
    }

    @GetMapping(SUGGEST)
    public ResponseEntity<ResponseModel> suggestDoctors(@RequestParam Long patientId) {
        ResponseModel response = doctorService.suggestDoctors(patientId);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
