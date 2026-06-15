package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.HospitalDetailsDTO;

public interface HospitalDetailsDAO {

    boolean save(HospitalDetailsDTO hospitalDetailsDTO);
    boolean update(HospitalDetailsDTO hospitalDetailsDTO);
    boolean delete(HospitalDetailsDTO hospitalDetailsDTO);

    int deletebyExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);
    int saveByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);
    int updateByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO);
}
