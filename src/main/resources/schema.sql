DROP TABLE IF EXISTS PRICES;
DROP TABLE IF EXISTS BRANDS;

CREATE TABLE BRANDS (
  brand_id NUMBER(1) PRIMARY KEY,
  brand_name VARCHAR2(15) NOT NULL
);


CREATE TABLE PRICES (
  brand_id NUMBER(1),
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_list NUMBER(1) NOT NULL,
  product_id NUMBER(6) NOT NULL,
  priority NUMBER(1) NOT NULL,
  price NUMBER(5,2) NOT NULL,
  currency VARCHAR2(3) NOT NULL,
  foreign key (brand_id) references BRANDS(brand_id)
);