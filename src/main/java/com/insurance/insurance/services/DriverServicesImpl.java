package com.insurance.insurance.services;

import com.insurance.insurance.exception.DriverNotFoundException;
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
    public Driver saveDriveInfo(Driver driver)  {
        return driverRepository.save(driver);
    }

    @Override
    public Driver getDriverInfo(long driverId) throws DriverNotFoundException {
        Optional<Driver> driverInfo = driverRepository.findById(driverId);
        if (!driverInfo.isPresent()) {
            throw new DriverNotFoundException("Driver-Id Not Found");
        }
        return driverInfo.get();
    }
    @Override
    public String updateDriverInfo(Driver driveInfo)throws DriverNotFoundException{
        return "Updated";
    }
    @Override
    public String deleteDriver(Long driverId)throws DriverNotFoundException{
        // find driver quote
        Driver driverInfo = getDriverInfo(driverId);
        driverRepository.deleteById(driverId);
        return "Driver's Quote deleted";
    }
}
