INSERT INTO organization (id, name, full_name, inn, kpp, address, phone) VALUES (1, 'ООО', 'ТАНДЕР', 12, 133, 'Исаева, 2', '252525');

INSERT INTO organization (id, name, full_name, inn, kpp, address, phone) VALUES (2, 'ОАО', 'Х5', 17, 127, 'Ленина, 80', '909090');

INSERT INTO office (id, name, address, phone, organization_id) VALUES (1, 'Магнит', 'ул.Лунина, 7', 2525251, 1);

INSERT INTO office (id, name, address, phone, organization_id) VALUES (2, 'Пятерочка', 'Затонная, 20', 9090901, 2);

INSERT INTO employee (id, version, first_name, second_name, middle_name, position, phone, country_id, document_id) VALUES (1, 1, 'Иван', 'Иванов', 'Сергеевич', 'Продавец', 656565 );

INSERT INTO employee (id, version, first_name, second_name, middle_name, position, phone, country_id, document_id) VALUES (1, 1, 'Иван', 'Иванов', 'Сергеевич', 'Продавец', 656565);

INSERT INTO employee_office (employee_id, office_id) VALUES (1, 1);

INSERT INTO employee_office (employee_id, office_id) VALUES (2, 2);

INSERT INTO country (id) VALUES (1);

INSERT INTO country (id) VALUES (1);

INSERT INTO document (id) VALUES (1);

INSERT INTO document (id) VALUES (1);
