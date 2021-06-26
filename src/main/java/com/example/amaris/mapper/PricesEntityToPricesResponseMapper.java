package com.example.amaris.mapper;

import com.example.amaris.entity.PricesEntity;
import com.example.amaris.model.PricesResponse;
import org.springframework.stereotype.Component;

@Component
public class PricesEntityToPricesResponseMapper{

    public PricesResponse convertPriceEntity(PricesEntity priceEntity){

        if(priceEntity == null)
            return null;

        return PricesResponse.builder()
                .brandId(priceEntity.getBrandId())
                .productId(priceEntity.getProductId())
                .priceList(priceEntity.getPriceList())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .price(priceEntity.getPrice())
                .currency(priceEntity.getCurrency())
                .build();

    }

}

