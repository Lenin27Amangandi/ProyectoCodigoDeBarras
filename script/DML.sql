--database:../database/Database.sqlite


INSERT INTO Usuario
( Nombre             , Apellido                              , Cedula      )VALUES
('Martin'               ,'Davalos'                             ,'1750111211' ),
('Juan'                 ,'Perez'                               ,'1750111212' ),
('Maria'                ,'Rodriguez'                           ,'1750111213' ),
('Pedro'                ,'Gonzalez'                            ,'1750111214' ),
('Ana'                  ,'Garcia'                              ,'1750111215' );

INSERT INTO AdminCredencial
(idUsuario             ,Usuario                            ,Contrasena)VALUES
(1                      ,'MartinDavalos'                     ,'Amodellaves' ),
(2                      ,'JuanPerez'                          ,'Juan2344' ),
(3                      ,'MariaRodriguez'                     ,'3872Ana' ),
(4                      ,'PedroGonzalez'                       ,'JulioCortazarr23' ),
(5                      ,'AnaGarcia'                           ,'AnitaGarciaG' );
INSERT INTO Producto
(NombreProducto,               Precio,               Descripcion,               CodigoDeBarras,               Stock)VALUES 
('Producto 1',                 19.99,                'Descripción del producto 1', '1234567890',              10),
('Producto 2',                 29.99,                'Descripción del producto 1', '9876543210',              5),
('Producto 3',                 39.99,                'Descripción del producto 1',  '1111111111',              15);

INSERT INTO RegistroProducto
( idProducto     )Values
(1)
,(2)
,(3);