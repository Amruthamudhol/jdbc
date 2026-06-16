package com.xworkz.job.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobPortalDTO {
    private String candidateName;
    private String skill;
    private String companyName;
    private double expectedSalary;
}
