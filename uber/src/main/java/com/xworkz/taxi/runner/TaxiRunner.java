package com.xworkz.taxi.runner;

import com.xworkz.taxi.dao.TaxiDAOImpl;
import com.xworkz.taxi.dao.TaxiDetailsDAO;
import com.xworkz.taxi.dto.TaxiDetailsDTO;
import com.xworkz.taxi.service.TaxiService;
import com.xworkz.taxi.service.TaxiServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class TaxiRunner {
    public static void main(String[] args) {


        TaxiDetailsDAO dao2 = new TaxiDAOImpl();
        List<TaxiDetailsDTO> taxiDetailsDTOList = new ArrayList<>();

        TaxiDetailsDTO taxi1 = new TaxiDetailsDTO();

        taxi1.setDriverName("Akshata");
        taxi1.setCarModel("Audi");
        taxi1.setLicensePlate("KA-18-AK-2012");
        taxi1.setFarePerKm(300.0);

        TaxiDetailsDTO taxi2 = new TaxiDetailsDTO();

        taxi2.setDriverName("Savita");
        taxi2.setCarModel("Nano");
        taxi2.setLicensePlate("KA-28-AK-2015");
        taxi2.setFarePerKm(30.0);

        taxiDetailsDTOList.add(taxi1);
        taxiDetailsDTOList.add(taxi2);

        dao2.insertMultipleDto(taxiDetailsDTOList);
    }
}
