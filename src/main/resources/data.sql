INSERT INTO BRANDS ( BRAND_ID, BRAND_NAME) VALUES (1, 'ZARA');


INSERT INTO PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES
  (1, to_date('2020-06-14-00.00.00', 'YYYY-MM-DD-hh24:mi:ss'), to_date('2020-12-31-23.59.59', 'YYYY-MM-DD-hh24:mi:ss'), 1, 35455, 0, 35.50, 'EUR'),
  (1, to_date('2020-06-14-15.00.00', 'YYYY-MM-DD-hh24:mi:ss'), to_date('2020-06-14-18.30.00', 'YYYY-MM-DD-hh24:mi:ss'), 2, 35455, 1, 25.45, 'EUR'),
  (1, to_date('2020-06-15-00.00.00', 'YYYY-MM-DD-hh24:mi:ss'), to_date('2020-06-15-11.00.00', 'YYYY-MM-DD-hh24:mi:ss'), 3, 35455, 1, 30.50, 'EUR'),
  (1, to_date('2020-06-15-16.00.00', 'YYYY-MM-DD-hh24:mi:ss'), to_date('2020-12-31-23.59.59', 'YYYY-MM-DD-hh24:mi:ss'), 4, 35455, 1, 38.95, 'EUR');
