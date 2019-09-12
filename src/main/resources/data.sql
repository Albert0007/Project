INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ( 'ООО', 'ТАНДЕР', 102938, 464738, 'Исаева, 2', '252525', TRUE, 1);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ('ОАО', 'Х5 Group', 174783, 127209, 'Ленина, 80', '909090', TRUE, 1);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ( 'ООО', 'Альфа', 121092, 133756, 'Семенова, 25', '777777', TRUE, 1);

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version) 
VALUES ('AAA', 'SUMKA', 009922, 664553, 'Волоха', 11', '111888', FALSE, 1);


INSERT INTO office (name, address, phone, org_id, is_active, version) 
VALUES ('Магнит', 'ул.Лунина, 7', 2525251, 1, TRUE, 1);

INSERT INTO office (name, address, phone, org_id, is_active, version)
VALUES ( 'Пятерочка', 'Затонная, 20', 9090901, 1, TRUE, 1);

INSERT INTO office (name, address, phone, org_id, is_active, version) 
VALUES ('КИБ', 'ул.Польская, 100', 7777771, 1, TRUE, 1);

INSERT INTO office (name, address, phone, org_id, is_active, version)
VALUES ( 'Cумка', 'Печная, 76', 1118881, 1, TRUE, 1);


INSERT INTO employee (first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_data, citizenship_code, is_identified_code, office_id, doc_code, version)  
VALUES ('Иван', 'Иванов', 'Сергеевич', 'Продавец', 656565, 21, 6310987678, 2010-2-12, 643, 1);

INSERT INTO employee (first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_data, citizenship_code, is_identified_code, office_id, doc_code, version)  
VALUES ('Вера', 'Тушканова', 'Александровна', 'Администратор', 230948, 21, 4310987567, 2008-05-02, 643, 1);

INSERT INTO employee (first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_data, citizenship_code, is_identified_code, office_id, doc_code, version)  
VALUES ('Андрей', 'Иконников', 'Валерьевич', 'Специалист ОПП', 976354, 21, 7634187625,2012-06-12, 643, 1);

INSERT INTO employee (first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_data, citizenship_code, is_identified_code, office_id, doc_code, version)  
VALUES ('Нездоймина', 'Ирина', 'Александровна', 'Кассир', 354265, 21, 909818, 2014-03-07, 643, 1);



INSERT INTO doc  (code, doc_name, version) VALUES (03, 'Свидетельство о рождении', 1);

INSERT INTO doc  (code, doc_name, versio) VALUES (07, 'Военный билет', 1);

INSERT INTO doc  (code, doc_name, versio) VALUES (10, 'Паспорт иностранного гражданина', 1);

INSERT INTO doc  (code, doc_name, versio) VALUES (21, 'Паспорт гражданина Российской Федерации', 1);


INSERT INTO country (сode, country_name, version) VALUES (643, 'Российская Федерация', 1);

INSERT INTO country (сode, country_name, version) VALUES (643, 'Российская Федерация', 1);

INSERT INTO country (сode, country_name, version) VALUES (643, 'Российская Федерация', 1);

INSERT INTO country (сode, country_name, version) VALUES (643, 'Российская Федерация', 1);
