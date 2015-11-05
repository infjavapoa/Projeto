CREATE TABLE curso (
id_curso int NOT NULL auto_increment,
nm_curso varchar(100) NOT NULL,
PRIMARY KEY (id_curso)
) ENGINE=InnoDB ;

CREATE TABLE bloco (
id_bloco int NOT NULL auto_increment,
nm_bloco varchar(100) NOT NULL,
id_curso int not NULL,
PRIMARY KEY (id_bloco),
FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
) ENGINE=InnoDB ;


CREATE TABLE modulo (
id_modulo int NOT NULL auto_increment,
nm_modulo varchar(100) NOT NULL,
id_bloco int not NULL,
PRIMARY KEY (id_modulo),
FOREIGN KEY (id_bloco) REFERENCES bloco(id_bloco)
) ENGINE=InnoDB ;


CREATE TABLE aluno (
id_aluno int NOT NULL auto_increment,
nm_aluno varchar(150) NOT NULL,
email varchar(100) NULL,
genero char(1) NULL,
PRIMARY KEY (id_aluno)
) ENGINE=InnoDB ;

CREATE TABLE professor (
id_professor int NOT NULL auto_increment,
nm_professor varchar(150) NOT NULL,
email varchar(100) NULL,
genero char(1) NULL,
PRIMARY KEY (id_professor)
) ENGINE=InnoDB ;


ALTER TABLE avaliacao DROP FOREIGN KEY avaliacao_ibfk_1;
DROP TABLE turma;

CREATE TABLE turma (
id_turma   		int NOT NULL auto_increment,
nome       		varchar(100) NOT NULL,
id_modulo		int NOT NULL,
id_aluno		int NOT NULL,
id_professor	int NOT NULL,
PRIMARY KEY (id_turma),
FOREIGN KEY (id_modulo) REFERENCES modulo(id_modulo),
FOREIGN KEY (id_modulo) REFERENCES bloco(id_bloco),
FOREIGN KEY (id_modulo) REFERENCES bloco(id_bloco)
) ENGINE=InnoDB ;

ALTER TABLE avaliacao ADD FOREIGN KEY (id_turma) REFERENCES turma (id_turma);