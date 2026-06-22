package com.xworkz.software.dao;

import com.xworkz.software.dto.SoftwareDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SoftwareDAOImpl  implements SoftwareDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/software_details_db";
    private static final String USER = "root";
    private static final String PASSWORD = "4AI22CS005";

    private static final String INSERT_QUERY = "INSERT INTO software_table  " +
                    "(software, current_version, developed_year, developed_by, open_source) " + "VALUES (?, ?, ?, ?, ?)";

    @Override
    public boolean save(SoftwareDTO dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/software_details_db", "root", "4AI22CS005");
                 PreparedStatement ps = connection.prepareStatement(INSERT_QUERY))
            {
                ps.setString(1, dto.getSoftware());
                ps.setString(2, dto.getCurrentVersion());
                ps.setInt(3, dto.getDevelopedYear());
                ps.setString(4, dto.getDevelopedBy());
                ps.setString(5, dto.getOpenSource());

                return ps.executeUpdate() > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}


