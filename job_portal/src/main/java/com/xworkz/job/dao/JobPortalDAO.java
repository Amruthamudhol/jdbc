package com.xworkz.job.dao;

import com.xworkz.job.dto.JobPortalDTO;

public interface JobPortalDAO {
    boolean save(JobPortalDTO jobPortalDTO);
    boolean update(JobPortalDTO jobPortalDTO);
    boolean delete(JobPortalDTO jobPortalDTO);

    boolean insert(JobPortalDTO jobPortalDTO);
    JobPortalDTO select(String candidateName);
    int deleteByExecuteUpdate(JobPortalDTO jobPortalDTO);
    int updateByExecuteUpdate(JobPortalDTO jobPortalDTO);

}
