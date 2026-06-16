package com.xworkz.hospital.runner;

import com.xworkz.hospital.dao.HospitalDAOImpl;
import com.xworkz.hospital.dto.HospitalDetailsDTO;
import com.xworkz.hospital.service.HospitalService;
import com.xworkz.hospital.service.HospitalServiceImpl;

import java.util.List;

public class HospitalRunner {

    public static  void main(String[] args) {

        HospitalDAOImpl dao = new HospitalDAOImpl();

        // Save Operation
        HospitalDetailsDTO saveDto = new HospitalDetailsDTO();
        saveDto.setPatientName("Ramesh");
        saveDto.setDoctorName("Dr. Priya");
        saveDto.setDisease("Fever");
        saveDto.setConsultation(500.0);

        boolean saveResult = dao.save(saveDto);
        System.out.println("Save Result : " + saveResult);

        // Update Operation
        HospitalDetailsDTO updateDto = new HospitalDetailsDTO();
        updateDto.setPatientName("Ramesh");
        updateDto.setConsultation(700.0);

        boolean updateResult = dao.update(updateDto);
        System.out.println("Update Result : " + updateResult);

        // Delete Operation using executeUpdate()
        HospitalDetailsDTO deleteDto = new HospitalDetailsDTO();
        deleteDto.setPatientName("Ramesh");
        int rowsDeleted = dao.deletebyExecuteUpdate(deleteDto);



        // insert Operation using executeUpdate()
        HospitalService service = new HospitalServiceImpl(dao);
        HospitalDetailsDTO dto = new HospitalDetailsDTO();
        dto.setPatientName("Ramesh");
        dto.setDoctorName("Dr. Priya");
        dto.setDisease("Fever");
        dto.setConsultation(500.0);
        int rowsInserted = service.validateAndSave(dto);

        //delete
        HospitalDetailsDTO updatesDto = new HospitalDetailsDTO();
        updatesDto.setPatientName("Ramesh");
        updatesDto.setConsultation(700.0);
        int rowsUpdated = service.validateAndUpdate(updateDto);
        System.out.println("Rows Updated : " + rowsUpdated);

        List<HospitalDetailsDTO> hospitalDetails = service.getHospitalDetails();
        System.out.println("Hospital Details:");

        for (HospitalDetailsDTO dto4 : hospitalDetails) {
            System.out.println(dto4);
        }

    }
}