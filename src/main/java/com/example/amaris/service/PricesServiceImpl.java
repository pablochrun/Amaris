package com.example.amaris.service;

import com.example.amaris.dao.PricesDao;
import com.example.amaris.entity.PricesEntity;
import com.example.amaris.mapper.PricesEntityToPricesResponseMapper;
import com.example.amaris.model.PricesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PricesServiceImpl implements PricesService{

    PricesDao pricesDao;

    PricesEntityToPricesResponseMapper mapper;

    public PricesResponse getPrice(Integer brandId, Integer productId, LocalDateTime date){

        Optional<PricesEntity> price = pricesDao.findPrice(brandId, productId, date)
                .stream()
                .findFirst();

        return convertEntityToResponse(price);

    }

    private PricesResponse convertEntityToResponse(Optional<PricesEntity> priceOptional){

        PricesResponse pricesResponse1 = null;

        if(priceOptional.isPresent()){
            PricesEntity price = priceOptional.get();
            pricesResponse1 = mapper.convertPriceEntity(price);
        }

        return pricesResponse1;
    }
}
