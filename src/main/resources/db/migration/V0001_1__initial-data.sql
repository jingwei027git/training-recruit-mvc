CREATE TABLE CAR (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR2(50) NOT NULL,
  brand VARCHAR2(50) NOT NULL,
  color VARCHAR2(25) NOT NULL,
  price DECIMAL(12, 2) NOT NULL
);

CREATE TABLE CUSTOMER (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR2(50) NOT NULL,
  sex VARCHAR2(10) NOT NULL,
  age INT NOT NULL,
  money DECIMAL(16, 2) NOT NULL,
  comment VARCHAR2(500)
);

CREATE TABLE MAPPING_CUSTOMER_CAR (
  customer_id BIGINT NOT NULL,
  car_id BIGINT NOT NULL
);


INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (1, 'BLACK',  'Toyota', 'Altis', 59.9);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (2, 'BLACK',  'Honda',  'CR-V', 89.6);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (3, 'YELLOW', 'Nissan', 'S14', 88.8);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (4, 'GREEN',  'Honda',  'Civic', 78.7);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (5, 'BLUE',   'Mazda',  'Mazda 3', 89.4);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (6, 'GREEN',  'Toyota', 'Sienta', 66.5);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (7, 'RED',    'Honda',  'HR-V', 99.9);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (8, 'GREY',   'Nissan', 'S15', 93.5);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (9, 'RED',    'Toyota', 'Yaris', 56.1);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (10, 'BLACK',  'Mazda',  'Mazda 3', 78.4);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (11, 'YELLOW', 'Toyota', 'Prius c', 89.5);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (12, 'WHITE',  'Nissan', 'Tidda', 129.5);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (13, 'RED',    'Mazda',  'Mazda CX-3', 99.8);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (14, 'WHITE',  'Toyota', 'C-HR', 109.4);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (15, 'BLACK',  'Nissan', 'GTR', 250);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (16, 'YELLOW', 'Honda',  'Fit', 65.3);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (17, 'GREY',   'Nissan', 'Livina', 65.3);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (18, 'BLUE',   'Toyota', 'RAV4', 100);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (19, 'BLACK',  'Mazda',  'Nazda MX-5', 110.5);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (20, 'YELLOW', 'Nissan', 'Blue Bird', 109.3);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (21, 'WHITE',  'Toyota', 'Altis', 65.3);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (22, 'BLUE',   'Honda',  'Nsx', 1199.9);
INSERT INTO CAR(ID, COLOR, BRAND, NAME, PRICE) VALUES (23, 'BLACK',  'Honda',  'City', 59.4);

INSERT INTO CUSTOMER(ID, NAME, AGE, SEX, MONEY) VALUES(1, 'Benny', 30, 'Male', 500);
INSERT INTO CUSTOMER(ID, NAME, AGE, SEX, MONEY) VALUES(2, 'Kai', 20, 'Female', 350);
INSERT INTO CUSTOMER(ID, NAME, AGE, SEX, MONEY) VALUES(3, 'Kelly', 20, 'Female', 350);

INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(1, 1);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(1, 2);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(1, 3);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(2, 4);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(2, 5);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(2, 6);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(3, 7);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(3, 8);
INSERT INTO MAPPING_CUSTOMER_CAR(CUSTOMER_ID, CAR_ID) VALUES(3, 9);
