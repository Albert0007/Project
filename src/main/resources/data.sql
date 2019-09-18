INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);

INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);

INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);





INSERT INTO document  (code, name, version) VALUES (03, 'Свидетельство о рождении', 0);

INSERT INTO document  (code, name, version) VALUES (21, 'Паспорт гражданина Российской Федерации ', 0);

INSERT INTO document  (code, name, version) VALUES (07, 'Военный билет', 0);



INSERT INTO document_registry (doc_name, doc_number, doc_data, version) VALUES ('Паспорт гражданина Российской Федерации', 21, 23-01-2011, 0);

INSERT INTO document_registry (doc_name, doc_number, doc_data, version) VALUES ('Паспорт гражданина Российской Федерации', 21, 23-01-2011, 0);

INSERT INTO document_registry (doc_name, doc_number, doc_data, version) VALUES ('Паспорт гражданина Российской Федерации', 21, 23-01-2011, 0);







INSERT INTO employee ( id, first_name, second_name, middle_name, position, phone, is_identified, country_id, document_id, version)
VALUES (1,'Иван', 'Павлов', 'Александрович', 'продавец', 89198276357, true, 1, 1, 0);

INSERT INTO employee ( id, first_name, second_name, middle_name, position, phone, is_identified, country_id, document_id, version)
VALUES (2,'Вера', 'Сергеева', 'Андреевна', 'кассир', 89270909879, true, 1, 1, 0);

INSERT INTO employee ( id, first_name, second_name, middle_name, position, phone, is_identified, country_id, document_id, version)
VALUES (3,'Ирина', 'Николаева', 'Петровна', 'директор', 878787, true, 1, 1, 0);



INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ('ОOО', 'Тандер', 321987, 948736, 'Менякина, 7', 242424, TRUE, 0);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ('ОАО', 'Х5 Group', 174783, 127209, 'Ленина, 80', 909090, TRUE, 0);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ('О00', 'Альфа', 574638, 109387, 'Измайлова, 124', 777666, TRUE, 0);



INSERT INTO office (id, first_name, address, phone, org_id, is_active, version) 
VALUES (1, 'Магнит', 'ул.Лунина, 7', 2424241, 1, TRUE, 0);

INSERT INTO office (id, first_name, address, phone, org_id, is_active, version) 
VALUES (2, 'Пятерочка', 'ул.Пушкина, 19', 9090901, 2, TRUE, 0);

INSERT INTO office (id, first_name, address, phone, org_id, is_active, version) 
VALUES (3, 'КиБ', 'ул.Невская, 37', 7776661, 3, TRUE, 0);



INSERT INTO Employee_Office (employee_id, office_id) 
VALUES (1, 1);

INSERT INTO Employee_Office (employee_id, office_id) 
VALUES (2, 2);

INSERT INTO Employee_Office (employee_id, office_id) 
VALUES (3, 3);

INSERT INTO Office_Organization (org_id, off_id) 
VALUES (1, 1);
INSERT INTO Office_Organization (org_id, off_id) 
VALUES (2, 2);
INSERT INTO Office_Organization (org_id, off_id) 
VALUES (3, 3);




