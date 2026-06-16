package com.xworkz.job.dao;

import com.xworkz.job.dto.JobPortalDTO;

import java.util.List;

public interface JobPortalDAO {
    boolean save(JobPortalDTO jobPortalDTO);
    boolean update(JobPortalDTO jobPortalDTO);
    boolean delete(JobPortalDTO jobPortalDTO);

    boolean insert(JobPortalDTO jobPortalDTO);
    JobPortalDTO select(String candidateName);
    int deleteByExecuteUpdate(JobPortalDTO jobPortalDTO);
    int updateByExecuteUpdate(JobPortalDTO jobPortalDTO);

    List<JobPortalDTO> getJobPortalDetails();

}
