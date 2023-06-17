select * from customer;

select * from airline;
select * from seat order by air_id, seat_id;

select * from reservation;
select * from res_seat;
select * from remain_seat;

desc airline;
desc customer;
desc res_seat;
desc remain_seat;

--CREATE TABLE customer(
--cust_id NUMBER(20) PRIMARY KEY,
--cust_name VARCHAR2(50) NOT NULL,
--phone VARCHAR2(50) NOT NULL,
--birthdate DATE NOT NULL,
--email VARCHAR2(50) NOT NULL,
--point NUMBER(30,2));
--
--CREATE TABLE airline(
--air_id VARCHAR2(50) PRIMARY KEY,
--dpt_time DATE NOT NULL,
--arv_time DATE NOT NULL,
--depart VARCHAR2(50) NOT NULL,
--arrival VARCHAR2(50) NOT NULL,
--tot_seat NUMBER(4) NOT NULL,
--tot_price NUMBER(10) NOT NULL);
--
--CREATE TABLE reservation(
--res_id NUMBER(20) PRIMARY KEY,
--cust_id NUMBER(20) NOT NULL,
--air_id VARCHAR2(50) NOT NULL,
--seats NUMBER(4) NOT NULL,
--price NUMBER(10) NOT NULL,
--FOREIGN KEY (cust_id) REFERENCES customer ON DELETE CASCADE,
--FOREIGN KEY (air_id) REFERENCES airline ON DELETE CASCADE
--);
--
--CREATE TABLE seat(
--seat_id VARCHAR2(50) NOT NULL,
--air_id VARCHAR2(50) NOT NULL,
--seat_grade VARCHAR2(50) NOT NULL,
--seat_status VARCHAR2(50) NOT NULL,
--PRIMARY KEY (seat_id, air_id),
--FOREIGN KEY (air_id) REFERENCES airline ON DELETE CASCADE
--);
--
--CREATE TABLE res_seat(
--res_id NUMBER(20) NOT NULL,
--air_id VARCHAR2(50) NOT NULL,
--seat_id VARCHAR2(50) NOT NULL,
--PRIMARY KEY (seat_id, res_id, air_id),
--FOREIGN KEY (res_id) REFERENCES reservation ON DELETE CASCADE,
--FOREIGN KEY (seat_id, air_id) REFERENCES seat ON DELETE CASCADE
--);
--
--CREATE TABLE remain_seat(
--air_id VARCHAR2(50) NOT NULL,
--seat_id VARCHAR2(50) NOT NULL,
--seat_grade VARCHAR2(50) NOT NULL,
--rem_seat NUMBER(10) NOT NULL,
--PRIMARY KEY (air_id, seat_id, seat_grade),
--FOREIGN KEY (air_id, seat_id) REFERENCES seat ON DELETE CASCADE
--);
--
--CREATE SEQUENCE seq_cust_id
--INCREMENT BY 1
--START WITH 1;
--
--CREATE SEQUENCE seq_res_id
--INCREMENT BY 1
--START WITH 1;

--desc customer;
--desc airline;
--desc reservation;
--desc seat;
--desc res_seat;
--desc remain_seat;

--drop table res_seat;
--drop table seat;
--drop table reservation;
--drop table airline;
--drop table customer;
--drop table remain_seat;
--
--drop sequence seq_cust_id;
--drop sequence seq_res_id;

--commit;
