package com.xworkz.taxi.service;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

public interface TaxiService {
    boolean validateAndSave(TaxiDetailsDTO taxiDetails);
    boolean validateAndUpdate(TaxiDetailsDTO dto);
    int validateAndDelete(TaxiDetailsDTO dto);

}
