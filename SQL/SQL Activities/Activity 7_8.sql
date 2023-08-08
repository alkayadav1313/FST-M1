REM   Script: Acticity 8
REM   this is activity for activity8

DROP Table orders;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * FROM orders;

DROP Table orders;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * FROM orders;

SELECT customer_id, SUM(purchase_amount) FROM orders  Group By customer_id, Order by order_date;

SELECT customer_id, SUM(purchase_amount) totalsum FROM orders Group By customer_id;

SELECT customer_id, SUM(purchase_amount) totalsum FROM orders Group By customer_id ORDER BY order_date;

SELECT customer_id, SUM(purchase_amount) totalsum FROM orders Group By customer_id ORDER BY customer_id;

SELECT SUM(purchase_amount) totalsum FROM orders;

SELECT AVG(purchase_amount) Average FROM orders;

SELECT COUNT(*) total FROM orders;

SELECT ROUND(AVG(purchase_amount),0) Average FROM orders;

SELECT AVG(purchase_amount) Average FROM orders;

SELECT customer_id MAX(purchase_amount) Maximum salary FROM oders GROUP BY customer_id Order By purchase_amount;

SELECT customer_id MAX(purchase_amount) Maximum salary FROM oders GROUP BY customer_id Order By customer_id;

SELECT customer_id MAX(purchase_amount) Maximum salary FROM orders GROUP BY customer_id Order By customer_id;

SELECT customer_id, MAX(purchase_amount) Maximum salary FROM orders GROUP BY customer_id Order By customer_id;

SELECT customer_id, MAX(purchase_amount) "Maximum salary" FROM orders GROUP BY customer_id Order By customer_id;

SELECT customer_id, MAX(purchase_amount) "Maximum salary" FROM orders GROUP BY customer_id Order By order_date;

SELECT customer_id, MAX(purchase_amount) "Maximum salary" FROM orders GROUP BY customer_id Order By order_date ASC;

SELECT customer_id, MAX(purchase_amount) "Maximum salary" FROM orders GROUP BY customer_id;

SELECT salesman_id,order_date, MAX(purchase_amount) "Maxsal" FROM orders WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD')GROUP;

SELECT salesman_id,order_date, MAX(purchase_amount) "Maxsal" FROM orders WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD')  
    GROUP BY salesman_id,order_date;

SELECT order_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE purchase_amount IN (2030,3450,5760,6000) 
GROUP BY order_id,order_date;

SELECT salesman_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE purchase_amount IN (2030,3450,5760,6000) 
GROUP BY salesman_id,order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

SELECT salesman_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE purchase_amount IN (2030,3450,5760,6000) 
GROUP BY salesman_id,order_date;

SELECT customer_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE purchase_amount IN (2030,3450,5760,6000) 
GROUP BY customer_id,order_date;

SELECT customer_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE MAX(purchase_amount) IN (2030,3450,5760,6000) 
GROUP BY customer_id,order_date;

SELECT customer_id,order_date, MAX(purchase_amount)"MaxSalary" FROM orders WHERE purchase_amount IN (2030,3450,5760,6000) 
GROUP BY customer_id,order_date;

