package com.example.amaris.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricesResponse{

    Integer brandId;
    Integer productId;
    Integer priceList;
    Timestamp startDate;
    Timestamp endDate;
    Double price;
    String currency;

}
