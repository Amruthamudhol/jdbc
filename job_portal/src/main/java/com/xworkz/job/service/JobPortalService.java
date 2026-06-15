package com.xworkz.job.service;

import com.xworkz.job.dto.JobPortalDTO;

public interface JobPortalService {
    int validateAndDelete(JobPortalDTO jobPortalDTO);
    int validateAndUpdate(JobPortalDTO dto);

}
