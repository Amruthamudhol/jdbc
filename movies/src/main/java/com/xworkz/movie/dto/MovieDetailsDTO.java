package com.xworkz.movie.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieDetailsDTO {

    private String movieName;
    private String directorName;
    private String language;
    private double ticketPrice;
}
