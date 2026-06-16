package com.xworkz.movie.service;

import com.xworkz.movie.dto.MovieDetailsDTO;

import java.util.List;

public interface MovieService {
    int validateAndDelete(MovieDetailsDTO dto);
    int validateAndSave(MovieDetailsDTO dto);
    int validateAndUpdate(MovieDetailsDTO dto);

    List<MovieDetailsDTO> getMovieDetails();
}
