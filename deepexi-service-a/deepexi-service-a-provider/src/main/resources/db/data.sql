DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product(id varchar(32) unsigned not null primary key,name varchar(32),price int,tenant_id varchar(32),created_by varchar(32),updated_by varchar(32),created_at date,updated_at date, dr int(1));

INSERT INTO product(id, name, price, tenant_id, created_by, updated_by, created_at, updated_at, dr) VALUES ('1', '苹果', 20, null, null, null, null, null, 0),
('2', '梨', 10, null, null ,null, null, null, 0),
('3', '桃子', 123, null, null ,null, null, null, 0),
('4', '香蕉', 11, null, null ,null, null, null, 0),
('5', '猕猴桃', 50, null, null ,null, null, null, 0),
('6', '桔子', 33, null, null ,null, null, null, 0),
('7', '菠萝', 90, null, null ,null, null, null, 0),
('8', '芒果', 766, null, null ,null, null, null, 0),
('9', '红枣', 29, null, null ,null, null, null, 0),
('10', '榴莲', 990, null, null ,null, null, null, 0),
('11', '柚子', 291, null, null ,null, null, null, 0),
('12', '小番茄', 200, null, null ,null, null, null, 0);

DROP TABLE IF EXISTS component;

CREATE TABLE IF NOT EXISTS component(id varchar(32) unsigned not null primary key,name varchar(32),type varchar(30),version varchar(10),status varchar(20),tenant_id varchar(32),created_by varchar(32),updated_by varchar(32),created_at date,updated_at date, dr int(1));
CREATE index idx_name ON component(name);
INSERT INTO component(id, name,type, version, status,tenant_id, created_by, updated_by, created_at, updated_at, dr) VALUES
('1', 'Mysql','基础设施','v1.0.0','上架', null, null, null, null, null, 0),
('2', 'sonar', '基础设施','v1.0.0','上架', null, null ,null, null, null, 0),
('3', 'spring boot', '集成框架','v1.0.0','上架', null, null ,null, null, null, 0)