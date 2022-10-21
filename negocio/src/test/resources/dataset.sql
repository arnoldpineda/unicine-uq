insert into cliente values (1, "pepe@gmail.com", "345g5", "123123", 1, "Pepe", "rutafoto");
insert into cliente values (2, "juan@gmail.com", "2s465", "123124", 1, "Juan", "rutafoto");
insert into cliente values (3, "luis@gmail.com", "s12sd", "123125", 0, "Luis", "rutafoto");
insert into cliente values (4, "maria@gmail.com", "542c", "123126", 1, "Maria", "rutafoto");
insert into cliente values (5, "luisa@gmail.com", "34s5d", "123127", 1, "Luisa", "rutafoto");

insert into cliente_telefonos values (1, "832737373");
insert into cliente_telefonos values (1, "398398322");
insert into cliente_telefonos values (2, "3435435345");
insert into cliente_telefonos values (3, "534334333");

insert into confiteria values (1, "Crispetas", 15000, "rutaFoto");
insert into confiteria values (2, "Perro", 14000, "rutaFoto");
insert into confiteria values (3, "Gaseosa", 10000, "rutaFoto");
insert into confiteria values (4, "Combo kids", 20000, "rutaFoto");
insert into confiteria values (5, "Combo familiar", 25000, "rutaFoto");

insert into cupon values (1, "Registro", "Cupon", 15, "2022-10-30T15:50:05.609");
insert into cupon values (2, "Compra", "Cupon", 10, "2022-10-30T15:50:05.609");
insert into cupon values (3, "Registro", "Cupon", 15, "2022-10-30T15:50:05.609");
insert into cupon values (4, "Cumpleaños", "Cupon", 05, "2022-10-30T15:50:05.609");
insert into cupon values (5, "Registro", "Cupon", 10, "2022-10-30T15:50:05.609");

insert into cupon_cliente values (1, 1, 1, 1);
insert into cupon_cliente values (2, 0, 1, 2);
insert into cupon_cliente values (3, 1, 2, 3);
insert into cupon_cliente values (4, 0, 3, 4);
insert into cupon_cliente values (5, 1, 4, 5);