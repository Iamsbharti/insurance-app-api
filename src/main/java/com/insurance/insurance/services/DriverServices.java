package com.insurance.insurance.services;

import com.insurance.insurance.models.Driver;

import java.util.Optional;

public interface DriverServices {
    Driver saveDriveInfo(Driver driver);
    Optional<Driver> getDriverInfo(long driverId);

    String updateDriverInfo(Driver driveInfo);

    String deleteDriver(Long driverId);
}
