package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.HospitalDetailsDTO;

import java.util.List;

public interface HospitalDetailsDAO {

    boolean save(HospitalDetailsDTO hospitalDetailsDTO);
    boolean update(HospitalDetailsDTO hospitalDetailsDTO);
    boolean delete(HospitalDetailsDTO hospitalDetailsDTO);

    int deletebyExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);
    int saveByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);
    int updateByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);

    List<HospitalDetailsDTO> getHospitalDetails();
}
