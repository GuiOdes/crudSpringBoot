show databases;

create database springboot2;

use springboot2;

show tables;

select * from funcionario;


select distinct idade from funcionario;
select * from cargo;

SELECT A.id, A.nome, B.nome as nomeCargo FROM funcionario A INNER JOIN cargo B WHERE B.id = A.cargo_id ORDER BY id ASC;

SELECT funcionario.id, funcionario.nome, cargo.nome as nomeCargo FROM funcionario, cargo WHERE cargo.id = funcionario.cargo_id ORDER BY id ASC;

desc cargos;