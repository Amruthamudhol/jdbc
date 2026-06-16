package com.xworkz.hospital.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HospitalDetailsDTO {
    private String patientName;
    private String doctorName;
    private String disease;
    private double consultation;
}
