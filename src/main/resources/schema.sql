DROP TABLE IF EXISTS usuario;  
DROP TABLE IF EXISTS produto;  


create table usuarios (
  usr_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  usr_nome VARCHAR(20) NOT NULL UNIQUE,
  usr_senha VARCHAR(150) NOT NULL,
  usr_cargo VARCHAR(20) CHECK (usr_cargo IN ('ADMIN', 'USER')) NOT NULL
);


create table produtos (
  pro_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  pro_nome VARCHAR(20) NOT NULL,
  pro_valor NUMERIC(10,2) NOT NULL
);