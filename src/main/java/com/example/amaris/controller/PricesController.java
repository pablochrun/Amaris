package com.example.amaris.controller;

import com.example.amaris.model.PricesResponse;
import com.example.amaris.service.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PricesController implements PricesControllerApi{


    PricesService pricesService;

    public ResponseEntity<PricesResponse> getPrice(Integer brandId, Integer productId, LocalDateTime date){
        return new ResponseEntity<>(pricesService.getPrice(brandId, productId, date), HttpStatus.OK);
    }
}
