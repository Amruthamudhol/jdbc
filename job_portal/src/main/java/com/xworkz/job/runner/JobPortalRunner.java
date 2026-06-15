package com.xworkz.job.runner;

import com.xworkz.job.dao.JobPortalDAO;
import com.xworkz.job.dao.JobPortalDAOImpl;
import com.xworkz.job.dto.JobPortalDTO;
import com.xworkz.job.service.JobPortalService;
import com.xworkz.job.service.JobPortalServiceImpl;

public class JobPortalRunner {

    public static void main(String[] args) {

        JobPortalDAO dao = new JobPortalDAOImpl();

        // Save
        JobPortalDTO saveDto = new JobPortalDTO();
        saveDto.setCandidateName("Amruta");
        saveDto.setSkill("Java Full Stack");
        saveDto.setCompanyName("Infosys");
        saveDto.setExpectedSalary(600000.0);

        boolean saveResult = dao.save(saveDto);
        System.out.println("Save Result : " + saveResult);
        System.out.println("-----");

        // Insert
        JobPortalDTO insertDto = new JobPortalDTO();
        insertDto.setCandidateName("Ananya");
        insertDto.setSkill("Python");
        insertDto.setCompanyName("TCS");
        insertDto.setExpectedSalary(500000.0);

        boolean insertResult = dao.insert(insertDto);
        System.out.println("Insert Result : " + insertResult);
        System.out.println("-----");

        // Update
        JobPortalDTO updateDto = new JobPortalDTO();
        updateDto.setCandidateName("Amruta");
        updateDto.setExpectedSalary(800000.0);

        boolean updateResult = dao.update(updateDto);
        System.out.println("Update Result : " + updateResult);
        System.out.println("-----");

        // Select
        JobPortalDTO selectedDto = dao.select("Amruta");
        System.out.println("-----");

        //delete by ExecuteUpdate
        JobPortalService service = new JobPortalServiceImpl(dao);
        JobPortalDTO deleteDto = new JobPortalDTO();
        deleteDto.setCandidateName("Ananya");
        int rowsDeleted = service.validateAndDelete(deleteDto);
        System.out.println("Rows Deleted : " + rowsDeleted);

//update by ExecuteUpdate
        updateDto.setCandidateName("Amruta");
        updateDto.setExpectedSalary(800000.0);
        int rowsUpdated = service.validateAndUpdate(updateDto);
        System.out.println("Rows Updated : " + rowsUpdated);
    }
}