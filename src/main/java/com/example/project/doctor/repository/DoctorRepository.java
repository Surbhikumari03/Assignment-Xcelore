package com.example.project.doctor.repository;
import com.example.project.doctor.entity.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.project.files.ApplicationConstants.*;

import java.util.List;
@Transactional
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);

    @Modifying
    @Query(value = "UPDATE Doctor D SET D.isActive = false WHERE D.id =:id")
    void deleteDoctorById(Long id);
}