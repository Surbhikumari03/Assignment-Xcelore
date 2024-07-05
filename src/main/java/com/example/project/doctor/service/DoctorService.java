package com.example.project.doctor.service;

import com.example.project.doctor.entity.Doctor;
import com.example.project.files.ResponseModel;

public interface DoctorService {

    public ResponseModel addDoctor(Doctor doctor);

    public ResponseModel deleteDoctor(Long id);

    public ResponseModel suggestDoctors(Long patientId);

}
