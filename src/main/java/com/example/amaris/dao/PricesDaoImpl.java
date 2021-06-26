package com.example.amaris.dao;

import com.example.amaris.entity.PricesEntity;
import com.example.amaris.repository.PriceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class PricesDaoImpl implements PricesDao{


    private PriceRepository priceRepository;

    @Override
    public List<PricesEntity> findPrice(Integer brandId, Integer productId, LocalDateTime date){

        Date startDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());


        try {
            return priceRepository.findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
        } catch(Exception ex){
            //log either throw the exception
            //This exception can be intercepted in controller layer to return a custom response
            log.error(ex.getMessage());
            throw ex;
        }
    }
}
