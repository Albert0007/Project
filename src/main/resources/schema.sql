-- Организация
CREATE TABLE IF NOT EXISTS organization
(
  id        INTEGER      NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name      VARCHAR(100) NOT NULL                COMMENT 'Сокращенное название',
  full_name VARCHAR(100) NOT NULL                COMMENT 'Полное название',
  inn       INTEGER(50)  NOT NULL                COMMENT 'Идентификационный номер налогоплательщика',
  kpp       INTEGER(50)  NOT NULL                COMMENT 'Код причины постановки на учет в налоговых органах',
  address   VARCHAR(100) NOT NULL                COMMENT 'Регистрационный адрес',
  phone     INTEGER(100)                         COMMENT 'Номер телефона',
  is_active BOOLEAN      DEFAULT FALSE           COMMENT 'Действующая организация, если дейтвует - true',
  version   INTEGER      NOT NULL                COMMENT 'Служебное поле hibernate',

  CONSTRAINT PK_ORGANIZATION_ID PRIMARY KEY (ID)
);

-- CREATE INDEX IX_ORGANIZATION_NAME  ON organization(name);


-- -------------------------------------------------------------------------------------------
-- подразделение организации
CREATE TABLE IF NOT EXISTS office
(
  id                INTEGER      NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  name              VARCHAR(100) NOT NULL                COMMENT 'Название',
  address           VARCHAR(100) NOT NULL                COMMENT 'Регистрационный адрес',
  phone             INTEGER(50)                          COMMENT 'Номер телефона',
  is_active         BOOLEAN      DEFAULT FALSE           COMMENT 'Действующее подразделение, если дейтвует - true',
  organization_id   INTEGER                              COMMENT 'Уникальный идентификатор организации',
  version           INTEGER      NOT NULL                COMMENT 'Служебное поле hibernate',

  CONSTRAINT PK_OFFICE_ID PRIMARY KEY (id)
);


-- --------------------------------------------------------------------------------------------------
-- сотрудник
CREATE TABLE IF NOT EXISTS employee
(
  id                 INTEGER      NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  first_name         VARCHAR(100) NOT NULL                COMMENT 'Имя',
  second_name        VARCHAR(100)                         COMMENT 'Фамилия',
  middle_name        VARCHAR(100)                         COMMENT 'Отчество',
  position           VARCHAR(100) NOT NULL                COMMENT 'Должность',
  phone              INTEGER(50)                          COMMENT 'Телефон',
  is_identified      BOOLEAN      DEFAULT FALSE           COMMENT 'Работающий или не работающий, если работающий - true',
  country_id         INTEGER                              COMMENT 'Уникальный идентификатор страны',
  document_id        INTEGER                              COMMENT 'Уникальный идентификатор документа',
    version            INTEGER      NOT NULL                COMMENT 'Служебное поле hibernate',
    

  CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY (id)
);


-- --------------------------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------------------------
-- join-таблица для связи сотрудник - подразделение
CREATE TABLE IF NOT EXISTS employee_office
(
  employee_id INTEGER COMMENT 'Уникальный идентификатор сотрудниа',
  office_id   INTEGER COMMENT 'Уникальный идентификатор офиса',

  CONSTRAINT PK_EMPLOYEE_OFFICE PRIMARY KEY (employee_id, office_id)
);





CREATE TABLE IF NOT EXISTS country
(
  id      INTEGER     NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  code    VARCHAR(50) NOT NULL                COMMENT 'Цифровой код страны по ISO 3166-1',
  name    VARCHAR(100)NOT NULL                COMMENT 'Название страны',
  version INTEGER     NOT NULL                COMMENT 'Служебное поле hibernate',

  CONSTRAINT PK_COUNTRIES_CATALG_ID PRIMARY KEY (id)
);


-- ------------------------------------------------------------------------------------------------------
-- справочник видов документов, удостоверяющих личность физического лица
CREATE TABLE IF NOT EXISTS document
(
  id      INTEGER      NOT NULL AUTO_INCREMENT COMMENT 'Уникальный идентификатор',
  code    VARCHAR(100) NOT NULL                COMMENT 'Код документа',
  name    VARCHAR(100) NOT NULL                COMMENT 'Наименование документа',
  version INTEGER      NOT NULL                COMMENT 'Служебное поле hibernate',
    

  CONSTRAINT PK_IDENTIFICATION_DOCUMENT_CATALOG_ID PRIMARY KEY (id)
);


