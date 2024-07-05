package com.example.project.patient.entity;

import com.example.project.files.ApplicationConstants.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Pattern(regexp = "^[A-Za-z .]+$", message = "Name must contain only alphabet characters")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must be at most 20 characters long")
    @JsonProperty("city")
    private String city;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max=10, message = "Phone number must be at least 10 characters long")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digit")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull(message = "Symptom is mandatory")
    @JsonProperty("symptom")
    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    @JsonProperty("is_active")
    @Column(nullable = false)
    @Builder.Default
    private boolean isActive = true;
}
