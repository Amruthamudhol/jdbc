package com.xworkz.taxi.runner;

import com.xworkz.taxi.dao.TaxiDAOImpl;
import com.xworkz.taxi.dao.TaxiDetailsDAO;
import com.xworkz.taxi.dto.TaxiDetailsDTO;
import com.xworkz.taxi.service.TaxiService;
import com.xworkz.taxi.service.TaxiServiceImpl;

import java.util.List;

public class TaxiRunner {
    public static void main(String[] args) {

        TaxiDAOImpl dao = new TaxiDAOImpl();

        TaxiDetailsDTO dto = new TaxiDetailsDTO();

        dto.setDriverName("Amruta");
        dto.setCarModel("BMW");
        dto.setLicensePlate("KA-01-AB-1234");
        dto.setFarePerKm(15.0);

        boolean saved = dao.save(dto);
        System.out.println("Taxi details saved: " + saved);

        dto.setFarePerKm(25.0);
        boolean updated = dao.update(dto);
        System.out.println("Taxi details updated: " + updated);

        boolean deleted = dao.delete(dto);
        System.out.println("Taxi details deleted: " + deleted);

        TaxiDetailsDAO dao1 = new TaxiDAOImpl();
        TaxiService service = new TaxiServiceImpl(dao1);
        TaxiDetailsDTO dto1 = new TaxiDetailsDTO();
        dto1.setDriverName("Amruta");
        dto1.setCarModel("BMW");
        dto1.setLicensePlate("KA-01-AB-1234");
        dto1.setFarePerKm(15.0);
        boolean validateAndSave = service.validateAndSave(dto1);

        System.out.println("Taxi details saved: " + saved);

        TaxiDetailsDTO dto2 = new TaxiDetailsDTO();
        dto2.setId(4);
        dto2.setDriverName("Amruta");
        dto2.setCarModel("BMW");
        dto2.setLicensePlate("KA-01-AB-1234");
        dto2.setFarePerKm(25.0);

        boolean validateAndUpdate = service.validateAndUpdate(dto2);
        System.out.println("Taxi details updated: " + validateAndUpdate);


        TaxiDetailsDTO dto3 = new TaxiDetailsDTO();
        dto3.setId(1);
        int deletedRows = service.validateAndDelete(dto3);
        System.out.println("Rows deleted: " + deletedRows);

        List<TaxiDetailsDTO> taxiDetails = service.getTaxiDetails();
        System.out.println("Taxi Details:");
        for (TaxiDetailsDTO dto4 : taxiDetails) {
            System.out.println(dto4);
        }
    }
}
