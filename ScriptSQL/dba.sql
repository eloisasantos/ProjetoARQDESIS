CREATE DATABASE dba;
 
 use dba;
 
 create table empresa (
   id BIGINT NOT NULL AUTO_INCREMENT,
   cnpj VARCHAR(255),
   razaSocial VARCHAR(255),
   conjunto VARCHAR(255),
   horarioDeFuncionameto VARCHAR(255),
   valorTemperatura VARCHAR(255),
   horarioArCondicionado VARCHAR(255),
   primary key (id)
 );
 
 create table usuario (
   id BIGINT NOT NULL AUTO_INCREMENT,
   nome VARCHAR(255),
   cpf VARCHAR(255),
   login VARCHAR(255),
   senha VARCHAR(255),
   tipo VARCHAR(255),
   primary key (id)
   
 );
 
 select * from usuario;