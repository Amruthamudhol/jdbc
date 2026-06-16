package com.xworkz.taxi.dao;

import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.util.List;

public interface TaxiDetailsDAO {
    boolean save(TaxiDetailsDTO taxiDetailsDTO);

    boolean update(TaxiDetailsDTO taxiDetailsDTO);

    boolean delete(TaxiDetailsDTO taxiDetailsDTO);

    boolean savebyExecuteUpdate(TaxiDetailsDTO taxiDetails);
    boolean updateByExecuteUpdate(TaxiDetailsDTO taxiDetails);
    int deleteByExecuteUpdate(TaxiDetailsDTO taxiDetails);

    List<TaxiDetailsDTO> getTaxiDetails();
}
