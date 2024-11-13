CREATE SCHEMA egresso;

CREATE TABLE egresso.tb_egresso (
    id_egresso SERIAL PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL,
       cpf VARCHAR(11) NOT NULL UNIQUE,
       resumo TEXT,
       url_foto VARCHAR(255)
);