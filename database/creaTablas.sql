

CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,       
    usuario VARCHAR(50) NOT NULL, 
    contrasena VARCHAR(255) NOT NULL, 
    estado BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Persona (
    id SERIAL PRIMARY KEY,              
    nombres VARCHAR(100) NOT NULL,      
    apellidos VARCHAR(100) NOT NULL,    
    sexo CHAR(1) NOT NULL,              
    pais VARCHAR(50) NOT NULL,          
    direccion VARCHAR(255),             
    usuario_id INT UNIQUE,              
    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES Usuario(id)
        ON DELETE CASCADE  
);

CREATE TABLE Publicacion (
    id SERIAL PRIMARY KEY,              
    cuerpo TEXT NOT NULL,               
    persona_id INT,                     
    CONSTRAINT fk_persona
        FOREIGN KEY (persona_id)
        REFERENCES Persona(id)
        ON DELETE CASCADE 
);

CREATE TABLE Rol (
    id SERIAL PRIMARY KEY,            
    tipo VARCHAR(50) NOT NULL         
);

CREATE TABLE Usuario_Rol (
	id SERIAL,
    usuario_id INT,                      
    rol_id INT,                          
    PRIMARY KEY (usuario_id, rol_id),    
    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES Usuario(id)
        ON DELETE CASCADE,           
    CONSTRAINT fk_rol
        FOREIGN KEY (rol_id)
        REFERENCES Rol(id)
        ON DELETE CASCADE 
);

