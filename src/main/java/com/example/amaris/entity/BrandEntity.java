package com.example.amaris.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="BRANDS")
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity{

    @Id
    @Column(name = "brand_id")
    Integer brand_id;

    @Column (name = "brand_name")
    String brand_name;

}
