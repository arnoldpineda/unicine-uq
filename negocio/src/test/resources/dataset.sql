insert into cliente values (1, "pepe@gmail.com", "Pepe", "345g5", "123123", 1, "rutafoto");
insert into cliente values (2, "juan@gmail.com", "Juan", "2s465", "123124", 1, "rutafoto");
insert into cliente values (3, "luis@gmail.com",  "Luis", "s12sd", "123125", 0, "rutafoto");
insert into cliente values (4, "maria@gmail.com", "Maria", "542c", "123126", 1, "rutafoto");
insert into cliente values (5, "luisa@gmail.com", "Luisa", "34s5d", "123127", 1, "rutafoto");

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

insert into ciudad values (1, "Bogota");
insert into ciudad values (2, "Medellin");
insert into ciudad values (3, "Pereira");
insert into ciudad values (4, "Armenia");
insert into ciudad values (5, "Cali");

insert into administrador values (1, "adminPlataforma@email.com", "AdminPlataforma", "54s21d");

insert into administrador_teatro values (1, "admin1@email.com", "Admin1", "54s21d");
insert into administrador_teatro values (2, "admin2@email.com", "Admin2", "645sf");
insert into administrador_teatro values (3, "admin3@email.com", "Admin3", "324sdf");
insert into administrador_teatro values (4, "admin4@email.com", "Admin4", "af4s56");
insert into administrador_teatro values (5, "admin5@email.com", "Admin5", "dg31d6");

insert into teatro values (1, "CC Unicentro loc 13", "Unicentro", "7415632", 5, 1);
insert into teatro values (2, "Calle 53 12 No.3", "El parque", "7415632", 4, 2);
insert into teatro values (3, "CC Calima loc 8", "Calima", "7415632", 3, 3);
insert into teatro values (4, "CC Portal del Quindío loc 1", "Portal del Quindío", "7415632", 2, 4);
insert into teatro values (5, "Cra 15 No. 12-26 local 3", "Calle Real", "7415632", 1, 5);

insert into pelicula values (1, 1, "CIENCIA_FICCION", "El señor de los anillos", "reparto", "sinopsis", "imagen", "trailer");
insert into pelicula values (2, 1, "COMEDIA", "Usted no sabe quien soy yo", "reparto", "sinopsis", "imagen", "trailer");
insert into pelicula values (3, 1, "TERROR", "Hallowen", "reparto", "sinopsis", "imagen", "trailer");
insert into pelicula values (4, 0, "ANIMADA", "Super mascotas", "reparto", "sinopsis", "imagen", "trailer");
insert into pelicula values (5, 0, "ACCION", "Pantera negra", "reparto", "sinopsis", "imagen", "trailer");

insert into horario values (1, 1, "2022-11-30", "2022-10-30", "13:00");
insert into horario values (2, 1, "2022-11-30", "2022-10-30", "15:00");
insert into horario values (3, 2, "2022-11-30", "2022-10-30", "17:00");
insert into horario values (4, 4, "2022-11-30", "2022-10-30", "19:00");
insert into horario values (5, 3, "2022-11-30", "2022-10-30", "21:00");

insert into distribuccion_sillas values (1, 5, "esquema", 10, 50);
insert into distribuccion_sillas values (2, 5, "esquema", 15, 75);
insert into distribuccion_sillas values (3, 8, "esquema", 10, 80);
insert into distribuccion_sillas values (4, 5, "esquema", 15, 75);
insert into distribuccion_sillas values (5, 5, "esquema", 10, 50);

insert into sala values (1, "sala 1", 4, 3);
insert into sala values (2, "sala 1", 2, 5);
insert into sala values (3, "sala 2", 3, 2);
insert into sala values (4, "sala 3", 1, 4);
insert into sala values (5, "sala xd", 5, 1);

insert into funcion values (1, 5000, 1, 1, 1);
insert into funcion values (2, 5000, 3, 2, 2);
insert into funcion values (3, 5000, 1, 3, 3);
insert into funcion values (4, 5000, 4, 4, 4);
insert into funcion values (5, 5000, 1, 5, 5);

insert into compra values (1, "2022-10-30", "VISA", 0, 1, null, 1);
insert into compra values (2, "2022-11-30", "DAVIPLATA", 0, 1, null, 1);
insert into compra values (3, "2022-10-30", "NEQUI", 0, 1, null, 2);
insert into compra values (4, "2022-11-30", "MASTERCARD", 0, 1, null, 3);
insert into compra values (5, "2022-10-30", "VISA", 0, 1, 3, 1);

insert into compra_confiteria values (1, 0, 2, 1, 5);
insert into compra_confiteria values (2, 0, 1, 1, 3);
insert into compra_confiteria values (3, 0, 1, 2, 1);
insert into compra_confiteria values (4, 0, 2, 3, 2);
insert into compra_confiteria values (5, 0, 3, 4, 1);

insert into entrada values (1, 1, 1, 5000, 1);
insert into entrada values (2, 2, 1, 5000, 1);
insert into entrada values (3, 5, 3, 5000, 2);
insert into entrada values (4, 2, 3, 5000, 3);
insert into entrada values (5, 1, 4, 8000, 4);
