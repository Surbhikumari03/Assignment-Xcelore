package com.example.project.doctor.entity;

import com.example.project.files.ApplicationConstants.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Doctor {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[A-Za-z .]+$", message = "Name must contain only alphabet characters")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "City is mandatory")
    @Enumerated(EnumType.STRING)
    @JsonProperty("city")
    private City city;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max=10, message = "Phone number must be at least 10 characters long")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digit")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull(message = "Speciality is mandatory")
    @JsonProperty("speciality")
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @JsonProperty("is_active")
    @Column(nullable = false)
    @Builder.Default
    private boolean isActive = true;
}
