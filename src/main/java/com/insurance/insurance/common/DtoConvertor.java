package com.insurance.insurance.common;

import com.insurance.insurance.dto.DriverDTO;
import com.insurance.insurance.models.Driver;

public class DtoConvertor {
    public static Driver driverDtoToEntity(DriverDTO driverDTO){

        Driver driverObject = new Driver();

        driverObject.setId(driverDTO.getId());
        driverObject.setAddress(driverDTO.getAddress());
        driverObject.setDriversCount(driverDTO.getDriversCount());
        driverObject.setCity(driverDTO.getCity());
        driverObject.setCommercial(driverDTO.isCommercial());
        driverObject.setCanUseOutSide(driverDTO.isCanUseOutSide());
        driverObject.setCurrentValue(driverDTO.getCurrentValue());
        driverObject.setEngineSize(driverDTO.getEngineSize());
        driverObject.setFirstName(driverDTO.getFirstName());
        driverObject.setLastName(driverDTO.getLastName());
        driverObject.setSalutation(driverDTO.getSalutation());
        driverObject.setTelephone(driverDTO.getTelephone());
        driverObject.setRegisteredDate(driverDTO.getRegisteredDate());
        driverObject.setVehicleType(driverDTO.getVehicleType());
        driverObject.setPinCode(driverDTO.getPinCode());

        return driverObject;
    }
}
