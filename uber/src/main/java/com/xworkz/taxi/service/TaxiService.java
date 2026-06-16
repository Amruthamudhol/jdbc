package com.xworkz.taxi.service;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.util.List;

public interface TaxiService {
    boolean validateAndSave(TaxiDetailsDTO taxiDetails);
    boolean validateAndUpdate(TaxiDetailsDTO dto);
    int validateAndDelete(TaxiDetailsDTO dto);

    List<TaxiDetailsDTO> getTaxiDetails();

}
