

-- Insert Sample Alumnos (15 records)
INSERT INTO materia (nombre, codigo) VALUES
                                         ('Matemáticas Avanzadas', 'MAT-101'),
                                         ('Física Cuántica', 'FIS-201'),
                                         ('Literatura Contemporánea', 'LIT-301'),
                                         ('Historia Universal', 'HIS-401'),
                                         ('Química Orgánica', 'QUI-501'),
                                         ('Biología Molecular', 'BIO-601'),
                                         ('Programación Web', 'PRG-701'),
                                         ('Diseño de Interfaces', 'DIS-801'),
                                         ('Estadística Aplicada', 'EST-901'),
                                         ('Inteligencia Artificial', 'IA-1001'),
                                         ('Economía Internacional', 'ECO-1101'),
                                         ('Derecho Corporativo', 'DER-1201'),
                                         ('Arquitectura de Software', 'ARQ-1301'),
                                         ('Redes de Computadoras', 'RED-1401'),
                                         ('Arte Contemporáneo', 'ART-1501'),
                                         ('Antropología Cultural', 'ANT-1601'),
                                         ('Geología Ambiental', 'GEO-1701'),
                                         ('Oceanografía', 'OCE-1801'),
                                         ('Psicología Social', 'PSI-1901'),
                                         ('Comunicación Estratégica', 'COM-2001'),
                                         ('Ingeniería de Sistemas', 'ING-2101'),
                                         ('Gestión de Proyectos', 'PRY-2201'),
                                         ('Lingüística Aplicada', 'LIN-2301'),
                                         ('Traducción Especializada', 'TRA-2401'),
                                         ('Energías Renovables', 'ENR-2501'),
                                         ('Medio Ambiente', 'MED-2601'),
                                         ('Astronomía', 'AST-2701'),
                                         ('Física Espacial', 'FIS-2801'),
                                         ('Biotecnología', 'BIO-2901'),
                                         ('Genética Avanzada', 'GEN-3001');

-- Insert Sample Materias (30 records)
INSERT INTO user_table (name, username, email, password, rut) VALUES
                                                                  ('Juan Pérez González', 'jperez', 'juan.perez@email.com', '$2a$10$encrypted1', '12345678-9'),
                                                                  ('María Rodríguez Silva', 'mrodriguez', 'maria.rodriguez@email.com', '$2a$10$encrypted2', '98765432-1'),
                                                                  ('Carlos Martínez López', 'cmartinez', 'carlos.martinez@email.com', '$2a$10$encrypted3', '45678912-3'),
                                                                  ('Ana Sánchez Torres', 'asanchez', 'ana.sanchez@email.com', '$2a$10$encrypted4', '23456789-0'),
                                                                  ('Pedro Guzmán Rivas', 'pguzman', 'pedro.guzman@email.com', '$2a$10$encrypted5', '67890123-4'),
                                                                  ('Sofía Contreras Morales', 'scontreras', 'sofia.contreras@email.com', '$2a$10$encrypted6', '34567890-1'),
                                                                  ('Diego Hernández Fuentes', 'dhernandez', 'diego.hernandez@email.com', '$2a$10$encrypted7', '89012345-6'),
                                                                  ('Valentina Díaz Espinoza', 'vdiaz', 'valentina.diaz@email.com', '$2a$10$encrypted8', '56789012-3'),
                                                                  ('Andrés Muñoz Araya', 'amunoz', 'andres.munoz@email.com', '$2a$10$encrypted9', '90123456-7'),
                                                                  ('Isabel Rojas Vergara', 'irojas', 'isabel.rojas@email.com', '$2a$10$encrypted10', '78901234-5'),
                                                                  ('Eduardo Núñez Parra', 'enunez', 'eduardo.nunez@email.com', '$2a$10$encrypted11', '11234567-8'),
                                                                  ('Catalina Morales Soto', 'cmorales', 'catalina.morales@email.com', '$2a$10$encrypted12', '22345678-9'),
                                                                  ('Roberto Vega Contreras', 'rvega', 'roberto.vega@email.com', '$2a$10$encrypted13', '33456789-0'),
                                                                  ('Francisca Luna García', 'fluna', 'francisca.luna@email.com', '$2a$10$encrypted14', '44567890-1'),
                                                                  ('José Campos Sepúlveda', 'jcampos', 'jose.campos@email.com', '$2a$10$encrypted15', '55678901-2');

-- Asignar alumnos a materias (2-3 materias por alumno)
INSERT INTO alumno (rut_alumno, nombre_alumno, direccion,user_id) VALUES
                                                                      ('12345678-9', 'Juan Pérez González', 'Av. Libertador 123, Santiago',1),
                                                                      ('98765432-1', 'María Rodríguez Silva', 'Calle Principal 456, Valparaíso',2),
                                                                      ('45678912-3', 'Carlos Martínez López', 'Pasaje Central 789, Concepción',3),
                                                                      ('23456789-0', 'Ana Sánchez Torres', 'Avenida Costanera 234, Viña del Mar',4),
                                                                      ('67890123-4', 'Pedro Guzmán Rivas', 'Calle del Puerto 567, Antofagasta',5),
                                                                      ('34567890-1', 'Sofía Contreras Morales', 'Paseo Marino 890, Puerto Montt',6),
                                                                      ('89012345-6', 'Diego Hernández Fuentes', 'Avenida Araucana 345, Temuco',7),
                                                                      ('56789012-3', 'Valentina Díaz Espinoza', 'Calle del Bosque 678, Valdivia',8),
                                                                      ('90123456-7', 'Andrés Muñoz Araya', 'Pasaje del Sol 901, La Serena',9),
                                                                      ('78901234-5', 'Isabel Rojas Vergara', 'Avenida del Océano 234, Iquique',10),
                                                                      ('11234567-8', 'Eduardo Núñez Parra', 'Calle del Valle 567, Rancagua',11),
                                                                      ('22345678-9', 'Catalina Morales Soto', 'Paseo de los Andes 890, Talca',12),
                                                                      ('33456789-0', 'Roberto Vega Contreras', 'Avenida Central 123, Chillán',13),
                                                                      ('44567890-1', 'Francisca Luna García', 'Calle del Río 456, Temuco',14),
                                                                      ('55678901-2', 'José Campos Sepúlveda', 'Pasaje de la Montaña 789, Puerto Varas',15);
-- Insert users first (15 records)
INSERT INTO alumno_materia (alumno_id, materia_id) VALUES
                                                       (1, 1), (1, 2),
                                                       (2, 3), (2, 4),
                                                       (3, 5), (3, 6),
                                                       (4, 7), (4, 8),
                                                       (5, 9), (5, 10),
                                                       (6, 11), (6, 12),
                                                       (7, 13), (7, 14),
                                                       (8, 15), (8, 16),
                                                       (9, 17), (9, 18),
                                                       (10, 19), (10, 20),
                                                       (11, 21), (11, 22),
                                                       (12, 23), (12, 24),
                                                       (13, 25), (13, 26),
                                                       (14, 27), (14, 28),
                                                       (15, 29), (15, 30);

