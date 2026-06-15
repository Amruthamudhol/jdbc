package com.xworkz.hospital.service;

import com.xworkz.hospital.dto.HospitalDetailsDTO;

public interface HospitalService {
    int validateAndDelete(HospitalDetailsDTO hospitalDetailsDTO);
    int validateAndSave(HospitalDetailsDTO dto);
    int validateAndUpdate(HospitalDetailsDTO dto) ;
}
