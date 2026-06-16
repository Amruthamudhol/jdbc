package com.xworkz.movie.runner;

import com.xworkz.movie.dao.MovieDetailsDAO;
import com.xworkz.movie.dao.MovieDAOImpl;
import com.xworkz.movie.dto.MovieDetailsDTO;
import com.xworkz.movie.service.MovieService;
import com.xworkz.movie.service.MovieServiceImpl;

import java.util.List;

public class MovieRunner {

    public static void main(String[] args) {

        MovieDetailsDAO dao = new MovieDAOImpl();

        // Save
        MovieDetailsDTO saveDto = new MovieDetailsDTO();

        saveDto.setMovieName("Kantara");
        saveDto.setDirectorName("Rishab Shetty");
        saveDto.setLanguage("Kannada");
        saveDto.setTicketPrice(250.0);

        boolean saveResult = dao.save(saveDto);
        System.out.println("Save Result : " + saveResult);

        // Update Operation
        MovieDetailsDTO updateDto = new MovieDetailsDTO();
        updateDto.setMovieName("Kantara");
        updateDto.setTicketPrice(300.0);
        boolean updateResult = dao.update(updateDto);
        System.out.println("Update Result : " + updateResult);

        // Delete using executeUpdate()
        MovieDetailsDTO deleteDto = new MovieDetailsDTO();
        deleteDto.setMovieName("Kantara");
        int rowsDeleted = dao.deleteByExecuteUpdate(deleteDto);
        System.out.println("Rows Deleted : " + rowsDeleted);

       //save
        MovieService service = new MovieServiceImpl(dao);
        MovieDetailsDTO dto = new MovieDetailsDTO();
        dto.setMovieName("Leo");
        dto.setDirectorName("Lokesh Kanagaraj");
        dto.setLanguage("Tamil");
        dto.setTicketPrice(250.0);
        int rowsInserted = service.validateAndSave(dto);
        System.out.println("Rows Inserted : " + rowsInserted);

       //update

        dto.setMovieName("Leo");
        dto.setTicketPrice(300.0);
        int rowsUpdated = service.validateAndUpdate(dto);
        System.out.println("Rows Updated : " + rowsUpdated);

        List<MovieDetailsDTO> movieDetails = service.getMovieDetails();
        System.out.println("Movie Details:");

        for (MovieDetailsDTO dto4 : movieDetails) {
            System.out.println(dto4);
        }
    }
}