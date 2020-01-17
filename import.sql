create database empleados;

use empleados;

create table usuario(
	id int primary key IDENTITY not null,
	nombre_usuario varchar(50) not null,
	contrasena varchar(50) not null,
);

insert into usuario (nombre_usuario, contrasena) values ('admin', 'admin');

create table empleado(
	id int primary key IDENTITY not null,
	nombre varchar(300) not null,
	identificacion varchar(50) unique not null,
	fecha_integracion datetime default getDate(),
	fecha_entrada datetime default getDate(),
	cargo varchar(80) not null,
	dni varchar(15) unique not null,
	activo bit default 1
);

create table actividad( 
	id int primary key IDENTITY not null,
	fecha_integracion datetime default getDate(),
	fecha_entrada datetime default getDate(),
	fecha_salida datetime default getDate(),
	empleado int not null,
	foreign key(empleado) references empleado(id),
	trabajado bit default 1
);

create table pago(
	id int primary key IDENTITY not null,
	fecha_pago datetime default getDate(),
	empleado int not null,
	foreign key(empleado) references empleado(id),
	monto decimal(11),
	cargos decimal(11)
);