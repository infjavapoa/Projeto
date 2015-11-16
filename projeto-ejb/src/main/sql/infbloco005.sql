DROP TABLE resposta;

CREATE TABLE resposta (
id_resposta int NOT NULL auto_increment,
id_avaliacao_aluno int NOT NULL,
id_questionario_topico_questao int NOT NULL,
tipo_resposta char(1) NOT NULL,
id_alternativa int NULL,
texto text NULL,
PRIMARY KEY (id_resposta),
FOREIGN KEY (id_avaliacao_aluno) REFERENCES avaliacao_aluno(id_avaliacao_aluno),
FOREIGN KEY (id_questionario_topico_questao) REFERENCES questionario_topico_questao(id_questionario_topico_questao),
FOREIGN KEY (id_alternativa) REFERENCES alternativa(id_alternativa),
CONSTRAINT uniq_id_avaliacao_aluno_questao UNIQUE (id_avaliacao_aluno,id_questionario_topico_questao)
) ENGINE=InnoDB ;
