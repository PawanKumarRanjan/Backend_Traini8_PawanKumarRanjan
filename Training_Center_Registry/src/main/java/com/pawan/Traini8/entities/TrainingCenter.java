package com.pawan.Traini8.entities;


import java.time.Instant;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String centerName;

    @NotBlank
    @Size(min = 12, max = 12)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String centerCode;

    @Embedded
    private Address address;

    @Positive
    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Instant createdOn;

    @Email(message = "Contact email must be a valid email address")
    @Pattern(regexp = "^(|.*@.*)$", message = "Contact email must be a valid email address")
    private String contactEmail;

    @Pattern(regexp = "\\d{10}", message = "Contact phone must be a valid phone number")
    private String contactPhone;

}