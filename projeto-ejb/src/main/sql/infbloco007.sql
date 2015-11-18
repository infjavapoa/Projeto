
CREATE TABLE turma_aluno (
id_turma int NOT NULL ,
id_aluno int NOT  NULL, 
PRIMARY KEY (id_turma,id_aluno),
FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
) ENGINE=InnoDB ;

INSERT INTO turma_aluno (id_turma, id_aluno)
SELECT nr_turma, id_aluno from turma;

CREATE TEMPORARY TABLE IF NOT EXISTS turma_temp 
AS (SELECT DISTINCT nr_turma, nome, id_modulo,id_professor,dt_inicio, dt_fim  
      FROM turma );
      
ALTER TABLE avaliacao DROP FOREIGN KEY avaliacao_ibfk_3;
DROP TABLE turma;

CREATE TABLE turma (
id_turma   		int NOT NULL auto_increment,
nome       		varchar(100) NOT NULL,
id_modulo		int NOT NULL,
id_professor	int NOT NULL,
dt_inicio datetime null,
dt_fim    datetime null ,
PRIMARY KEY (id_turma),
FOREIGN KEY (id_modulo) REFERENCES modulo(id_modulo),
FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
) ENGINE=InnoDB ;


ALTER TABLE avaliacao ADD FOREIGN KEY (id_turma) REFERENCES turma (id_turma);


INSERT INTO turma (id_turma, nome, id_modulo, id_professor, dt_inicio, dt_fim)
SELECT DISTINCT nr_turma, nome, id_modulo,id_professor,dt_inicio, dt_fim  
      FROM turma_temp ;
      
DROP TABLE turma_temp;









