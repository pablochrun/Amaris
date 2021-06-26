package com.example.amaris.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PriceEntityId implements Serializable{

    private Integer brandId;
    private Integer productId;
    private Integer priceList;

}
