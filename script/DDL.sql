-- database: ../database/Database.sqlite

-- Eliminar tablas existentes
DROP TABLE IF EXISTS AdminCredencial;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Producto;
DROP TABLE IF EXISTS RegistroProducto;
CREATE TABLE Usuario (
    idUsuario           INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre              VARCHAR(50) NOT NULL,
    Apellido            VARCHAR(50) NOT NULL,
    Cedula              VARCHAR (10) NOT NULL UNIQUE,
    FechaCreacion       DATETIME DEFAULT (datetime('now', 'localtime')),
    FechaModifica       DATETIME DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE AdminCredencial (
        idAdminCredencial        INTEGER PRIMARY KEY AUTOINCREMENT,
        idUsuario                INTEGER NOT NULL,
        Usuario                  VARCHAR (50) NOT NULL UNIQUE,
        Contrasena              VARCHAR (50) NOT NULL ,
        FechaCreacion            DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica            DATETIME DEFAULT (datetime('now', 'localtime')),
        CONSTRAINT               fk_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)                
        
    );

CREATE TABLE Producto (
    idProducto             INTEGER  PRIMARY KEY AUTOINCREMENT,
    NombreProducto         VARCHAR(50) NOT NULL,
    Precio                 DECIMAL(10,2) NOT NULL,
    Descripcion            VARCHAR (100) NOT NULL,
    CodigoDeBarras         VARCHAR (13) NOT NULL,
    Stock                  INT NOT NULL,
    FechaCreacion          DATETIME DEFAULT (datetime('now', 'localtime')),
    FechaModifica          DATETIME DEFAULT (datetime('now', 'localtime'))
);

CREATE TABLE RegistroProducto (
    idRegistroProducto           INTEGER PRIMARY KEY AUTOINCREMENT,
    idProducto                  INTEGER NOT NULL REFERENCES Producto (idProducto),
    FechaCreacion               DATETIME DEFAULT (datetime('now','localtime'))
);
