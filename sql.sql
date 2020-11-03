DROP DATABASE IF EXISTS sa_salesinventory_hmlg;
CREATE DATABASE sa_salesinventory_hmlg;

USE sa_salesinventory_hmlg;

INSERT INTO role(name) VALUES('ROLE_SALLESMAN');
INSERT INTO role(name) VALUES('ROLE_MANAGER');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

select * from user;
select * from user_role;
select * from produto;
select * from momento_estoque;
select * from movimento_estoque_item;
select * from role;
select * from fornecedor;
