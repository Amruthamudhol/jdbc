package com.xworkz.job.service;

import com.xworkz.job.dao.JobPortalDAO;
import com.xworkz.job.dto.JobPortalDTO;

import java.util.Objects;

public class JobPortalServiceImpl implements JobPortalService{
    private JobPortalDAO jobPortalDAO;

    public JobPortalServiceImpl(JobPortalDAO jobPortalDAO) {
        this.jobPortalDAO = jobPortalDAO;
    }

    @Override
    public int validateAndDelete(JobPortalDTO dto) {
        System.out.println("validateAndDelete in JobPortalServiceImpl");

        if (Objects.nonNull(this.jobPortalDAO)) {
            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {
                String candidateName = dto.getCandidateName();
                if (Objects.nonNull(candidateName) && !candidateName.trim().isEmpty() && candidateName.length() >= 3) {
                    System.out.println("DTO is valid");
                    return this.jobPortalDAO.deleteByExecuteUpdate(dto);
                }

                System.err.println("Candidate name is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public int validateAndUpdate(JobPortalDTO dto) {

        System.out.println("validateAndUpdate in JobPortalServiceImpl");

        if (Objects.nonNull(this.jobPortalDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String candidateName = dto.getCandidateName();
                double expectedSalary = dto.getExpectedSalary();

                if (Objects.nonNull(candidateName) && !candidateName.trim().isEmpty() && candidateName.length() >= 3 && expectedSalary > 0) {
                    System.out.println("DTO is valid");
                    return this.jobPortalDAO.updateByExecuteUpdate(dto);
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
