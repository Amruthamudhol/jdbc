package com.xworkz.hospital.dao;

import com.xworkz.hospital.dto.HospitalDetailsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAOImpl implements HospitalDetailsDAO {

    @Override
    public boolean save(HospitalDetailsDTO hospitalDetailsDTO) {
        System.out.println("Saving hospital details : " + hospitalDetailsDTO);
        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String insertQuery = "insert into hospital_detail(patient_name,doctor_name,disease,consultation) values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, hospitalDetailsDTO.getPatientName());
            preparedStatement.setString(2, hospitalDetailsDTO.getDoctorName());
            preparedStatement.setString(3, hospitalDetailsDTO.getDisease());
            preparedStatement.setDouble(4, hospitalDetailsDTO.getConsultation());

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
    public boolean update(HospitalDetailsDTO hospitalDetailsDTO) {

        System.out.println("Update method : " + hospitalDetailsDTO);

        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String updateQuery = "update hospital_detail set consultation_fee=? where patient_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, hospitalDetailsDTO.getConsultation());
            preparedStatement.setString(2, hospitalDetailsDTO.getPatientName());

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
    public boolean delete(HospitalDetailsDTO hospitalDetailsDTO) {

        System.out.println("Delete method : " + hospitalDetailsDTO);

        boolean isDeleted = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String deleteQuery = "delete from hospital_detail where patient_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, hospitalDetailsDTO.getPatientName());

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

    public int deletebyExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO) {

        System.out.println("Delete method : " + hospitalDetailsDTO);

        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String deleteQuery = "DELETE FROM hospital_detail WHERE patient_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, hospitalDetailsDTO.getPatientName());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    public int saveByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO) {

        System.out.println("Save method : " + hospitalDetailsDTO);
        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String insertQuery = "INSERT INTO hospital_detail " + "(patient_name, doctor_name, disease, consultation) " + "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, hospitalDetailsDTO.getPatientName());
            preparedStatement.setString(2, hospitalDetailsDTO.getDoctorName());
            preparedStatement.setString(3, hospitalDetailsDTO.getDisease());
            preparedStatement.setDouble(4, hospitalDetailsDTO.getConsultation());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public int updateByExecuteUpdate(HospitalDetailsDTO hospitalDetailsDTO) {

        System.out.println("Update method : " + hospitalDetailsDTO);

        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String updateQuery = "UPDATE hospital_detail SET consultation = ? WHERE patient_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, hospitalDetailsDTO.getConsultation());
            preparedStatement.setString(2, hospitalDetailsDTO.getPatientName());

            rowsAffected = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public List<HospitalDetailsDTO> getHospitalDetails() {

        System.out.println("Invoking getHospitalDetails");

        List<HospitalDetailsDTO> hospitalDetailsDTOList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "4AI22CS005");

            String query = "SELECT * FROM hospital_detail";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                HospitalDetailsDTO dto = new HospitalDetailsDTO();

                dto.setPatientName(resultSet.getString("patient_name"));
                dto.setDoctorName(resultSet.getString("doctor_name"));
                dto.setDisease(resultSet.getString("disease"));
                dto.setConsultation(resultSet.getDouble("consultation"));
                hospitalDetailsDTOList.add(dto);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return hospitalDetailsDTOList;
    }
}