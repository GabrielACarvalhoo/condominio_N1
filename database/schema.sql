CREATE DATABASE IF NOT EXISTS gestao_condominio
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE gestao_condominio;

-- 1. USUARIOS E PERFIS
CREATE TABLE if not exists perfil (
    id_perfil INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL UNIQUE,
    descricao VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    id_perfil INT NOT NULL,
    nome VARCHAR(120) NOT NULL,
    cpf CHAR(11) UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    senha_hash VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_usuario_perfil
      FOREIGN KEY (id_perfil) REFERENCES perfil(id_perfil)
) ENGINE=InnoDB;

CREATE TABLE unidade (
    id_unidade INT AUTO_INCREMENT PRIMARY KEY,
    bloco VARCHAR(30),
    numero VARCHAR(20) NOT NULL,
    andar INT,
    metragem DECIMAL(8,2),
    observacoes TEXT,
    UNIQUE KEY uk_unidade_bloco_numero (bloco, numero)
) ENGINE=InnoDB;

-- Permite que uma unidade tenha proprietario, inquilino ou mais de um morador.
CREATE TABLE usuario_unidade (
    id_usuario_unidade INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_unidade INT NOT NULL,
    tipo_vinculo ENUM('PROPRIETARIO','INQUILINO','MORADOR') NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    responsavel_financeiro BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_uu_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_uu_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT chk_uu_datas CHECK (data_fim IS NULL OR data_fim >= data_inicio),
    INDEX idx_uu_unidade (id_unidade),
    INDEX idx_uu_usuario (id_usuario)
) ENGINE=InnoDB;

CREATE TABLE cargo (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80) NOT NULL UNIQUE,
    descricao VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    id_cargo INT NOT NULL,
    data_admissao DATE,
    data_demissao DATE,
    CONSTRAINT fk_func_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_func_cargo FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
) ENGINE=InnoDB;

-- 2. PORTARIA: VISITANTES, AUTORIZACOES E ACESSOS
CREATE TABLE visitante (
    id_visitante INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    documento VARCHAR(30),
    telefone VARCHAR(20),
    observacoes TEXT
) ENGINE=InnoDB;

CREATE TABLE autorizacao_visitante (
    id_autorizacao INT AUTO_INCREMENT PRIMARY KEY,
    id_visitante INT NOT NULL,
    id_unidade INT NOT NULL,
    id_usuario_autorizador INT NOT NULL,
    inicio_validade DATETIME NOT NULL,
    fim_validade DATETIME,
    quantidade_acessos INT,
    status ENUM('PENDENTE','APROVADA','CANCELADA','EXPIRADA') NOT NULL DEFAULT 'PENDENTE',
    observacoes TEXT,
    CONSTRAINT fk_av_visitante FOREIGN KEY (id_visitante) REFERENCES visitante(id_visitante),
    CONSTRAINT fk_av_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT fk_av_autorizador FOREIGN KEY (id_usuario_autorizador) REFERENCES usuario(id_usuario),
    INDEX idx_av_periodo (inicio_validade, fim_validade)
) ENGINE=InnoDB;

CREATE TABLE registro_acesso (
    id_acesso INT AUTO_INCREMENT PRIMARY KEY,
    id_autorizacao INT NOT NULL,
    id_funcionario_portaria INT,
    entrada DATETIME NOT NULL,
    saida DATETIME,
    observacoes TEXT,
    CONSTRAINT fk_acesso_autorizacao FOREIGN KEY (id_autorizacao) REFERENCES autorizacao_visitante(id_autorizacao),
    CONSTRAINT fk_acesso_funcionario FOREIGN KEY (id_funcionario_portaria) REFERENCES funcionario(id_funcionario)
) ENGINE=InnoDB;

CREATE TABLE encomenda (
    id_encomenda INT AUTO_INCREMENT PRIMARY KEY,
    id_unidade INT NOT NULL,
    id_funcionario_recebimento INT,
    descricao VARCHAR(255) NOT NULL,
    transportadora VARCHAR(100),
    codigo_rastreio VARCHAR(100),
    recebida_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    retirada_em DATETIME,
    retirado_por VARCHAR(120),
    status ENUM('RECEBIDA','RETIRADA','DEVOLVIDA') NOT NULL DEFAULT 'RECEBIDA',
    observacoes TEXT,
    CONSTRAINT fk_encomenda_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT fk_encomenda_func FOREIGN KEY (id_funcionario_recebimento) REFERENCES funcionario(id_funcionario)
) ENGINE=InnoDB;

CREATE TABLE ocorrencia (
    id_ocorrencia INT AUTO_INCREMENT PRIMARY KEY,
    id_unidade INT,
    id_usuario_registro INT NOT NULL,
    id_funcionario_responsavel INT,
    categoria ENUM('PORTARIA','SEGURANCA','CONVIVENCIA','INFRAESTRUTURA','OUTRA') NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    registrada_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ABERTA','EM_ANALISE','RESOLVIDA','CANCELADA') NOT NULL DEFAULT 'ABERTA',
    CONSTRAINT fk_oc_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT fk_oc_usuario FOREIGN KEY (id_usuario_registro) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_oc_func FOREIGN KEY (id_funcionario_responsavel) REFERENCES funcionario(id_funcionario)
) ENGINE=InnoDB;

-- 3. AREAS COMUNS E RESERVAS
CREATE TABLE espaco_comum (
    id_espaco INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao TEXT,
    capacidade INT NOT NULL,
    regras TEXT,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB;

CREATE TABLE reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_espaco INT NOT NULL,
    id_usuario_solicitante INT NOT NULL,
    inicio DATETIME NOT NULL,
    fim DATETIME NOT NULL,
    quantidade_pessoas INT,
    status ENUM('PENDENTE','APROVADA','REJEITADA','CANCELADA','CONCLUIDA') NOT NULL DEFAULT 'PENDENTE',
    id_usuario_aprovador INT,
    solicitada_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    observacoes TEXT,
    CONSTRAINT fk_res_espaco FOREIGN KEY (id_espaco) REFERENCES espaco_comum(id_espaco),
    CONSTRAINT fk_res_solicitante FOREIGN KEY (id_usuario_solicitante) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_res_aprovador FOREIGN KEY (id_usuario_aprovador) REFERENCES usuario(id_usuario),
    CONSTRAINT chk_res_periodo CHECK (fim > inicio),
    INDEX idx_res_espaco_periodo (id_espaco, inicio, fim)
) ENGINE=InnoDB;

-- 4. GARAGEM
CREATE TABLE vaga (
    id_vaga INT AUTO_INCREMENT PRIMARY KEY,
    id_unidade INT,
    identificacao VARCHAR(30) NOT NULL UNIQUE,
    tipo ENUM('CARRO','MOTO','BICICLETA','OUTRO') NOT NULL DEFAULT 'CARRO',
    coberta BOOLEAN NOT NULL DEFAULT FALSE,
    status ENUM('DISPONIVEL','VINCULADA','MANUTENCAO') NOT NULL DEFAULT 'DISPONIVEL',
    CONSTRAINT fk_vaga_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade)
) ENGINE=InnoDB;

CREATE TABLE veiculo (
    id_veiculo INT AUTO_INCREMENT PRIMARY KEY,
    id_unidade INT NOT NULL,
    id_usuario INT,
    placa VARCHAR(10) NOT NULL UNIQUE,
    modelo VARCHAR(80),
    marca VARCHAR(60),
    cor VARCHAR(30),
    tipo ENUM('CARRO','MOTO','BICICLETA','OUTRO') NOT NULL DEFAULT 'CARRO',
    id_vaga INT,
    CONSTRAINT fk_veiculo_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT fk_veiculo_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_veiculo_vaga FOREIGN KEY (id_vaga) REFERENCES vaga(id_vaga)
) ENGINE=InnoDB;

-- 5. MANUTENCAO E INFRAESTRUTURA
CREATE TABLE solicitacao_manutencao (
    id_solicitacao INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_solicitante INT NOT NULL,
    id_unidade INT,
    id_funcionario_responsavel INT,
    local_problema VARCHAR(150) NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    prioridade ENUM('BAIXA','MEDIA','ALTA','URGENTE') NOT NULL DEFAULT 'MEDIA',
    status ENUM('ABERTA','EM_ANDAMENTO','AGUARDANDO','CONCLUIDA','CANCELADA') NOT NULL DEFAULT 'ABERTA',
    aberta_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    concluida_em DATETIME,
    CONSTRAINT fk_sm_usuario FOREIGN KEY (id_usuario_solicitante) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_sm_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    CONSTRAINT fk_sm_func FOREIGN KEY (id_funcionario_responsavel) REFERENCES funcionario(id_funcionario)
) ENGINE=InnoDB;

CREATE TABLE servico_manutencao (
    id_servico INT AUTO_INCREMENT PRIMARY KEY,
    id_solicitacao INT NOT NULL,
    id_funcionario_executor INT,
    descricao TEXT NOT NULL,
    realizado_em DATETIME NOT NULL,
    custo DECIMAL(10,2) DEFAULT 0.00,
    observacoes TEXT,
    CONSTRAINT fk_serv_solicitacao FOREIGN KEY (id_solicitacao) REFERENCES solicitacao_manutencao(id_solicitacao),
    CONSTRAINT fk_serv_func FOREIGN KEY (id_funcionario_executor) REFERENCES funcionario(id_funcionario)
) ENGINE=InnoDB;

-- 6. COMUNICACAO E DOCUMENTOS
CREATE TABLE comunicado (
    id_comunicado INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_autor INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    conteudo TEXT NOT NULL,
    publicado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    inicio_exibicao DATETIME,
    fim_exibicao DATETIME,
    status ENUM('RASCUNHO','PUBLICADO','ARQUIVADO') NOT NULL DEFAULT 'RASCUNHO',
    CONSTRAINT fk_com_usuario FOREIGN KEY (id_usuario_autor) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE documento (
    id_documento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_responsavel INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(80),
    caminho_arquivo VARCHAR(500) NOT NULL,
    enviado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    visibilidade ENUM('TODOS','MORADORES','ADMINISTRACAO') NOT NULL DEFAULT 'TODOS',
    CONSTRAINT fk_doc_usuario FOREIGN KEY (id_usuario_responsavel) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

-- 7. FINANCEIRO
CREATE TABLE taxa_condominial (
    id_taxa INT AUTO_INCREMENT PRIMARY KEY,
    id_unidade INT NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    competencia CHAR(7) NOT NULL COMMENT 'Formato YYYY-MM',
    valor DECIMAL(10,2) NOT NULL,
    vencimento DATE NOT NULL,
    status ENUM('ABERTA','PAGA','VENCIDA','CANCELADA','PARCIAL') NOT NULL DEFAULT 'ABERTA',
    CONSTRAINT fk_taxa_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id_unidade),
    UNIQUE KEY uk_taxa_unidade_competencia_desc (id_unidade, competencia, descricao)
) ENGINE=InnoDB;

CREATE TABLE pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_taxa INT NOT NULL,
    valor_pago DECIMAL(10,2) NOT NULL,
    pago_em DATETIME NOT NULL,
    forma_pagamento ENUM('PIX','BOLETO','DINHEIRO','CARTAO','TRANSFERENCIA','OUTRA') NOT NULL,
    comprovante VARCHAR(500),
    observacoes TEXT,
    CONSTRAINT fk_pag_taxa FOREIGN KEY (id_taxa) REFERENCES taxa_condominial(id_taxa)
) ENGINE=InnoDB;

CREATE TABLE despesa (
    id_despesa INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_registro INT NOT NULL,
    descricao VARCHAR(180) NOT NULL,
    categoria VARCHAR(80) NOT NULL,
    fornecedor VARCHAR(120),
    valor DECIMAL(10,2) NOT NULL,
    data_despesa DATE NOT NULL,
    vencimento DATE,
    paga BOOLEAN NOT NULL DEFAULT FALSE,
    paga_em DATE,
    observacoes TEXT,
    CONSTRAINT fk_desp_usuario FOREIGN KEY (id_usuario_registro) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

-- 8. DADOS INICIAIS DE PERFIS E CARGOS
INSERT INTO perfil (nome, descricao) VALUES
('PROPRIETARIO', 'Proprietario de unidade'),
('INQUILINO', 'Morador de unidade alugada'),
('SINDICO', 'Administracao geral do condominio'),
('SUBSINDICO', 'Auxilia a administracao'),
('PORTEIRO', 'Controle de acesso e encomendas'),
('ZELADOR', 'Conservacao e operacao'),
('AUXILIAR_SERVICOS_GERAIS', 'Limpeza e conservacao'),
('RESPONSAVEL_MANUTENCAO', 'Execucao e acompanhamento de reparos');

INSERT INTO cargo (nome, descricao) VALUES
('Porteiro', 'Controle de acesso e recebimento de encomendas'),
('Zelador', 'Conservacao e funcionamento do condominio'),
('Auxiliar de Servicos Gerais', 'Limpeza e conservacao'),
('Responsavel pela Manutencao', 'Reparos e manutencao');

