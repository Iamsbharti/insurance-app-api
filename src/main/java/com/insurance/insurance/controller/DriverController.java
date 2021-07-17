package com.insurance.insurance.controller;


import com.insurance.insurance.common.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/v1/insurance")
public class DriverController {
    @GetMapping("/ping")
    public ResponseEntity<ApiResponse> getPingTest(){
        ApiResponse pingResponse = new ApiResponse("success","Insurance API UP",null);
        return new ResponseEntity(pingResponse, HttpStatus.OK);
    }
}
