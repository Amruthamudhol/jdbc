package com.xworkz.taxi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TaxiDetailsDTO {
    private int Id;
    private String DriverName;
    private String CarModel;
    private String LicensePlate;
    private Double FarePerKm;
}
