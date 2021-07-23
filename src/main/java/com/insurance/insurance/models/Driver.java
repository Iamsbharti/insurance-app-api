package com.insurance.insurance.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DRIVER_DETAILS")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String salutation;
    private String firstName;
    private String lastName;
    private Long telephone;
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
