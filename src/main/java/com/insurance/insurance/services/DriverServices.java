package com.insurance.insurance.services;

import com.insurance.insurance.exception.DriverNotFoundException;
import com.insurance.insurance.models.Driver;

import java.util.Optional;

public interface DriverServices {
    Driver saveDriveInfo(Driver driver);
    Driver getDriverInfo(long driverId) throws DriverNotFoundException;
    String updateDriverInfo(Driver driveInfo) throws DriverNotFoundException;
    String deleteDriver(Long driverId) throws DriverNotFoundException;
}
