package com.xworkz.taxi.service;

import com.xworkz.taxi.dao.TaxiDetailsDAO;
import com.xworkz.taxi.dto.TaxiDetailsDTO;

import java.util.List;
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
    @Override
    public boolean validateAndUpdate(TaxiDetailsDTO dto) {

        System.out.println("validateAndUpdate in TaxiServiceImpl");

        if (Objects.nonNull(this.taxiDetailsDAO)) {

            System.out.println("DAO is not null");

            if (Objects.nonNull(dto)) {

                int id = dto.getId();
                String driverName = dto.getDriverName();
                String carModel = dto.getCarModel();
                String licensePlate = dto.getLicensePlate();
                double farePerKm = dto.getFarePerKm();

                if (id > 0
                        && Objects.nonNull(driverName)
                        && driverName.length() >= 3
                        && Objects.nonNull(carModel)
                        && carModel.length() >= 3
                        && Objects.nonNull(licensePlate)
                        && !licensePlate.isEmpty()
                        && licensePlate.length() >= 8
                        && farePerKm > 0) {

                    System.out.println("DTO is valid");

                    return this.taxiDetailsDAO.updateByExecuteUpdate(dto);
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

    @Override
    public int validateAndDelete(TaxiDetailsDTO dto) {
        if (Objects.nonNull(this.taxiDetailsDAO)) {
            if (Objects.nonNull(dto)) {
                int id = dto.getId();

                if (id > 0) {
                    return this.taxiDetailsDAO.deleteByExecuteUpdate(dto);
                }
            }
        }

        return 0;
    }

    @Override
    public List<TaxiDetailsDTO> getTaxiDetails() {
        return taxiDetailsDAO.getTaxiDetails();
    }
}