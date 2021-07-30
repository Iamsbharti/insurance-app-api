package com.insurance.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private Long id;
    @NotEmpty(message = "Salutation is Required")
    private String salutation;
    @NotEmpty(message = "FirstName can't Empty")
    private String firstName;
    @NotEmpty(message = "LastName can't Empty")
    private String lastName;
    @NotNull(message = "Telephone can't Empty")
    private Long telephone;
    @NotEmpty(message = "Address can't Empty")
    private String address;
    @NotEmpty(message = "City can't Empty")
    private String city;
    @NotEmpty(message = "PinCode can't Empty")
    private String pinCode;
    @NotEmpty(message = "vehicleType can't Empty")
    private String vehicleType;
    @NotNull(message = "engineSize can't Empty")
    private int engineSize;
    @NotNull(message = "Driver's count range 1-4")
    private int driversCount;
    @NotNull(message = "Provide True/false")
    private boolean isCommercial;
    @NotNull(message = "Provide True/false")
    private boolean canUseOutSide;
    @NotNull(message = "Current Value Required")
    private long currentValue;
    @NotEmpty(message = "Registered Date Required")
    private String registeredDate;
}
