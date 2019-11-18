CREATE TABLE IF NOT EXISTS country (
   id      INTEGER                                          PRIMARY KEY AUTO_INCREMENT,
   name    VARCHAR(50)                                      COMMENT 'Название страны',
   version INTEGER              NOT NULL                    COMMENT 'Служебное поле hibernate',
   code    INTEGER                                          COMMENT 'Уникальный код страны'
);
COMMENT ON TABLE country IS 'Страна';

CREATE TABLE IF NOT EXISTS document (
   id          INTEGER          NOT NULL                    PRIMARY KEY AUTO_INCREMENT ,
   name        VARCHAR(50)      NOT NULL                    COMMENT 'Название документа',
   version     INTEGER          NOT NULL                    COMMENT 'Служебное поле hibernate',
   code        INTEGER                                      COMMENT 'Уникальный код документа',
   country_id  INTEGER                                      COMMENT 'Уникальный код документа',
   document    INTEGER                                      COMMENT 'Уникальный код документа'
);
COMMENT ON TABLE document IS 'Документ';
CREATE INDEX IX_document_ibfk_1 ON document(name);

CREATE TABLE IF NOT EXISTS document_type (
   id          INTEGER          NOT NULL                    PRIMARY KEY AUTO_INCREMENT ,
   doc_name    VARCHAR(50)                                  COMMENT 'Название документа',
   doc_number  INTEGER                                      COMMENT 'Уникальный идентификатор документа',
   doc_data    VARCHAR(100)                                 COMMENT 'Дата выдачи документа',
   version     INTEGER          NOT NULL                    COMMENT 'Служебное поле hibernate',
   document_id INTEGER                                      COMMENT 'Уникальный код документа'
);
COMMENT ON TABLE document_type IS 'Документ_тип';
CREATE INDEX IX_document_type_ibfk_1 ON document_type(doc_name);

CREATE TABLE IF NOT EXISTS employee (
   id             INTEGER       NOT NULL                    PRIMARY KEY AUTO_INCREMENT  ,
   first_name     VARCHAR(50)                               COMMENT 'Имя',
   second_name    VARCHAR(50)                               COMMENT 'Фамилия',
   middle_name    VARCHAR(50)                               COMMENT 'Отчество',
   position       VARCHAR(50)                               COMMENT 'Должность',
   phone          VARCHAR(100)                              COMMENT 'Телефон',
   is_identified  BOOLEAN                                   COMMENT 'Работающий или не работающий, если работающий - true',
   country_id     INTEGER                                   COMMENT 'Уникальный идентификатор страны' ,
   document_id    INTEGER                                   COMMENT 'Номер документа' ,
   version        INTEGER        NOT NULL                   COMMENT 'Служебное поле hibernate'

);
COMMENT ON TABLE employee IS 'Сотрудник';

CREATE TABLE IF NOT EXISTS organization (
  id             INTEGER         NOT NULL                   PRIMARY KEY AUTO_INCREMENT    ,
  name           VARCHAR(50)     NOT NULL                   COMMENT 'Сокращенное название',
  full_name      VARCHAR(50)                                COMMENT 'Полное название',
  inn            INTEGER                                    COMMENT 'Идентификационный номер налогоплательщика',
  kpp            INTEGER                                    COMMENT 'Код причины постановки на учет в налоговых органах',
  address        VARCHAR(50)                                COMMENT 'Регистрационный адрес',
  phone          INTEGER                                    COMMENT 'Номер телефона',
  is_active      BOOLEAN                                    COMMENT 'Действующая организация, если действует - true',
  version        INTEGER         NOT NULL                   COMMENT 'Служебное поле hibernate'
);
COMMENT ON TABLE organization IS 'Организация';

CREATE TABLE IF NOT EXISTS office (
  id               INTEGER       NOT NULL                   PRIMARY KEY AUTO_INCREMENT  ,
  first_name       VARCHAR(50)                              COMMENT 'Название',
  address          VARCHAR(50)                              COMMENT 'Регистрационный адрес',
  phone            INTEGER                                  COMMENT 'Номер телефона',
  is_active        BOOLEAN                                  COMMENT 'Действующий офис, если дейcтвует - true',
  version          INTEGER        NOT NULL                  COMMENT 'Служебное поле hibernate',
  organization_id  INTEGER                                  COMMENT 'Идентификацонный номер организации'
);
COMMENT ON TABLE office IS 'Офис';


CREATE TABLE IF NOT EXISTS Employee_Office (
   employee_id    INTEGER     NOT NULL      COMMENT 'Уникальный идентификатор сотрудника',
   office_id      INTEGER     NOT NULL      COMMENT 'Уникальный идентификатор офиса'
);
COMMENT ON TABLE Employee_Office IS 'join-таблица для связи сотрудника и офиса';

CREATE INDEX IX_employee_office_ibfk_1 ON Employee_Office (employee_id);
ALTER TABLE Employee_Office ADD FOREIGN KEY (employee_id) REFERENCES employee(id);

CREATE INDEX IX_employee_office_ibfk_2 ON Employee_Office(office_id);
ALTER TABLE Employee_Office ADD FOREIGN KEY (office_id) REFERENCES office(id);

CREATE TABLE IF NOT EXISTS Office_Organization (
   organization_id    INTEGER     NOT NULL      COMMENT 'Уникальный идентификатор организации',
   office_id          INTEGER     NOT NULL      COMMENT 'Уникальный идентификатор офиса'
);
COMMENT ON TABLE Office_Organization IS 'join-таблица для связи офиса и организации';

CREATE INDEX IX_office_organization_ibfk_1 ON Office_Organization (organization_id);
ALTER TABLE Office_Organization ADD FOREIGN KEY (organization_id) REFERENCES organization(id);

CREATE INDEX IX_office_organization_ibfk_2 ON Office_Organization(office_id);
ALTER TABLE Office_Organization ADD FOREIGN KEY (office_id) REFERENCES office(id);






