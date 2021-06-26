package com.example.amaris.dao;

import com.example.amaris.entity.PricesEntity;
import com.example.amaris.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricesDaoImplTest{

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 2;
    private static final LocalDateTime DATE = LocalDateTime.now();

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    PricesDaoImpl pricesDao;

    @Test
    public void testFindPriceOk(){

        PricesEntity mockPriceEntity_1 = mock(PricesEntity.class);
        PricesEntity mockPriceEntity_2 = mock(PricesEntity.class);
        List<PricesEntity> pricesEntities = Arrays.asList(mockPriceEntity_1, mockPriceEntity_2);

        Date startDate = Date.from(DATE.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(DATE.atZone(ZoneId.systemDefault()).toInstant());


        when(priceRepository.findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                eq(BRAND_ID), eq(PRODUCT_ID), eq(startDate), eq(endDate))).thenReturn(pricesEntities);

        List<PricesEntity> response = pricesDao.findPrice(BRAND_ID, PRODUCT_ID, DATE);

        assertEquals(pricesEntities, response);

        verify(priceRepository, times(1)).findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                eq(BRAND_ID), eq(PRODUCT_ID), eq(startDate), eq(endDate));

    }

    @Test
    public void testFindPriceKo(){

        RuntimeException exception = mock(RuntimeException.class);

        Date startDate = Date.from(DATE.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(DATE.atZone(ZoneId.systemDefault()).toInstant());


        doThrow(exception).when(priceRepository).findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                eq(BRAND_ID), eq(PRODUCT_ID), eq(startDate), eq(endDate));


        Exception expectedException = assertThrows(Exception.class, () ->pricesDao.findPrice(BRAND_ID, PRODUCT_ID, DATE));

        assertEquals(expectedException, exception);

        verify(priceRepository, times(1)).findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                eq(BRAND_ID), eq(PRODUCT_ID), eq(startDate), eq(endDate));

    }
}