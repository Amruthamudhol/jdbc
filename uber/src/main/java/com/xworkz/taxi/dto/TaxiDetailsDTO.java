package com.xworkz.taxi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TaxiDetailsDTO {
    private int Id;
    private String DriverName;
    private String CarModel;
    private String LicensePlate;
    private Double FarePerKm;



}
