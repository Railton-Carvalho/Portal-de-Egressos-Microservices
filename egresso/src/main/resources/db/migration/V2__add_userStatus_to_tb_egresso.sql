-- Criação do tipo ENUM
CREATE TYPE user_status AS ENUM ('ACTIVE', 'BLOCKED');

-- Adicionar a nova coluna
ALTER TABLE egresso.tb_egresso
ADD COLUMN userStatus user_status NOT NULL DEFAULT 'ACTIVE';
