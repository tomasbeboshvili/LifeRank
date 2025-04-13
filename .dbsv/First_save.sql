USE liferank;

-- Tabla: usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: clases
CREATE TABLE clases (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	
	nombre_clase VARCHAR(30) NOT NULL,
	descripcion_clase VARCHAR(255) NOT NULL DEFAULT 'Still in development',

	multiplicador_fuerza DECIMAL(3,2) DEFAULT 1.00,
	multiplicador_inteligencia DECIMAL(3,2) DEFAULT 1.00,
	multiplicador_resistencia DECIMAL(3,2) DEFAULT 1.00,
	multiplicador_voluntad DECIMAL(3,2) DEFAULT 1.00

);

-- Tabla: personajes
CREATE TABLE personajes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    usuario_id BIGINT NOT NULL,
    id_clase BIGINT NOT NULL,
    

	nivel INT DEFAULT 1,
    fuerza INT DEFAULT 0,
    inteligencia INT DEFAULT 0,
    resistencia INT DEFAULT 0,
	voluntad INT DEFAULT 0,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
	FOREIGN KEY (id_clase) REFERENCES clases(id)
);



-- Tabla: items
CREATE TABLE items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    bono_fuerza INT DEFAULT 0,
    bono_inteligencia INT DEFAULT 0,
    bono_resistencia INT DEFAULT 0
);

-- Tabla: inventario (relación personaje - ítems)
CREATE TABLE inventario (
    personaje_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    equipado BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (personaje_id, item_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE
);

CREATE TABLE quests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    tipo VARCHAR(30), -- Por ejemplo: "estudio", "disciplina", "resistencia", etc.
    stat_requerido VARCHAR(30), -- Puede ser fuerza, inteligencia, resistencia
    nivel_requerido INT DEFAULT 1,
    recompensa_exp INT DEFAULT 0,
    recompensa_item_id BIGINT, -- Item opcional como recompensa
    FOREIGN KEY (recompensa_item_id) REFERENCES items(id) ON DELETE SET NULL
);

CREATE TABLE progreso_quests (
    personaje_id BIGINT NOT NULL,
    quest_id BIGINT NOT NULL,
    estado VARCHAR(20) DEFAULT 'pending', -- pendiente, en_progreso, completada
    fecha_inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_completado TIMESTAMP NULL,
    PRIMARY KEY (personaje_id, quest_id),
    FOREIGN KEY (personaje_id) REFERENCES personajes(id) ON DELETE CASCADE,
    FOREIGN KEY (quest_id) REFERENCES quests(id) ON DELETE CASCADE
);

