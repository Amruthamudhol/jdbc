package com.xworkz.movie.dao;

import com.xworkz.movie.dto.MovieDetailsDTO;

public interface MovieDetailsDAO {

    boolean save(MovieDetailsDTO movieDetailsDTO);
    boolean update(MovieDetailsDTO movieDetailsDTO);
    boolean delete(MovieDetailsDTO movieDetailsDTO);

    int deleteByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);
    int saveByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);
    int updateByExecuteUpdate(MovieDetailsDTO movieDetailsDTO);
}
