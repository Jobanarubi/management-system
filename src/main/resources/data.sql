INSERT INTO role (id, description, name) VALUES (4, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (5, 'User role', 'USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 4);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 5);


  INSERT INTO ADD_USER_DETAILS (seqid, username, password) VALUES
  (1, 'admin' , '$2a$04$rAWTDLDtYkvuhAiQps2v/uj1kkVuU2F8TJNXWa.cn1bioUHcHVFFC'),
  (2, 'dtc' , '$2a$04$bjP71apljwJ0.H12.fMqUuub4ElRLzTem7oAbem2Ka8ohxQrOAYz.'),
  (3, 'blu' , '$2a$04$OwDz6TPVrYgMLZ4Pjwl5HONjX0gzmas20n3TzXGak1utEhsLQBwaG');


INSERT INTO PARCEL_DETAILS ( consingnment_id, customer_name,parcel_details,weight,packaging_type,
delivery_address,delivery_agent,status,seqid) VALUES
  (100, 'Anu','Computer', 50.00, 'F', 'Trivandrum', 'DTC', 'packed',2),
  (200, 'Ajay','Table', 50.00, 'F', 'Chennai', 'DTC', 'packed',2),
  (300, 'Akash','Laptop', 50.00, 'F', 'Trivandrum', 'BLU', 'packed',3);
  
