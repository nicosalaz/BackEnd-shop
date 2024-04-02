CREATE DATABASE IF NOT EXISTS `equitel`;
use equitel;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `PRODUCTOS`;
DROP TABLE IF EXISTS `EMPLEADOS`;
DROP TABLE IF EXISTS `PROVEEDORES`;
DROP TABLE IF EXISTS `AUDITORIA`;
DROP TABLE IF EXISTS `VENTAS`;
DROP TABLE IF EXISTS `ROLES`;
DROP TABLE IF EXISTS `CARRITO_DE_COMPRA`;
DROP TABLE IF EXISTS `DETALLE_VENTAS`;
DROP view IF exists `DETALLE_VENTA_V`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `ROLES` (
    `ID_ROL` INTEGER NOT NULL auto_increment,
    `NOMBRE_ROL` VARCHAR(30) NOT NULL,
    `ACTIVO` BOOLEAN NOT NULL,
    PRIMARY KEY (`ID_ROL`),
    UNIQUE (`ID_ROL`, `NOMBRE_ROL`)
);

insert into ROLES (NOMBRE_ROL, ACTIVO) values ('ADMINISTRADOR', true);
insert into ROLES (NOMBRE_ROL, ACTIVO) values ('VENDEDOR', true);

CREATE TABLE `PROVEEDORES` (
    `NIT` INTEGER NOT NULL auto_increment,
    `NOMBRE` VARCHAR(100) NOT NULL,
    `DIRECCION` VARCHAR(50),
    `ACTIVO` BOOLEAN NOT NULL,
    PRIMARY KEY (`NIT`),
    UNIQUE (`NIT`)
);

insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Wordware', '6003 Eggendart Point', true);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Muxo', '7 Northfield Court', false);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Gabvine', '064 Packers Hill', true);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Flashpoint', '106 Springs Terrace', false);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Oyondu', '87 Lighthouse Bay Junction', false);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Oyonder', '7262 Manufacturers Court', true);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Fatz', '2794 Rieder Avenue', true);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Fadeo', '1363 Mifflin Center', false);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Jetwire', '7394 Almo Plaza', false);
insert into PROVEEDORES (NOMBRE, DIRECCION, ACTIVO) values ('Skinder', '45 Stoughton Alley', false);

CREATE TABLE `EMPLEADOS` (
    `ID_EMPLEADO` INTEGER NOT NULL auto_increment,
    `NOMBRE` VARCHAR(50) NOT NULL,
    `APELLIDOS` VARCHAR(100) NOT NULL,
    `USUARIO` VARCHAR(50) NOT NULL,
    `CLAVE` VARCHAR(50) NOT NULL,
    `FK_ROL` INTEGER NOT NULL,
    `ACTIVO` BOOLEAN NOT NULL,
    PRIMARY KEY (`ID_EMPLEADO`),
    FOREIGN KEY (`FK_ROL`) REFERENCES ROLES(`ID_ROL`),
    UNIQUE (`ID_EMPLEADO`, `USUARIO`)
);

insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Lawrence', 'Van der Baaren', 'lvanderbaaren0', 'pV0\%cVe', 1, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Ulises', 'Roony', 'uroony1', 'rN2}FxIQ<`w', 1, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Bordie', 'Robardey', 'brobardey2', 'eV2=Hr{/UJema', 1, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Lazaro', 'Bunch', 'lbunch3', 'gM1@t}56G', 1, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Morty', 'Holtham', 'mholtham4', 'uK9|3`S4*6Z$25', 1, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Glenden', 'Annakin', 'gannakin0', 'lL3=Sc3n', 2, true);
insert into EMPLEADOS (NOMBRE, APELLIDOS, USUARIO, CLAVE, FK_ROL, ACTIVO) values ('Erin', 'Wolsey', 'ewolsey1', 'qR1(b,cy<', 2, true);

CREATE TABLE `PRODUCTOS` (
    `ID_PRODUCTO` INTEGER NOT NULL auto_increment,
    `NOMBRE` VARCHAR(50) NOT NULL,
    `DESCRIPCION` VARCHAR(150) NOT NULL,
    `VALOR` INTEGER NOT NULL,
    `MODELO` VARCHAR(50) NOT NULL,
    `EXISTENCIA` INTEGER NOT NULL,
    `ACTIVO` BOOLEAN NOT NULL,
    `FK_PROVEEDOR` INTEGER NOT NULL,
    PRIMARY KEY (`ID_PRODUCTO`),
    FOREIGN KEY (`FK_PROVEEDOR`) REFERENCES proveedores(`NIT`),
    UNIQUE (`ID_PRODUCTO`)
);

insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Major Pharmaceuticals', 'primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut', '86000', 'Movies', '558', false, 3);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Rental/Leasing Companies', 'ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor', '24000', 'Health', '796', true, 2);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Military/Government/Technical', 'feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst', '03000', 'Electronics', '328', true, 4);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Precious Metals', 'nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo', '24000', 'Movies', '302', true, 1);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Computer peripheral equipment', 'vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris', '41000', 'Health', '352', true, 1);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Hospital/Nursing Management', 'odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet', '54000', 'Outdoors', '846', true, 3);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Real Estate Investment Trusts', 'vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', '10000', 'Garden', '694', true, 1);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('n/a', 'maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida', '02000', 'Kids', '495', true, 8);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Marine Transportation', 'nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula', '88000', 'Kids', '748', true, 8);
insert into PRODUCTOS (NOMBRE, DESCRIPCION, VALOR, MODELO, EXISTENCIA, ACTIVO, FK_PROVEEDOR) values ('Oil Refining/Marketing', 'ut erat id mauris vulputate elementum nullam varius nulla facilisi', '08000', 'Health', '679', true, 9);


CREATE TABLE `AUDITORIA` (
    `ID_AUDITORIA` INTEGER NOT NULL auto_increment,
    `SERVICIO` VARCHAR(50) NOT NULL,
    `FECHA` TIMESTAMP NOT NULL,
    `ESTADO` INTEGER NOT NULL,
    `RESPUESTA` text NOT NULL,
    PRIMARY KEY (`ID_AUDITORIA`),
    UNIQUE (`ID_AUDITORIA`)
);

CREATE TABLE `VENTAS` (
    `ID_VENTA` INTEGER NOT NULL auto_increment,
    `FK_EMPLEADO` INTEGER NOT NULL,
    `FECHA` TIMESTAMP NOT NULL,
    `TOTAL_VENTA` INTEGER NOT NULL,
    PRIMARY KEY (`ID_VENTA`),
    FOREIGN KEY (`FK_EMPLEADO`) REFERENCES empleados(`ID_EMPLEADO`),
    UNIQUE (`ID_VENTA`)
);


CREATE TABLE `CARRITO_DE_COMPRA` (
    `ID_CARRITO` INTEGER NOT NULL auto_increment,
    `FK_PRODUCTO` INTEGER NOT NULL,
    `PRECIO` INTEGER NOT NULL,
    `CANTIDAD` INTEGER NOT NULL,
    `ACTIVO` BOOLEAN NOT NULL,
    `FK_EMPLEADO` INTEGER NOT NULL,
    PRIMARY KEY (`ID_CARRITO`),
    FOREIGN KEY (`FK_PRODUCTO`) REFERENCES PRODUCTOS(`ID_PRODUCTO`),
    FOREIGN KEY (`FK_EMPLEADO`) REFERENCES empleados(`ID_EMPLEADO`)
);

CREATE TABLE `DETALLE_VENTAS` (
    `ID_DETALLE` INTEGER NOT NULL auto_increment,
    `CANTIDAD_PRODUCTO` INTEGER NOT NULL,
    `FK_PRODUCTO` INTEGER NOT NULL,
    `PRECIO` INTEGER NOT NULL,
    `FK_VENTA` INTEGER NOT NULL,
    PRIMARY KEY (`ID_DETALLE`),
    FOREIGN KEY (`FK_PRODUCTO`) REFERENCES PRODUCTOS(`ID_PRODUCTO`),
    FOREIGN KEY (`FK_VENTA`) REFERENCES ventas(`ID_VENTA`)
);
use equitel;
CREATE VIEW DETALLE_VENTA_V AS
SELECT v.ID_VENTA,v.FECHA,v.FK_EMPLEADO,emp.NOMBRE as NOMBRE_EMPLEADO,
dv.FK_PRODUCTO,prd.NOMBRE,dv.CANTIDAD_PRODUCTO,dv.ID_DETALLE,dv.PRECIO
FROM equitel.ventas as v
inner join equitel.detalle_ventas as dv on (dv.FK_VENTA = v.ID_VENTA)
inner join equitel.empleados as emp on (emp.ID_EMPLEADO = v.FK_EMPLEADO)
inner join equitel.productos as prd on (prd.ID_PRODUCTO = dv.FK_PRODUCTO)