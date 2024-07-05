package com.example.project.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationConstants {
    public static final String DOCTOR_API = "/doctor";
    public static final String PATIENT_API = "/patient";
    public static final String ADD = "/add";
    public static final String DELETE = "/delete/{id}";
    public static final String SUGGEST = "/suggest";
    public static final String DOCTOR_DELETE_MESSAGE = "Doctor deleted successfully";
    public static final String DOCTOR_NOT_FOUND_MESSAGE = "Doctor not found with given id or maybe inactive";
    public static final String DOCTOR_FOUND_MESSAGE = "Doctor founded successfully";
    public static final String UNKNOWN_SYMPTOM = "Unknown Symptons : ";
    public static final String PATIENT_DELETE_MESSAGE = "Patient deleted successfully";
    public static final String PATIENT_NOT_FOUND_MESSAGE = "Patient not found with given id or maybe inactive";
    public static final String DOCTOR_ADD_MESSAGE = "Doctor added successfully";
    public static final String DOCTOR_NOT_ADDED = "Doctor can't be added Please Try Again";
    public static final String PATIENT_NOT_ADDED = "Patient can't be added Please Try Again";
    public static final String PATIENT_ADD_MESSAGE = "Patient added successfully";
    public static final String EXPANSION_MESSAGE = "We are still waiting to expand to your location";
    public static final String DOCTOR_UNAVAILABILITY = "There isn’t any doctor present at your location for your symptom";
    public enum City {
        @JsonProperty("Delhi")
        DELHI,
        @JsonProperty("Noida")
        NOIDA,
        @JsonProperty("Faridabad")
        FARIDABAD
    }
    public enum Speciality {
        @JsonProperty("Orthopaedic")
        ORTHOPAEDIC,
        @JsonProperty("Gynecology")
        GYNECOLOGY,
        @JsonProperty("Dermatology")
        DERMATOLOGY,
        @JsonProperty("Ent")
        ENT
    }
    public enum Symptom {
        @JsonProperty("Arthritis")
        ARTHRITIS,
        @JsonProperty("Back_pain")
        BACK_PAIN,
        @JsonProperty("Tissue_injuries")
        TISSUE_INJURIES,
        @JsonProperty("Dysmenorrhea")
        DYSMENORRHEA,
        @JsonProperty("Skin_infection")
        SKIN_INFECTION,
        @JsonProperty("Skin_burn")
        SKIN_BURN,
        @JsonProperty("Ear_pain")
        EAR_PAIN
    }
}
