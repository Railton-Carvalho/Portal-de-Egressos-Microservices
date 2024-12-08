-- Inserir 5 registros na tabela tb_egresso
INSERT INTO egresso.tb_egresso (nome, email, password, cpf, resumo, url_foto, userStatus)
VALUES
    ('João Silva', 'joao.silva@discente.ufma.br', 'senha123', '12345678901', 'Formado em Engenharia Civil, especialista em projetos estruturais.', 'https://discente.ufma.br/fotos/joao.jpg', 'ACTIVE'),
    ('Maria Oliveira', 'maria.oliveira@discente.ufma.br', 'senha123', '23456789012', 'Graduada em Direito, com experiência em advocacia empresarial.', 'https://discente.ufma.br/fotos/maria.jpg', 'BLOCKED'),
    ('Railton Carvalho', 'railton.rc@discente.ufma.br', 'senha123', '34567890123', 'Bacharel em Ciência da Computação, desenvolvedor full-stack.', 'https://discente.ufma.br/fotos/carlos.jpg', 'ACTIVE'),
    ('Ana Souza', 'ana.souza@discente.ufma.br', 'senha123', '45678901234', 'Especialista em Marketing Digital com foco em redes sociais.', 'https://discente.ufma.br/fotos/ana.jpg', 'ACTIVE'),
    ('Pedro Lima', 'pedro.lima@discente.ufma.br', 'senha123', '56789012345', 'Administrador de empresas, gestor de projetos.', 'https://discente.ufma.br/fotos/pedro.jpg', 'BLOCKED');
