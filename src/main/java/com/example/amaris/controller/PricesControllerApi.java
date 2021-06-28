package com.example.amaris.controller;

import com.example.amaris.model.PricesResponse;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public interface PricesControllerApi{
    @GetMapping(path = "/price/{brandId}/{productId}/{timedate}",
           produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (code = HttpStatus.OK)
    public ResponseEntity<PricesResponse> getPrice(@NotNull @PathVariable("brandId") Integer brandId,
            @NotNull @PathVariable("productId") Integer productId,
            @NotNull @PathVariable(value="timedate")  @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime timedate );


}
