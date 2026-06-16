package com.xworkz.movie.dao;

import com.xworkz.movie.dto.MovieDetailsDTO;

import java.util.List;

public interface MovieDetailsDAO {

    boolean save(MovieDetailsDTO movieDetailsDTO);
    boolean update(MovieDetailsDTO movieDetailsDTO);
    boolean delete(MovieDetailsDTO movieDetailsDTO);

    int deleteByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);
    int saveByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);
    int updateByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);

    List<MovieDetailsDTO> getMovieDetails();
}
