INSERT INTO consumers_table (username, password, name, surname, sex, age, phone_number) VALUES ('Danik', '2004', 'Danik', 'Mamaiko', 'male', 18, '375336535768');
INSERT INTO consumers_table (username, password, name, surname, sex, age, phone_number) VALUES ('Svetlana', '2001', 'Svetlana', 'Dub', 'female', 21, '375294785245');

INSERT INTO orders_table (weight, filling, design, client_id) VALUES (2, 'Красный бархат', 'Lego', 1);
INSERT INTO orders_table (weight, filling, design, client_id) VALUES (1.6, 'Медовик', 'С феямии', 2);

INSERT INTO role_table (title) VALUES ('ROLE_ADMIN');
INSERT INTO role_table (title) VALUES ('ROLE_USER');