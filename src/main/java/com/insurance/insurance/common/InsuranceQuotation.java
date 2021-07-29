package com.insurance.insurance.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class InsuranceQuotation {

    public Double getVehicleTypeFactor(String vehicleType){
        HashMap<String,Double> vehicleTypeMap=new HashMap<>();
        vehicleTypeMap.put("Cabriolet",1.3);
        vehicleTypeMap.put("Coupe",1.4);
        vehicleTypeMap.put("Estate",1.5);
        vehicleTypeMap.put("Hatchback",1.6);
        vehicleTypeMap.put("Other",1.7);

        return vehicleTypeMap.get(vehicleType);
    }

    public Double getEngineSizeFactor(int engineSize){
        HashMap<Integer,Double> engineSizeMap = new HashMap<>();
        engineSizeMap.put(1000,1.0);
        engineSizeMap.put(1600,1.0);
        engineSizeMap.put(2000,1.0);
        engineSizeMap.put(2500,1.0);
        engineSizeMap.put(3000,1.0);
        engineSizeMap.put(0,1.0);
        return engineSizeMap.get(engineSize);
    }

    public Double getVehicleValueFactor(long vehicleValue){
        return vehicleValue <= 5000 ? 1.0 : 1.2;
    }

    public Double getAdditionalDriverFactor(int drivers){
        return drivers < 2 ? 1.1 : 1.2;
    }

    public Double getCommercialUsageFactor(boolean commercialUsage){
        return commercialUsage ? 1.1 : 1.0;
    }

    public Double getOutSideStateFactor(boolean usedOutSide){
        return usedOutSide ? 1.1 : 1.0;
    }

    public  Double calculateInsuranceQuotation(String vehicleType,int engineSize,
                                              long vehicleValue, int drivers ,
                                              boolean commercialUsage,boolean usedOutSide){

        return 100 * getVehicleTypeFactor(vehicleType) * getEngineSizeFactor(engineSize)
                   * getAdditionalDriverFactor(drivers) * getCommercialUsageFactor(commercialUsage)
                   * getOutSideStateFactor(usedOutSide) * getVehicleValueFactor(vehicleValue);
    }
}
