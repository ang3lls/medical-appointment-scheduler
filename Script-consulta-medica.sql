drop database if exists microservico_cadastro_consulta_medica;
create database microservico_cadastro_consulta_medica;
use microservico_cadastro_consulta_medica;

create table consulta(
	id_consulta int not null auto_increment,
	id_medico int,
	id_paciente int,
	data_consulta date,
	hora_consulta time,
    primary key(id_consulta)
);

drop database if exists microservico_cadastro_paciente;
create database microservico_cadastro_paciente;
use microservico_cadastro_paciente;

create table paciente(
	id_paciente int not null auto_increment,
	nome varchar(60),
	idade int,
	cpf varchar(15),
	primary key(id_paciente)
);

drop database if exists microservico_cadastro_medico;
create database microservico_cadastro_medico;
use microservico_cadastro_medico;

create table medico(
	id_medico int not null auto_increment,
	nome varchar(60),
	primary key(id_medico)
);

drop database if exists microservico_cadastro_especialidade;
create database microservico_cadastro_especialidade;
use microservico_cadastro_especialidade;

create table especialidades(
	id_especialidade int not null,
	descricao varchar(80),
	primary key(id_especialidade)
);

drop database if exists microservico_especialidademedico;
create database microservico_especialidademedico;
use microservico_especialidademedico;

create table especialidademedico(
	id_medico int not null,
	id_especialidade int not null,
	descricao varchar(80)
);

	
	
	