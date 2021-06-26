package com.example.amaris.dao;

import com.example.amaris.entity.PricesEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesDao{

    List<PricesEntity> findPrice(Integer brandId, Integer productId, LocalDateTime date);
}
