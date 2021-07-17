package com.insurance.insurance.services;

import com.insurance.insurance.models.Driver;
import com.insurance.insurance.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServicesImpl implements DriverServices {
    private DriverRepository driverRepository;

    @Autowired
    public DriverServicesImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver saveDriveInfo(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> getDriverInfo(long driverId){
        return driverRepository.findById(driverId);
    }

    @Override
    public String updateDriverInfo(Driver driveInfo){
        return "Updated";
    }
    @Override
    public String deleteDriver(Long driverId){
        return "driver deleted";
    }
}
