package com.xworkz.movie.dao;

import com.xworkz.movie.dto.MovieDetailsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDetailsDAO {

    @Override
    public boolean save(MovieDetailsDTO movieDetailsDTO) {
        System.out.println("Saving movie details : " + movieDetailsDTO);

        boolean isSaved = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");
            String insertQuery = "insert into movie_details(movie_name,director_name,language,ticket_price) values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, movieDetailsDTO.getMovieName());
            preparedStatement.setString(2, movieDetailsDTO.getDirectorName());
            preparedStatement.setString(3, movieDetailsDTO.getLanguage());
            preparedStatement.setDouble(4, movieDetailsDTO.getTicketPrice());

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
    public boolean update(MovieDetailsDTO movieDetailsDTO) {
        System.out.println("Update method : " + movieDetailsDTO);
        boolean isUpdated = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");

            String updateQuery = "update movie_details set ticket_price=? where movie_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, movieDetailsDTO.getTicketPrice());
            preparedStatement.setString(2, movieDetailsDTO.getMovieName());

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
    public boolean delete(MovieDetailsDTO movieDetailsDTO) {
        System.out.println("Delete method : " + movieDetailsDTO);
        boolean isDeleted = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");

            String deleteQuery = "delete from movie_details where movie_name=?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, movieDetailsDTO.getMovieName());

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
    public int deleteByExecuteUpdate(MovieDetailsDTO movieDetailsDTO) {

        System.out.println("Delete Method : " + movieDetailsDTO);

        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");

            String deleteQuery = "DELETE FROM movie_details WHERE movie_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, movieDetailsDTO.getMovieName());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data Deleted Successfully");
            } else {
                System.out.println("Movie not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public int saveByExecuteUpdate(MovieDetailsDTO movieDetailsDTO) {
        System.out.println("Save Method : " + movieDetailsDTO);
        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");
            String insertQuery = "INSERT INTO movie_details " + "(movie_name, director_name, language, ticket_price) " + "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, movieDetailsDTO.getMovieName());
            preparedStatement.setString(2, movieDetailsDTO.getDirectorName());
            preparedStatement.setString(3, movieDetailsDTO.getLanguage());
            preparedStatement.setDouble(4, movieDetailsDTO.getTicketPrice());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Insertion failed");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public int updateByExecuteUpdate(MovieDetailsDTO movieDetailsDTO) {

        System.out.println("Update Method : " + movieDetailsDTO);
        int rowsAffected = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");

            String updateQuery = "UPDATE movie_details SET ticket_price = ? WHERE movie_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setDouble(1, movieDetailsDTO.getTicketPrice());
            preparedStatement.setString(2, movieDetailsDTO.getMovieName());

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("Movie not found");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }


    @Override
    public List<MovieDetailsDTO> getMovieDetails() {

        System.out.println("Invoking getMovieDetails");

        List<MovieDetailsDTO> movieDetailsDTOList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "4AI22CS005");
            String query = "SELECT * FROM movie_details";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                MovieDetailsDTO dto = new MovieDetailsDTO();

                dto.setMovieName(resultSet.getString("movie_name"));
                dto.setDirectorName(resultSet.getString("director_name"));
                dto.setLanguage(resultSet.getString("language"));
                dto.setTicketPrice(resultSet.getDouble("ticket_price"));

                movieDetailsDTOList.add(dto);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return movieDetailsDTOList;
    }
}