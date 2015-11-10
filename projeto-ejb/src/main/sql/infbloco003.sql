/*Modificação da tabela turma*/
/*Exclusão da FK da tabela avaliação referente a turma */ 
/*Verificar se o nome da FK esta correto pode estar como avaliacao_ibfk_1 */
ALTER TABLE avaliacao DROP FOREIGN KEY avaliacao_ibfk_3;

DROP TABLE turma;

/* Tabela turma recriada */
/* como a tabela virou um tabelão deixei o campo id_turma como PK e */
/*criei o campo nr_turma para evitar  chave composta*/
/*os campos dt_inicio e dt_fim caso surja alguma necessidade de controlar o período*/

CREATE TABLE turma (
id_turma   		int NOT NULL auto_increment,
nr_turma        int NOT NULL, 
nome       		varchar(100) NOT NULL,
id_modulo		int NOT NULL,
id_aluno		int NOT NULL,
id_professor	int NOT NULL,
dt_inicio datetime null,
dt_fim    datetime null ,
PRIMARY KEY (id_turma),
FOREIGN KEY (id_modulo) REFERENCES modulo(id_modulo),
FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
) ENGINE=InnoDB ;

/* Recriada a FK referente a turma na tabela avaliacao*/
ALTER TABLE avaliacao ADD FOREIGN KEY (id_turma) REFERENCES turma (id_turma);

/*******************************************************************************/
/* Criacão da procedure para montar as turmas*/
/*Passar como parametros id_modulo, id_professor*/
/*limites para buscar na tabela aluno : aluno_ini para iniciar do  1 passar 0 , aluno_final - limite max ex 30*/

DELIMITER //
DROP PROCEDURE IF EXISTS pr_cria_turmas//
CREATE PROCEDURE pr_cria_turmas (modulo int, professor int, aluno_ini int, aluno_final int )
BEGIN
DECLARE contador TINYINT UNSIGNED DEFAULT 0;
DECLARE turma int;
DECLARE nm_turma varchar(100) ;
SET contador = aluno_ini;  
SET turma = (select IFNULL(max(nr_turma),0) + 1 from turma) ;
SET nm_turma = CONCAT('Turma ', TRIM(CAST(turma AS CHAR(10)))) ;
   
WHILE contador < aluno_final DO
    SET contador = contador + 1;
    Insert
	  into turma (nr_turma,nome,id_modulo,id_aluno,id_professor)
	values (turma, nm_turma,modulo,contador, professor);
END WHILE;
END//
DELIMITER ;

DELIMITER //
/* 2 - 'Introdução à Engenharia de Software'*/
/* 2 - 'Tomás de Aquino Tinoco Botelho'*/
/*0 -  inicia a partir do 1*/
/*30 -  30 alunos */
/* foram  criadas 3 turmas que serão  carregas no dump*/
CALL pr_cria_turmas(2,2,0,30);

CALL pr_cria_turmas(8,6,30,60);

CALL pr_cria_turmas(11,8,60,90);

select * from turma;

DELIMITER ;
