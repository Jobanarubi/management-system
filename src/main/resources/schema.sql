DROP TABLE IF EXISTS ADD_USER_DETAILS;
DROP TABLE IF EXISTS PARCEL_DETAILS;
DROP TABLE IF EXISTS PARCEL_BILL;


  
  CREATE TABLE ADD_USER_DETAILS (
  seqid INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250),
  password VARCHAR(250)
  );
  
CREATE TABLE PARCEL_DETAILS (
  consingnment_id INT  NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250)  DEFAULT NULL,
  phone_number long,
  parcel_details VARCHAR(250) DEFAULT NULL,
  weight DOUBLE NOT NULL,
  packaging_type VARCHAR(50) DEFAULT NULL,
  delivery_address VARCHAR(250) DEFAULT NULL,
  delivery_agent VARCHAR(250) DEFAULT NULL,
  status VARCHAR(250) DEFAULT NULL,
  seqid int,
  FOREIGN KEY (seqid) REFERENCES ADD_USER_DETAILS(seqid)
);

CREATE TABLE PARCEL_BILL (
  bill_no INT  NOT NULL  PRIMARY KEY,
  package_rate VARCHAR(250),
  packaging_type VARCHAR(50) DEFAULT NULL,
  consingnment_id int,
  FOREIGN KEY (consingnment_id) REFERENCES PARCEL_DETAILS(consingnment_id)
  );