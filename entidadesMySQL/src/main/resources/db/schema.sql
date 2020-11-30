CREATE DATABASE IF NOT EXISTS practica;

ALTER DATABASE practica
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE practica;

CREATE TABLE IF NOT EXISTS clientes (
  id VARCHAR(4)  NOT NULL primary key,
  provincia VARCHAR(30),
  nombre VARCHAR(30),
  estado VARCHAR(30),
  id_direccion VARCHAR(4),
  FOREIGN KEY (id_direccion) references direcciones(id),
  UNIQUE (id_direccion),
  INDEX(nombre)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS direcciones (
   id VARCHAR(4)  NOT NULL primary key,
  nombre_direccion VARCHAR(80),
  INDEX(nombre_direccion)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visitas (
   id VARCHAR(4)  NOT NULL primary key,
  importe FLOAT(2) UNSIGNED NOT NULL,
  id_cliente VARCHAR(30),
  FOREIGN KEY (id_cliente) references clientes(id),
  UNIQUE (id_cliente)
) engine=InnoDB;
