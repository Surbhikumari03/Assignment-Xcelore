package com.example.project.doctor.service;

import com.example.project.doctor.entity.Doctor;
import com.example.project.doctor.repository.DoctorRepository;
import com.example.project.files.ResponseModel;
import com.example.project.patient.entity.Patient;
import com.example.project.patient.service.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.project.files.ApplicationConstants.*;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientService patientService;

    @Override
    public ResponseModel addDoctor(@Valid Doctor doctor) {
        if (doctor != null) {
            Doctor savedDoctor = doctorRepository.save(doctor);
            return ResponseModel.builder().status(HttpStatus.OK).currentServerTime(LocalDateTime.now()).response(savedDoctor).messageCode(DOCTOR_ADD_MESSAGE).build();
        }
        return ResponseModel.builder().status(HttpStatus.BAD_REQUEST).currentServerTime(LocalDateTime.now()).messageCode(DOCTOR_NOT_ADDED).build();
    }

    @Override
    public ResponseModel deleteDoctor(Long id) {
        if (doctorRepository.findById(id).isPresent() && doctorRepository.findById(id).get().isActive()){
            doctorRepository.deleteDoctorById(id);
            return ResponseModel.builder().status(HttpStatus.OK).currentServerTime(LocalDateTime.now()).messageCode(DOCTOR_DELETE_MESSAGE).build();
        } else {
            return ResponseModel.builder().status(HttpStatus.NOT_FOUND).currentServerTime(LocalDateTime.now()).messageCode(DOCTOR_NOT_FOUND_MESSAGE).build();
        }

    }

    @Override
    public ResponseModel suggestDoctors(Long patientId) {
        Optional<Patient> patientOpt = patientService.getPatientById(patientId);

        if (!patientOpt.isPresent()) {
            return ResponseModel.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .currentServerTime(LocalDateTime.now())
                    .messageCode(PATIENT_NOT_FOUND_MESSAGE)
                    .build();
        }

        Patient patient = patientOpt.get();
        String city = patient.getCity();
        Symptom symptom = patient.getSymptom();

        City doctorCity;
        try {
            doctorCity = City.valueOf(city.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseModel.builder()
                    .status(HttpStatus.OK)
                    .currentServerTime(LocalDateTime.now())
                    .messageCode(EXPANSION_MESSAGE)
                    .build();
        }

        Speciality speciality = getSpecialtyBySymptom(symptom);

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(doctorCity, speciality);

        if (doctors.isEmpty()) {
            return ResponseModel.builder()
                    .status(HttpStatus.OK)
                    .currentServerTime(LocalDateTime.now())
                    .messageCode(DOCTOR_UNAVAILABILITY)
                    .build();
        }

        return ResponseModel.builder()
                .status(HttpStatus.OK)
                .currentServerTime(LocalDateTime.now())
                .response(doctors)
                .messageCode(DOCTOR_FOUND_MESSAGE)
                .build();
    }

    private Speciality getSpecialtyBySymptom(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT;
            default:
                throw new IllegalArgumentException(UNKNOWN_SYMPTOM + symptom);
        }
    }
}
