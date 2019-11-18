INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);

INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);

INSERT INTO country (code, name, version) VALUES (643, 'Российская Федерация', 0);



INSERT INTO document  (code, name, version, country_id, document) VALUES (03, 'Свидетельство о рождении', 0, 1, 3);

INSERT INTO document  (code, name, version, country_id, document) VALUES (21, 'Паспорт гражданина Российской Федерации ', 0, 2, 2);

INSERT INTO document  (code, name, version, country_id, document) VALUES (07, 'Военный билет', 0, 3, 1);



INSERT INTO document_type (doc_name, doc_number, doc_data, version, document_id) VALUES ('Свидетельство о рождении', 03, '12-10-2003', 0, 3);

INSERT INTO document_type (doc_name, doc_number, doc_data, version, document_id) VALUES ('Паспорт гражданина Российской Федерации', 21, '12-11-2007', 0, 2);

INSERT INTO document_type (doc_name, doc_number, doc_data, version, document_id) VALUES ('Военный билет', 07, '15-10-2010', 0, 1);



INSERT INTO employee (  first_name, second_name, middle_name, position, phone, is_identified, country_id,document_id,version)
VALUES ('Иван', 'Павлов', 'Александрович', 'продавец', '8953238983', true, 1, 1, 0);

INSERT INTO employee (  first_name, second_name, middle_name, position, phone, is_identified, country_id,document_id, version)
VALUES ('Вера', 'Сергеева', 'Андреевна', 'кассир', '89413204983', true, 2, 2,  0);

INSERT INTO employee (  first_name, second_name, middle_name, position, phone, is_identified, country_id,document_id, version)
VALUES ('Ирина', 'Николаева', 'Петровна', 'директор', '89612983094', true, 3, 3,  0);



INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version)
VALUES ('ОOО', 'Тандер', 321987, 948736, 'Менякина, 7', 242424, TRUE, 0);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version)
VALUES ('ОАО', 'Х5 Group', 174783, 127209, 'Ленина, 80', 909090, TRUE, 0);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version)
VALUES ('О00', 'Альфа', 574638, 109387, 'Измайлова, 124', 777666, TRUE, 0);



INSERT INTO office (id, first_name, address, phone, organization_id, is_active, version)
VALUES (1, 'Магнит', 'ул.Лунина, 7', 2424241, 1, TRUE, 0);

INSERT INTO office (id, first_name, address, phone, organization_id, is_active, version)
VALUES (2, 'Пятерочка', 'ул.Пушкина, 19', 9090901, 2, TRUE, 0);

INSERT INTO office (id, first_name, address, phone, organization_id, is_active, version)
VALUES (3, 'КиБ', 'ул.Невская, 37', 7776661, 3, TRUE, 0);



INSERT INTO Employee_Office (employee_id, office_id)
VALUES (1, 1);

INSERT INTO Employee_Office (employee_id, office_id)
VALUES (2, 2);

INSERT INTO Employee_Office (employee_id, office_id)
VALUES (3, 3);

INSERT INTO Office_Organization (organization_id, office_id)
VALUES (1, 1);

INSERT INTO Office_Organization (organization_id, office_id)
VALUES (2, 2);

INSERT INTO Office_Organization (organization_id, office_id)
VALUES (3, 3);




