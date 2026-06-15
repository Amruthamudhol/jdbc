package com.xworkz.movie.service;

import com.xworkz.movie.dto.MovieDetailsDTO;

public interface MovieService {
    int validateAndDelete(MovieDetailsDTO dto);
    int validateAndSave(MovieDetailsDTO dto);
    int validateAndUpdate(MovieDetailsDTO dto);
}
