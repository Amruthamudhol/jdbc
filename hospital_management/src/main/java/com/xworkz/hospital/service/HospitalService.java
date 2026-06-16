package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.HospitalDetailsDTO;

import java.util.List;

public interface HospitalService {
    int validateAndDelete(HospitalDetailsDTO hospitalDetailsDTO);
    int validateAndSave(HospitalDetailsDTO dto);
    int validateAndUpdate(HospitalDetailsDTO dto) ;

    List<HospitalDetailsDTO> getHospitalDetails();
}
