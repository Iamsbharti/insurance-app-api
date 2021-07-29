package com.insurance.insurance.controller;


import com.insurance.insurance.common.ApiResponse;
import com.insurance.insurance.common.DtoConvertor;
import com.insurance.insurance.dto.DriverDTO;
import com.insurance.insurance.exception.DriverNotFoundException;
import com.insurance.insurance.models.Driver;
import com.insurance.insurance.services.DriverServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/api/v1/insurance")
@CrossOrigin
public class DriverController {
    DriverServices driverServices;
    @Autowired
    public DriverController(DriverServices driverServices){
        this.driverServices = driverServices;
    }

    @GetMapping("/ping")
    public ResponseEntity<ApiResponse> getPingTest(){
        ApiResponse pingResponse = new ApiResponse("success","Insurance API UP",null);
        return new ResponseEntity(pingResponse, HttpStatus.OK);
    }

    @PostMapping("/driver/quote")
    public ResponseEntity<ApiResponse> saveDriveInfo(@RequestBody DriverDTO driverDTO){
        // convert DTO to entity(Driver)
        Driver newDriverObject = DtoConvertor.driverDtoToEntity(driverDTO);
        Driver savedDriverQuote = driverServices.saveDriveInfo(newDriverObject);

        // generate api response
        ApiResponse response = new ApiResponse();
        response.setStatus("success");
        response.setMessage("Quote generated");
        response.setData(savedDriverQuote);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @DeleteMapping("/driver/quote/{id}")
    public ResponseEntity<ApiResponse> deleteDriverQuote(@PathVariable long id) throws DriverNotFoundException {
        log.info("Delete Driver Quote Controller::"+id);
        String error = driverServices.deleteDriver(id);

        ApiResponse response = new ApiResponse();
        response.setStatus("success");
        response.setMessage(error);
        response.setData(null);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/driver/quote/{id}")
    public ResponseEntity<ApiResponse> getDriverQuoteInfo(@PathVariable long id) throws DriverNotFoundException{
        log.info("Get Driver Quote info::"+id);
        Driver driverInfo= driverServices.getDriverInfo(id);
        ApiResponse response = new ApiResponse();
        response.setStatus("success");
        response.setMessage("Driver Info. Fetched");
        response.setData(driverInfo);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/driver/quote")
    @ResponseBody
    public ResponseEntity<ApiResponse> updateDriverInfo(@RequestBody DriverDTO driverDTO) throws DriverNotFoundException {
        log.info("Update Driver info");
        Driver driverInfoObject= DtoConvertor.driverDtoToEntity(driverDTO);
        Driver driverUpdatesResponse = driverServices.updateDriverInfo(driverInfoObject);

        ApiResponse updatesResponse = new ApiResponse();
        updatesResponse.setStatus("success");
        updatesResponse.setMessage("Driver info updated");
        updatesResponse.setData(driverUpdatesResponse);

        return new ResponseEntity<>(updatesResponse,HttpStatus.OK);
    }

}
