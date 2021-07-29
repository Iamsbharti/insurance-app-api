package com.insurance.insurance.services;

import com.insurance.insurance.common.InsuranceQuotation;
import com.insurance.insurance.exception.DriverNotFoundException;
import com.insurance.insurance.models.Driver;
import com.insurance.insurance.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServicesImpl implements DriverServices {
    private DriverRepository driverRepository;
    private InsuranceQuotation insuranceQuotation;

    @Autowired
    public DriverServicesImpl(DriverRepository driverRepository,InsuranceQuotation insuranceQuotation) {
        this.driverRepository = driverRepository;
        this.insuranceQuotation = insuranceQuotation;
    }

    @Override
    public Driver saveDriveInfo(Driver driver)  {
        Double quotationAmount = insuranceQuotation.calculateInsuranceQuotation(
                                    driver.getVehicleType(),driver.getEngineSize(),
                                    driver.getCurrentValue(),driver.getDriversCount(),
                                    driver.isCommercial(),driver.isCanUseOutSide());

        driver.setQuoteAmount(quotationAmount);
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
    public Driver updateDriverInfo(Driver driverInfo)throws DriverNotFoundException{
        Driver driverObject = getDriverInfo(driverInfo.getId());
        if(driverObject != null){
            // save new properties
            driverObject.setFirstName(driverInfo.getFirstName());
            driverObject.setLastName(driverInfo.getLastName());
            driverObject.setAddress(driverInfo.getAddress());
            driverObject.setSalutation(driverInfo.getSalutation());
            driverObject.setPinCode(driverInfo.getPinCode());
            driverObject.setCity(driverInfo.getCity());
            driverObject.setTelephone(driverInfo.getTelephone());
            driverRepository.save(driverObject);
        }
        return driverObject;
    }
    @Override
    public String deleteDriver(Long driverId)throws DriverNotFoundException{
        // find driver quote
        Driver driverInfo = getDriverInfo(driverId);
        driverRepository.deleteById(driverId);
        return "Driver's Quote deleted";
    }
}
