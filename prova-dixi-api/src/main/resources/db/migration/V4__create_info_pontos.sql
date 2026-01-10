CREATE TABLE info_pontos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ponto_id BIGINT NOT NULL UNIQUE,
    funcionario_id BIGINT NOT NULL,
    considerada BOOLEAN NOT NULL,
    motivo VARCHAR (100),
    possui_foto BOOLEAN NOT NULL,
    url_foto VARCHAR (100),
    possui_localizacao BOOLEAN NOT NULL,
    latitude DECIMAL (9,6),
    longitude DECIMAL (9,6),
    FOREIGN KEY (ponto_id) REFERENCES pontos (id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionarios (id),
    PRIMARY KEY (id)
);