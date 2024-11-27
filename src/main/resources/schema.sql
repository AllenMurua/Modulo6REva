drop table if exists alumno_materia cascade ;
drop table if exists alumno cascade ;
drop table if exists materia cascade ;
drop table if exists user_table cascade ;
-- Create Alumno
CREATE TABLE if not exists user_table (
                                          id BIGSERIAL PRIMARY KEY,
                                          name VARCHAR(100) NOT NULL,
                                          username VARCHAR(50) UNIQUE NOT NULL,
                                          email VARCHAR(100) UNIQUE NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          rut VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE if not exists user_roles (
                                          user_id BIGINT,
                                          role VARCHAR(50),
                                          PRIMARY KEY (user_id, role),
                                          CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user_table(id) ON DELETE CASCADE
);
-- Create Materia
CREATE TABLE if not exists materia (
                         id BIGSERIAL PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         codigo VARCHAR(20) UNIQUE
);

-- Create Alumno-Materia
CREATE TABLE if not exists alumno (

                                      id BIGSERIAL PRIMARY KEY,
                                      rut_alumno VARCHAR(20) NOT NULL UNIQUE,
                                      nombre_alumno VARCHAR(100) NOT NULL,
                                      direccion VARCHAR(255),
                                      user_id BIGINT,
                                      CONSTRAINT fk_user_alumno FOREIGN KEY (user_id) REFERENCES user_table(id) ON DELETE CASCADE
);

--User Table
CREATE TABLE if not exists alumno_materia (
                                alumno_id BIGINT,
                                materia_id BIGINT,
                                PRIMARY KEY (alumno_id, materia_id),
                                CONSTRAINT fk_alumno FOREIGN KEY (alumno_id) REFERENCES alumno(id) ON DELETE CASCADE,
                                CONSTRAINT fk_materia FOREIGN KEY (materia_id) REFERENCES materia(id) ON DELETE CASCADE
);
