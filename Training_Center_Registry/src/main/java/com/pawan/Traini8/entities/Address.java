package com.pawan.Traini8.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
    
}