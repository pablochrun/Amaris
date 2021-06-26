package com.example.amaris.service;

import com.example.amaris.dao.PricesDao;
import com.example.amaris.entity.PricesEntity;
import com.example.amaris.mapper.PricesEntityToPricesResponseMapper;
import com.example.amaris.model.PricesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceImplTest{

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 2;
    private static final LocalDateTime DATE = LocalDateTime.now();

    @InjectMocks
    PricesServiceImpl pricesService;

    @Mock
    PricesDao pricesDao;
    @Mock
    PricesEntityToPricesResponseMapper mapper;

    @Test
    public void testGetPrice(){

        PricesEntity price_1 = PricesEntity.builder().priority(1).build();
        PricesEntity price_2 = PricesEntity.builder().priority(0).build();
        List<PricesEntity> expectedPrices = Arrays.asList(price_1, price_2);

        PricesResponse expectedPriceResponse = mock(PricesResponse.class);

        when(pricesDao.findPrice(BRAND_ID, PRODUCT_ID, DATE)).thenReturn(expectedPrices);
        when(mapper.convertPriceEntity(price_1)).thenReturn(expectedPriceResponse);

        PricesResponse response = pricesService.getPrice(BRAND_ID, PRODUCT_ID, DATE);

        assertNotNull(response);
        assertEquals(expectedPriceResponse, response);

    }

}