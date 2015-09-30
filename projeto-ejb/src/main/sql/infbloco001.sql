CREATE DATABASE `infbloco` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE topico (
id_topico int NOT NULL auto_increment,
texto varchar(100) NOT NULL,
PRIMARY KEY (id_topico)
) ENGINE=InnoDB ;

CREATE TABLE questao (
id_questao int NOT NULL auto_increment,
texto text NOT NULL,
tipo_questao char(1) NOT NULL,
id_topico int not NULL,
PRIMARY KEY (id_questao),
FOREIGN KEY (id_topico) REFERENCES topico(id_topico)
) ENGINE=InnoDB ;

CREATE TABLE questionario (
id_questionario int NOT NULL auto_increment,
nome varchar(30) NOT NULL,
PRIMARY KEY (id_questionario)
) ENGINE=InnoDB ;

CREATE TABLE questionario_questao (
id_questionario_questao int NOT NULL auto_increment,
id_questao int NOT NULL ,
id_questionario int NOT NULL,
ordem int not null,
PRIMARY KEY (id_questionario_questao),
FOREIGN KEY (id_questao) REFERENCES questao(id_questao),
FOREIGN KEY (id_questionario) REFERENCES questionario(id_questionario),
CONSTRAINT uniq_id_questao_questionario UNIQUE (id_questao,id_questionario) 
) ENGINE=InnoDB;

/*Criar essa tabela? Se colocamos como chace estrangeira na tabela avaliação essa tabela deve existir no banco */
CREATE TABLE turma (
id_turma int NOT NULL auto_increment,
nome varchar(100) NOT NULL,
PRIMARY KEY (id_turma)
) ENGINE=InnoDB ;

/*******************************************************************************************/

CREATE TABLE avaliacao (
id_avaliacao int NOT NULL auto_increment,
id_turma int NOT NULL,
id_questionario int NULL,
cod_avaliacao char(10) NOT NULL,
objetivo varchar(200) NULL,
data_inicio datetime NULL,
data_termino datetime NULL,
situacao char(1) NULL,
PRIMARY KEY (id_avaliacao),
FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
FOREIGN KEY (id_questionario) REFERENCES questionario(id_questionario)
) ENGINE=InnoDB ;

CREATE TABLE avaliacao_aluno (
id_avaliacao_aluno int NOT NULL auto_increment,
id_avaliacao int NOT NULL,
id_aluno int NOT NULL, /*vamos criar uma tabela aluno? ou inserir no braço?*/
data_preenchimento datetime NULL,
PRIMARY KEY (id_avaliacao_aluno),
FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id_avaliacao),
CONSTRAINT uniq_id_avaliacao_aluno UNIQUE (id_avaliacao,id_aluno)
) ENGINE=InnoDB ;

CREATE TABLE alternativa (
id_alternativa int NOT NULL auto_increment,
texto char(15) NULL,
PRIMARY KEY (id_alternativa)
) ENGINE=InnoDB ;

CREATE TABLE resposta (
id_resposta int NOT NULL auto_increment,
id_avaliacao int NOT NULL,
id_aluno int NOT NULL,
id_questao int NOT NULL,
id_alternativa int NULL,
texto text NULL,
PRIMARY KEY (id_resposta ),
FOREIGN KEY (id_avaliacao,id_aluno) REFERENCES avaliacao_aluno(id_avaliacao,id_aluno),
FOREIGN KEY (id_questao) REFERENCES questao(id_questao),
FOREIGN KEY (id_alternativa) REFERENCES alternativa(id_alternativa),
CONSTRAINT uniq_id_avaliacao_aluno_questao UNIQUE (id_avaliacao,id_aluno,id_questao)
) ENGINE=InnoDB ;