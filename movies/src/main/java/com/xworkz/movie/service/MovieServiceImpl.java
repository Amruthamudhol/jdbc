package com.xworkz.movie.service;

import com.xworkz.movie.dao.MovieDetailsDAO;
import com.xworkz.movie.dto.MovieDetailsDTO;

import java.util.List;
import java.util.Objects;

public class MovieServiceImpl implements MovieService {

    private MovieDetailsDAO movieDetailsDAO;
    public MovieServiceImpl(MovieDetailsDAO movieDetailsDAO) {
        this.movieDetailsDAO = movieDetailsDAO;
    }

    @Override
    public int validateAndDelete(MovieDetailsDTO dto) {

        System.out.println("validateAndDelete in MovieServiceImpl");
        if (Objects.nonNull(this.movieDetailsDAO)) {
            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String movieName = dto.getMovieName();
                if (Objects.nonNull(movieName) && movieName.length() >= 3) {
                    System.out.println("DTO is valid");
                    return this.movieDetailsDAO.deleteByExecuteUpdate(dto);
                }

                System.err.println("Movie name is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public int validateAndSave(MovieDetailsDTO dto) {

        System.out.println("validateAndSave in MovieServiceImpl");
        if (Objects.nonNull(this.movieDetailsDAO)) {
            System.out.println("DAO is not null");
            if (Objects.nonNull(dto)) {

                String movieName = dto.getMovieName();
                String directorName = dto.getDirectorName();
                String language = dto.getLanguage();
                double ticketPrice = dto.getTicketPrice();

                if (Objects.nonNull(movieName)
                        && movieName.length() >= 3
                        && Objects.nonNull(directorName)
                        && directorName.length() >= 3
                        && Objects.nonNull(language)
                        && language.length() >= 2
                        && ticketPrice > 0) {

                    System.out.println("DTO is valid");
                    return this.movieDetailsDAO.saveByExecuteUpdate(dto);
                }

                System.err.println("DTO is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public int validateAndUpdate(MovieDetailsDTO dto) {
        System.out.println("validateAndUpdate in MovieServiceImpl");
        if (Objects.nonNull(this.movieDetailsDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String movieName = dto.getMovieName();
                double ticketPrice = dto.getTicketPrice();

                if (Objects.nonNull(movieName) && movieName.length() >= 3 && ticketPrice > 0) {
                    System.out.println("DTO is valid");
                    return this.movieDetailsDAO.updateByExecuteUpdate(dto);
                }

                System.err.println("DTO is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return 0;
    }

    @Override
    public List<MovieDetailsDTO> getMovieDetails() {
        return movieDetailsDAO.getMovieDetails();
    }
}