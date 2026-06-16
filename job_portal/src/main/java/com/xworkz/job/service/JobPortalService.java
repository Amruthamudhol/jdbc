package com.xworkz.job.service;

import com.xworkz.job.dto.JobPortalDTO;

import java.util.List;

public interface JobPortalService {
    int validateAndDelete(JobPortalDTO jobPortalDTO);
    int validateAndUpdate(JobPortalDTO dto);

    List<JobPortalDTO> getJobPortalDetails();

}
