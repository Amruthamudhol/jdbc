package com.xworkz.taxi.dao;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

public interface TaxiDetailsDAO {
    boolean save(TaxiDetailsDTO taxiDetailsDTO);

    boolean update(TaxiDetailsDTO taxiDetailsDTO);

    boolean delete(TaxiDetailsDTO taxiDetailsDTO);

    boolean savebyExecuteUpdate(TaxiDetailsDTO taxiDetails);
}
