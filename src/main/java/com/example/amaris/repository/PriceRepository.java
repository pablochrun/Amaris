package com.example.amaris.repository;

import com.example.amaris.entity.PriceEntityId;
import com.example.amaris.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PricesEntity, PriceEntityId>{

    List<PricesEntity> findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Integer brandId,
            Integer productId, Date date1, Date date2);
}
