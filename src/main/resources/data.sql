insert into cat_property(id, property) values(1, 'JDBC Connection URL');
insert into cat_property(id, property) values(2, 'User name');
insert into cat_property(id, property) values(3, 'password');
insert into cat_property(id, property) values(4, 'IP-Hostname');
insert into cat_property(id, property) values(5, 'Puerto');
insert into cat_property(id, property) values(6, 'Nombre Base de datos');

insert into cat_tipo_conector(id, conector) values(1, 'FTP');
insert into cat_tipo_conector(id, conector) values(2, 'JDBC');

insert into cat_estatus(id, estatus) values(1, 'Creado');
insert into cat_estatus(id, estatus) values(2, 'Iniciado');
insert into cat_estatus(id, estatus) values(3, 'Terminado');
insert into cat_estatus(id, estatus) values(4, 'Error');

insert into cat_accion(id, accion) values(1, 'Extraccion');
insert into cat_accion(id, accion) values(2, 'Mapear');
insert into cat_accion(id, accion) values(3, 'Depositar');
