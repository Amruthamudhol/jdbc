package com.xworkz.taxi.service;

import com.xworkz.taxi.dao.TaxiDetailsDAO;
import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.util.Objects;


public class TaxiServiceImpl implements TaxiService {

    private TaxiDetailsDAO taxiDetailsDAO;

    public TaxiServiceImpl(TaxiDetailsDAO taxiDetailsDAO) {
        this.taxiDetailsDAO = taxiDetailsDAO;
    }

    @Override
    public boolean validateAndSave(TaxiDetailsDTO dto) {

        System.out.println("validateAndSave in TaxiServiceImpl");

        if (Objects.nonNull(this.taxiDetailsDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                String driverName = dto.getDriverName();
                String carModel = dto.getCarModel();
                String licensePlate = dto.getLicensePlate();
                double farePerKm = dto.getFarePerKm();

                if (Objects.nonNull(driverName)
                        && driverName.trim().length() >= 3
                        && Objects.nonNull(carModel)
                        && carModel.trim().length() >= 3
                        && Objects.nonNull(licensePlate)
                        && !licensePlate.isEmpty()
                        && licensePlate.length() >= 8
                        && farePerKm > 0) {

                    System.out.println("DTO is valid");

                    return this.taxiDetailsDAO.savebyExecuteUpdate(dto);
                }

                System.err.println("DTO is invalid");

            } else {
                System.err.println("DTO is null");
            }

        } else {
            System.err.println("DAO is null");
        }

        return false;
    }
}