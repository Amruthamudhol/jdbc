package com.xworkz.taxi.dao;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.sql.*;

public class TaxiDAOImpl implements TaxiDetailsDAO {

    @Override
    public boolean save(TaxiDetailsDTO taxiDetails) {
        System.out.println("Saving taxi details : " + taxiDetails);
        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");

            String insertQuery = "insert into taxi_details(driver_name, car_model, license_plate, fare_per_km) values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, taxiDetails.getDriverName());
            preparedStatement.setString(2, taxiDetails.getCarModel());
            preparedStatement.setString(3, taxiDetails.getLicensePlate());
            preparedStatement.setDouble(4, taxiDetails.getFarePerKm());

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
    public boolean update(TaxiDetailsDTO taxiDetailsDTO) {
        System.out.println("update method : " + taxiDetailsDTO);
        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");

            String updateQuery = "update taxi_details set fare_per_km=? where license_plate=?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, taxiDetailsDTO.getFarePerKm());
            preparedStatement.setString(2, taxiDetailsDTO.getLicensePlate());

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
    public boolean delete(TaxiDetailsDTO taxiDetailsDTO) {

        System.out.println("delete method : " + taxiDetailsDTO);

        boolean isDeleted = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");

            String deleteQuery = "delete from taxi_details where license_plate=?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, taxiDetailsDTO.getLicensePlate());

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
    public boolean savebyExecuteUpdate(TaxiDetailsDTO taxiDetails) {
        System.out.println("Saving taxi details : " + taxiDetails);

        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");

            String insertQuery = "INSERT INTO taxi_details " + "(driver_name, car_model, license_plate, fare_per_km) " + "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, taxiDetails.getDriverName());
            preparedStatement.setString(2, taxiDetails.getCarModel());
            preparedStatement.setString(3, taxiDetails.getLicensePlate());
            preparedStatement.setDouble(4, taxiDetails.getFarePerKm());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
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
    public boolean updateByExecuteUpdate(TaxiDetailsDTO taxiDetails) {
        System.out.println("Updating taxi details : " + taxiDetails);

        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");

            String updateQuery = "UPDATE taxi_details " + "SET driver_name = ?, car_model = ?, " + "license_plate = ?, fare_per_km = ? " + "WHERE taxi_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, taxiDetails.getDriverName());
            preparedStatement.setString(2, taxiDetails.getCarModel());
            preparedStatement.setString(3, taxiDetails.getLicensePlate());
            preparedStatement.setDouble(4, taxiDetails.getFarePerKm());
            preparedStatement.setInt(5, taxiDetails.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
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
    public int deleteByExecuteUpdate(TaxiDetailsDTO taxiDetails) {

        System.out.println("Deleting taxi details : " + taxiDetails);

        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_db", "root", "4AI22CS005");
            String deleteQuery = "DELETE FROM taxi_details WHERE taxi_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, taxiDetails.getId());
            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Deleted Successfully");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }
}