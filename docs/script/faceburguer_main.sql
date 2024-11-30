create database faceburguer;
use faceburguer;

create table usuario(
id_usuario int primary key auto_increment,
nome_usuario varchar(50)
);

create table mensagem(
ID_MENSAGEM INT PRIMARY KEY AUTO_INCREMENT,
MENSAGEM VARCHAR(255),

FK_ID_USUARIO INT,
FOREIGN KEY (FK_ID_USUARIO) REFERENCES USUARIO(ID_USUARIO) ON DELETE CASCADE
);