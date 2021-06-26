package com.example.amaris.mapper;

import com.example.amaris.entity.PricesEntity;
import com.example.amaris.model.PricesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PricesEntityToPricesResponseMapperTest{

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 2;
    private static final Timestamp START_DATE = Timestamp.valueOf(LocalDateTime.now());
    private static final Integer PRICE_LIST = 3;
    private static final Timestamp END_DATE = Timestamp.valueOf(LocalDateTime.now());
    private static final Integer PRIORITY = 4;
    private static final Double PRICE = 30.95;
    private static final String CURRENCY = "EUR";

    @InjectMocks
    PricesEntityToPricesResponseMapper mapper;

    @Test
    public void testMapper(){

        PricesEntity entity = PricesEntity.builder().brandId(BRAND_ID).productId(PRODUCT_ID)
                .startDate(START_DATE).endDate(END_DATE).priceList(PRICE_LIST)
                .priority(PRIORITY).price(PRICE).currency(CURRENCY).build();

        PricesResponse response = mapper.convertPriceEntity(entity);

        assertNotNull(response);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(PRICE_LIST, response.getPriceList());
        assertEquals(START_DATE, response.getStartDate());
        assertEquals(END_DATE, response.getEndDate());
        assertEquals(PRICE, response.getPrice());
        assertEquals(CURRENCY, response.getCurrency());

    }

    @Test
    public void testMapperNull(){

        PricesResponse response = mapper.convertPriceEntity(null);

        assertNull(response);

    }

}