drop database if exists bdEx02;
create database if not exists bdEx02;
use bdEx02;
create table Pais (
  id     int auto_increment,
  nome   varchar(100),
  populacao   bigint,
  area	numeric(15,2),
  primary key (id)
);

insert into Pais(nome,populacao, area) 
				 values('Brasil',207000000,8516000.00),
					   ('Japao',127000000,377962.00),
					   ('Russia',144300000,17100000.00),
                       ('Argentina',43850000,2780000.00),
                       ('Chile',17910000,756102.00),
                       ('Alemanha',82670000,357376.00),
                       ('Canada',36290000,9985000.00),
                       ('Dinamarca',5731000,43560.00),
                       ('Islandia',103000,103000.00),
                       ('Espanha',46560000,505990.00);
select nome, populacao from Pais
		where populacao = (select max(populacao) from Pais);