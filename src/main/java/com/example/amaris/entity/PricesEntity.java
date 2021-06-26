package com.example.amaris.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name="PRICES")
@IdClass(PriceEntityId.class)
@NoArgsConstructor
@AllArgsConstructor
public class PricesEntity {

    @Id
    @Column (name = "brand_id")
    public Integer brandId;

    @Id
    @Column (name = "price_list")
    public Integer priceList;

    @Id
    @Column (name = "product_id")
    public Integer productId;

    @Column (name = "start_date")
    public Timestamp startDate;

    @Column (name = "end_date")
    public Timestamp endDate;


    @Column (name = "priority")
    public Integer priority;

    @Column (name = "price")
    public Double price;

    @Column (name = "currency")
    public String currency;

}
