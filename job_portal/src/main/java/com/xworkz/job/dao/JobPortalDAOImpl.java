package com.xworkz.job.dao;

import com.xworkz.job.dto.JobPortalDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobPortalDAOImpl  implements JobPortalDAO{
    @Override
    public boolean save(JobPortalDTO jobPortalDTO) {
        System.out.println("Saving Candidate Details : " + jobPortalDTO);

        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String insertQuery = "insert into candidate_details(candidate_name,skill,company_name,expected_salary) values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, jobPortalDTO.getCandidateName());
            preparedStatement.setString(2, jobPortalDTO.getSkill());
            preparedStatement.setString(3, jobPortalDTO.getCompanyName());
            preparedStatement.setDouble(4, jobPortalDTO.getExpectedSalary());

            boolean result = preparedStatement.execute();

            if (!result) {
                isSaved = true;
                System.out.println("Data Saved Successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

    @Override
    public boolean update(JobPortalDTO jobPortalDTO) {

        System.out.println("Update Method : " + jobPortalDTO);

        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String updateQuery = "update candidate_details set expected_salary=? where candidate_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, jobPortalDTO.getExpectedSalary());
            preparedStatement.setString(2, jobPortalDTO.getCandidateName());

            boolean result = preparedStatement.execute();

            if (!result) {
                isUpdated = true;
                System.out.println("Data Updated Successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(JobPortalDTO jobPortalDTO) {

        System.out.println("Delete Method : " + jobPortalDTO);

        boolean isDeleted = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String deleteQuery = "delete from candidate_details where candidate_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, jobPortalDTO.getCandidateName());

            boolean result = preparedStatement.execute();

            if (!result) {
                isDeleted = true;
                System.out.println("Data Deleted Successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    @Override
    public int deleteByExecuteUpdate(JobPortalDTO jobPortalDTO) {

        System.out.println("Delete Method : " + jobPortalDTO);
        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String deleteQuery = "DELETE FROM candidate_details WHERE candidate_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, jobPortalDTO.getCandidateName());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Deleted Successfully");
            } else {
                System.out.println("Candidate not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public boolean insert(JobPortalDTO jobPortalDTO) {

        System.out.println("Saving Candidate Details : " + jobPortalDTO);
        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");
            String insertQuery = "insert into candidate_details(candidate_name, skill, company_name, expected_salary) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, jobPortalDTO.getCandidateName());
            preparedStatement.setString(2, jobPortalDTO.getSkill());
            preparedStatement.setString(3, jobPortalDTO.getCompanyName());
            preparedStatement.setDouble(4, jobPortalDTO.getExpectedSalary());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                isSaved = true;
                System.out.println(" Saved Successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }
    @Override
    public JobPortalDTO select(String candidateName) {
        System.out.println("Searching Candidate : " + candidateName);
        JobPortalDTO jobPortalDTO = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String selectQuery = "select * from candidate_details where candidate_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, candidateName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                jobPortalDTO = new JobPortalDTO();
                jobPortalDTO.setCandidateName(resultSet.getString("candidate_name"));
                jobPortalDTO.setSkill(resultSet.getString("skill"));
                jobPortalDTO.setCompanyName(resultSet.getString("company_name"));
                jobPortalDTO.setExpectedSalary(resultSet.getDouble("expected_salary"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return jobPortalDTO;
    }
    @Override
    public int updateByExecuteUpdate(JobPortalDTO jobPortalDTO) {

        System.out.println("Update Method : " + jobPortalDTO);

        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");

            String updateQuery = "UPDATE candidate_details SET expected_salary = ? WHERE candidate_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, jobPortalDTO.getExpectedSalary());
            preparedStatement.setString(2, jobPortalDTO.getCandidateName());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Updated Successfully");
            } else {
                System.out.println("Candidate not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public List<JobPortalDTO> getJobPortalDetails() {
        System.out.println("Invoking getJobPortalDetails");
        List<JobPortalDTO> jobPortalDTOList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "4AI22CS005");
            String query = "SELECT * FROM candidate_details";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                JobPortalDTO dto = new JobPortalDTO();

                dto.setCandidateName(resultSet.getString("candidate_name"));
                dto.setSkill(resultSet.getString("skill"));
                dto.setCompanyName(resultSet.getString("company_name"));
                dto.setExpectedSalary(resultSet.getDouble("expected_salary"));

                jobPortalDTOList.add(dto);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return jobPortalDTOList;
    }

}
