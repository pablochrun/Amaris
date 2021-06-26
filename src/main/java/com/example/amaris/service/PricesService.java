package com.example.amaris.service;

import com.example.amaris.model.PricesResponse;

import java.time.LocalDateTime;

public interface PricesService{

    public PricesResponse getPrice(Integer brandId, Integer productId, LocalDateTime date);
}
