package com.xworkz.hospital.service;

import com.xworkz.hospital.dao.HospitalDetailsDAO;
import com.xworkz.hospital.dto.HospitalDetailsDTO;

import java.util.Objects;

public class HospitalServiceImpl implements HospitalService {

    private final HospitalDetailsDAO hospitalDetailsDAO;

    public HospitalServiceImpl(HospitalDetailsDAO hospitalDetailsDAO) {
        this.hospitalDetailsDAO = hospitalDetailsDAO;
    }

    @Override
    public int validateAndDelete(HospitalDetailsDTO dto) {

        System.out.println("validateAndDelete in HospitalServiceImpl");

        if (Objects.nonNull(this.hospitalDetailsDAO)) {
            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String patientName = dto.getPatientName();

                if (Objects.nonNull(patientName) && !patientName.trim().isEmpty() && patientName.length() >= 3) {
                    System.out.println("DTO is valid");
                    return this.hospitalDetailsDAO.deletebyExecuteUpdate(dto);
                }

                System.err.println("Patient name is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public int validateAndSave(HospitalDetailsDTO dto) {

        System.out.println("validateAndSave in HospitalServiceImpl");

        if (Objects.nonNull(this.hospitalDetailsDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String patientName = dto.getPatientName();
                String doctorName = dto.getDoctorName();
                String disease = dto.getDisease();
                double consultation = dto.getConsultation();

                if (Objects.nonNull(patientName)
                        && patientName.length() >= 3
                        && Objects.nonNull(doctorName)
                        && doctorName.length() >= 3
                        && Objects.nonNull(disease)
                        && !disease.trim().isEmpty()
                        && disease.length() >= 3
                        && consultation > 0) {

                    System.out.println("DTO is valid");

                    return this.hospitalDetailsDAO.saveByExecuteUpdate(dto);
                }

                System.err.println("DTO is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public int validateAndUpdate(HospitalDetailsDTO dto) {

        System.out.println("validateAndUpdate in HospitalServiceImpl");

        if (Objects.nonNull(this.hospitalDetailsDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String patientName = dto.getPatientName();
                double consultation = dto.getConsultation();

                if (Objects.nonNull(patientName)
                        && patientName.length() >= 3
                        && consultation > 0) {

                    System.out.println("DTO is valid");

                    return this.hospitalDetailsDAO.updateByExecuteUpdate(dto);
                }

                System.err.println("DTO is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }


}