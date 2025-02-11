-- Tabla de usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

-- Tabla de cursos
CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) UNIQUE NOT NULL,
    profesor_id INT REFERENCES usuarios(id)
);

-- Tabla de módulos
CREATE TABLE modulos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    curso_id INT REFERENCES cursos(id)
);

-- Tabla de inscripciones
CREATE TABLE inscripciones (
    id SERIAL PRIMARY KEY,
    curso_id INT REFERENCES cursos(id),
    estudiante_id INT REFERENCES usuarios(id)
);

-- Tabla de foros
CREATE TABLE foros (
    id SERIAL PRIMARY KEY,
    contenido TEXT NOT NULL,
    autor_id INT REFERENCES usuarios(id),
    curso_id INT REFERENCES cursos(id),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


