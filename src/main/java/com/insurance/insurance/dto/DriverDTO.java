package com.insurance.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private Long id;
    private String salutation;
    private String firstName;
    private String lastName;
    private int telephone;
    private String address;
    private String city;
    private String pinCode;
    private String vehicleType;
    private String engineSize;
    private String driversCount;
    private boolean isCommercial;
    private boolean canUseOutSide;
    private long currentValue;
    private String registeredDate;
}
