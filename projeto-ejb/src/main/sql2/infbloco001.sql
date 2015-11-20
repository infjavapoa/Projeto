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
nr_matricula int NOT NULL UNIQUE,
cpf varchar(11)  NOT NULL UNIQUE,
PRIMARY KEY (id_aluno)
) ENGINE=InnoDB ;

CREATE TABLE professor (
id_professor int NOT NULL auto_increment,
nm_professor varchar(150) NOT NULL,
email varchar(100) NULL,
genero char(1) NULL,
cpf varchar(11)  NOT NULL UNIQUE,
PRIMARY KEY (id_professor)
) ENGINE=InnoDB ;

CREATE TABLE turma (
id_turma   		int NOT NULL auto_increment,
nome       		varchar(100) NOT NULL,
id_modulo		int NOT NULL,
id_professor	int NOT NULL,
dt_inicio datetime null,
dt_fim    datetime null,
PRIMARY KEY (id_turma),
FOREIGN KEY (id_modulo) REFERENCES modulo(id_modulo),
FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
) ENGINE=InnoDB ;

CREATE TABLE turma_aluno (
id_turma int NOT NULL ,
id_aluno int NOT  NULL, 
PRIMARY KEY (id_turma,id_aluno),
FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
) ENGINE=InnoDB ;

CREATE TABLE topico (
id_topico int NOT NULL auto_increment,
texto varchar(100) NOT NULL,
PRIMARY KEY (id_topico)
) ENGINE=InnoDB ;

CREATE TABLE questao (
id_questao int NOT NULL auto_increment,
texto text NOT NULL,
tipo_questao char(1) NOT NULL,
PRIMARY KEY (id_questao)
) ENGINE=InnoDB ;

CREATE TABLE questionario (
id_questionario int NOT NULL auto_increment,
nome varchar(30) NOT NULL,
PRIMARY KEY (id_questionario)
) ENGINE=InnoDB;

CREATE TABLE questionario_topico (
id_questionario_topico int NOT NULL auto_increment,
id_questionario int NOT NULL ,
id_topico int NOT NULL,
ordem int not null,
PRIMARY KEY (id_questionario_topico),
FOREIGN KEY (id_questionario) REFERENCES questionario(id_questionario),
FOREIGN KEY (id_topico) REFERENCES topico(id_topico),
CONSTRAINT uniq_id_questionario_topico UNIQUE (id_questionario,id_topico) 
) ENGINE=InnoDB;

CREATE TABLE questionario_topico_questao (
id_questionario_topico_questao int NOT NULL auto_increment,
id_questionario_topico int NOT NULL ,
id_questao int NOT NULL,
ordem int not null,
PRIMARY KEY (id_questionario_topico_questao),
FOREIGN KEY (id_questionario_topico) REFERENCES questionario_topico(id_questionario_topico),
FOREIGN KEY (id_questao) REFERENCES questao(id_questao),
CONSTRAINT uniq_id_questionario_topico_questao UNIQUE (id_questionario_topico, id_questao) 
) ENGINE=InnoDB;

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
id_aluno int NOT NULL, /*vamos criar uma tabela aluno? ou inserir no bra�o?*/
data_preenchimento datetime NULL,
PRIMARY KEY (id_avaliacao_aluno),
FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id_avaliacao),
CONSTRAINT uniq_id_avaliacao_aluno UNIQUE (id_avaliacao,id_aluno)
) ENGINE=InnoDB ;

CREATE TABLE alternativa (
id_alternativa int NOT NULL auto_increment,
texto char(25) NULL,
ordem int NOT NULL,
PRIMARY KEY (id_alternativa)
) ENGINE=InnoDB ;

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

CREATE TABLE usuario (
email varchar(100) NOT NULL,
senha varchar(50) NOT NULL,
nome varchar(100) NOT NULL,
papel varchar(100) NOT NULL,
PRIMARY KEY (email)
) ENGINE=InnoDB ;

CREATE TABLE parametros (
id_param int NOT NULL auto_increment,
msg_abertura text  NULL,
msg_confirma_email text  NULL,
dir_arq_avaliacao varchar(150) NULL,
PRIMARY KEY (id_param)
) ENGINE=InnoDB ;

INSERT INTO `curso` VALUES (1,'MIT em Engenharia de Software com Java');
INSERT INTO `bloco` VALUES (1,'Engenharia de Software',1),(2,'Programação Orientada a Objetos',1),(3,'Desenvolvimento Web',1),(4,'TCC',1);
INSERT INTO `modulo` VALUES (1,'Projeto de Bloco - Engenharia de Software',1),(2,'Introdução à Engenharia de Software',1),(3,'Processos de Desenvolvimento de Software',1),(4,'Métricas de Desenvolvimento de Software',1),(5,'Análise e Projeto de Sistemas Orientados a Objetos',2),(6,'Projeto de Bloco - 2° bloco',2),(7,'Programação Orientadas a Objetos com Java',2),(8,'Acesso a dados, Multithreading e Interface gráfica em Java',2),(9,'Projeto de Bloco (Web e Componentes com JAVA)',3),(10,'Aplicação Web',3),(11,'Aplicações na Camada de Negócios',3),(12,'Tópicos Avançados',3);

INSERT INTO `aluno` VALUES (1,'FRANCISCO MOREIRA DA SILVA','tche_aurelio@hotmail.com','M',10001,'29727693172'),(2,'MARIA DA CONCEICAO SOARES DOS SANTOS','tche_aurelio@hotmail.com','F',10000,'18530249100'),(3,'GERALDO LEITE BRANDAO','tche_aurelio@hotmail.com','M',10002,'09797904172'),(4,'FRANCISCO MARTINS BORGES','tcheaurelio@gmail.com','M',10003,'12084867134'),(5,'CLAUDIO FERREIRA CAVALCANTE','mrmello@gmail.com','M',10004,'21008540110'),(6,'JADER CALACINA DANTAS','mrmello@gmail.com','M',10005,'11977027172'),(7,'JANETE OLIVEIRA DE MOURA FRANCA','mrmello@gmail.com','F',10006,'28106434100'),(8,'RICARDO SOUZA DA SILVA','lickerls@hotmail.com','M',10007,'92635881120'),(9,'MARIA BATISTA MONTEIRO','lickerls@hotmail.com','F',10008,'18872930782'),(10,'ROSIMEIRE FERREIRA CALIXTO','tcheaurelio@gmail.com','F',10009,'44456590106'),(11,'FRANCISCO DE OLIVEIRA TRINDADE','tche_aurelio@hotmail.com','M',10010,'33909245153'),(12,'JOSIMARIA BANDEIRA DE FRANCA','lickerls@hotmail.com','F',10011,'64760367187'),(13,'JOCICLEUDO DE SOUZA FROTA','tche_aurelio@hotmail.com','M',10012,'87555948168'),(14,'MARIA ORALICE FREIRE','mrmello@gmail.com','F',10013,'72056568187'),(15,'CAZIMIRO CAVALCANTE DE OLIVEIRA','tcheaurelio@gmail.com','M',10014,'47143134104'),(16,'NERILSON ANDRADE DE OLIVEIRA','lickerls@hotmail.com','M',10015,'49182218153'),(17,'JOAO ESTEPHAN AMORIN BARBARY','lickerls@hotmail.com','M',10016,'27113213120'),(18,'RAIMUNDA NILDOMAR TELES BEZERRA','lickerls@hotmail.com','F',10017,'47180021172'),(19,'ALDERLEI DA SILVA MACIEL','tcheaurelio@gmail.com','M',10018,'08452865104'),(20,'LAIDES MAGALHAES DAMASCENO','lickerls@hotmail.com','F',10019,'33805601620'),(21,'NORANEIDE ALVES DA SILVA','lickerls@hotmail.com','F',10020,'64569756891'),(22,'CARLOS HENRIQUE GUIMARAES SARAH','tche_aurelio@hotmail.com','M',10021,'18642608153'),(23,'ANA MARIA SANTOS RODRIGUES','mrmello@gmail.com','F',10022,'38092123187'),(24,'CLAUDENICE DA SILVA NEPOMUCENO DO NASCIMENTO','tche_aurelio@hotmail.com','F',10023,'28100026149'),(25,'JOAO SOARES DE SOUZA','tcheaurelio@gmail.com','M',10024,'17966051153'),(26,'MARIA DAS DORES DE SOUZA','lickerls@hotmail.com','F',10025,'14621320253'),(27,'EURICO NUNES CARDOZO','mrmello@gmail.com','M',10026,'09870520120'),(28,'IRISMAR OLIVEIRA DA SILVA','mrmello@gmail.com','M',10027,'64641520178'),(29,'RAIMUNDO GUSTAVO ALMEIDA DE CARVALHO','lickerls@hotmail.com','M',10028,'29709970100'),(30,'SEBASTIAO DE ASSIS LIMA','lickerls@hotmail.com','M',10029,'34265279104'),(31,'MARIA JOSE LIMA MENDES','mrmello@gmail.com','F',10030,'76951863172'),(32,'NEIDE BATISTA DO AMARAL','tcheaurelio@gmail.com','F',10031,'11523107120'),(33,'NEIDE DE LARA','lickerls@hotmail.com','F',10032,'12782661191'),(34,'FRANCISCA ALRICELIA CARDOSO DA SILVA','tche_aurelio@hotmail.com','F',10033,'04156528391'),(35,'JOSE SOUZA DA SILVA','tche_aurelio@hotmail.com','M',10034,'25884263104'),(36,'REGIANE MARIA DA SILVA ROLA','tche_aurelio@hotmail.com','F',10035,'41685199100'),(37,'ELZA RODRIGUES DA SILVA','mrmello@gmail.com','F',10036,'21465851100'),(38,'JOSE RAIMUNDO ALVES DE SOUSA','mrmello@gmail.com','M',10037,'39347281115'),(39,'MARIA LUCIA DOS SANTOS LEITE','tche_aurelio@hotmail.com','F',10038,'10259686115'),(40,'JOSE ALVES BEZERRA','tche_aurelio@hotmail.com','F',10039,'66662079120'),(41,'JOSE SARAIVA DO VALE JUNIOR','mrmello@gmail.com','M',10040,'03366979100'),(42,'PAULO HERONCIO DE OLIVEIRA','lickerls@hotmail.com','M',10041,'41749464187'),(43,'ROSANIA GUEDES DA ROCHA','tche_aurelio@hotmail.com','F',10042,'20940041391'),(44,'ANTONIO MARIANO OLIVEIRA NUNES','mrmello@gmail.com','M',10043,'77070283172'),(45,'FRANCISCO CORREIA DE ARAUJO','lickerls@hotmail.com','M',10044,'33957983134'),(46,'DAGMAR VIEIRA DA SILVA','tche_aurelio@hotmail.com','F',10045,'61996467115'),(47,'PAULO BARBOSA DE SOUZA','lickerls@hotmail.com','M',10046,'76568989134'),(48,'MARIA DAS DORES DANTAS DA SILVA','tche_aurelio@hotmail.com','F',10047,'27550397104'),(49,'MARIA DAS DORES DANTAS DA SILVA','mrmello@gmail.com','F',10048,'52434540104'),(50,'FRANCISCO BATISTA DE SOUZA','lickerls@hotmail.com','M',10049,'52416658115'),(51,'FRANCISCA FERREIRA DA SILVA MELO','mrmello@gmail.com','F',10050,'37592998149'),(52,'ROGEVANIO SILVA DO NASCIMENTO','mrmello@gmail.com','M',10051,'61038466172'),(53,'GERONILDE DA SILVA RODRIGUES','tche_aurelio@hotmail.com','F',10052,'35142820134'),(54,'COSMO RODRIGUES DA COSTA','mrmello@gmail.com','M',10053,'25865340182'),(55,'FRANCISCO TARCISO PACHECO','mrmello@gmail.com','M',10054,'31357458134'),(56,'LINDOMAR ALMEIDA DE SOUZA','lickerls@hotmail.com','M',10055,'56348916120'),(57,'TERESINHA DANTAS DE ARAUJO','mrmello@gmail.com','F',10056,'69826838187'),(58,'IVONILDES DA COSTA CARDOSO','tche_aurelio@hotmail.com','F',10057,'29641659120'),(59,'TORQUATA CRUZ DE SOUSA','lickerls@hotmail.com','F',10058,'29166381134'),(60,'JONAS CLAUDIO DE ASSIS','tche_aurelio@hotmail.com','M',10059,'15533166149'),(61,'JOAO PAULINO DE CAMPOS NETO','mrmello@gmail.com','M',10060,'94356599853'),(62,'MARIA RAILENE SANTIAGO PINHEIRO','lickerls@hotmail.com','F',10061,'22104836115'),(63,'EDSON MEDEIRO DA SILVA','tche_aurelio@hotmail.com','M',10062,'34058737115'),(64,'ALDEMIRA FERNANDES DE OLIVEIRA','tche_aurelio@hotmail.com','F',10063,'32483040144'),(65,'ELIZENI DA COSTA LUZ','lickerls@hotmail.com','F',10064,'05891175304'),(66,'LEILA GRARCIENE CORREA DE SOUZA','mrmello@gmail.com','F',10065,'60200359134'),(67,'VALDINEA MATOS DOS SANTOS','mrmello@gmail.com','F',10066,'24914835134'),(68,'ORTENCIA GALBIATI DE OLIVEIRA','lickerls@hotmail.com','F',10067,'18461859120'),(69,'ELCINEIDE AGUIAR DOS SANTOS','mrmello@gmail.com','F',10068,'94139415800'),(70,'ELCINEIDE AGUIAR DOS SANTOS','tche_aurelio@hotmail.com','F',10069,'27997154191'),(71,'RENATO RIBEIRO DE MESQUITA','mrmello@gmail.com','M',10070,'35223154134'),(72,'MARIA ROSSINEIDE BARROS DE MOURA','tche_aurelio@hotmail.com','F',10071,'15421449149'),(73,'GERUZA MACIEL DA SILVA','lickerls@hotmail.com','F',10072,'58451790178'),(74,'RAIMUNDO RODRIGUES DE FREITAS','mrmello@gmail.com','M',10073,'36898457691'),(75,'ALIPIO DA SILVEIRA TORRES','lickerls@hotmail.com','M',10074,'14970767149'),(76,'FRANCISCO ROSEMIRO BARRETO BARROSO','tche_aurelio@hotmail.com','M',10075,'86744518100'),(77,'FRANCISCO FERLENO DE SOUZA','mrmello@gmail.com','M',10076,'60683210106'),(78,'AMILTON VIEIRA','mrmello@gmail.com','M',10077,'15319687168'),(79,'MARIA ALICE GOUVEIA DE OLIVEIRA','lickerls@hotmail.com','F',10078,'26251701153'),(80,'DOMINGOS SALVIO LOPES CABANELAS','tche_aurelio@hotmail.com','M',10079,'18433570110'),(81,'ANTONIO BATISTA VIEIRA','lickerls@hotmail.com','M',10080,'14588790110'),(82,'ROSALI EVARISTO DA SILVA','mrmello@gmail.com','F',10081,'30989418120'),(83,'ECY OLIVEIRA DE CARVALHO','mrmello@gmail.com','F',10082,'37312995187'),(84,'FRANCISCO ALVES DA SILVA','lickerls@hotmail.com','M',10083,'15369803153'),(85,'DANIELA ROCHA DOS SANTOS','lickerls@hotmail.com','F',10084,'22374264149'),(86,'MANOEL DE JESUS BENICIO DA SILVA','tche_aurelio@hotmail.com','M',10085,'24568546168'),(87,'JOAO PEREIRA DOS SANTOS','lickerls@hotmail.com','M',10086,'34341129104'),(88,'FRANCISCA DE OLIVEIRA SILVA','tche_aurelio@hotmail.com','F',10087,'07261560197'),(89,'OSMARINO ANDRADE DO NASCIMENTO','lickerls@hotmail.com','M',10088,'89518748187'),(90,'ROSANGELA LOPES DA SILVA','mrmello@gmail.com','F',10089,'36460753172');
INSERT INTO `professor` VALUES (1,'Frederico Novaes','frederico.novaes@infnet.edu.br','M','63015825356'),(2,'Tomás de Aquino Tinoco Botelho','aquino.botelho@infnet.edu.br','M','71489227717'),(3,'Rogério Magela','','M','36903471308'),(4,'Bruno Freitas Braga','','M','26344928638'),(5,'Conrad Marques Peres','','M','64583894341'),(6,'André Felix da Silva','','M','18642445181'),(7,'Flavio Longue Guimarães','','M','24844528963'),(8,'Manoel Pedro Sá','','M','27651208110'),(9,'Thiago Medeiros','thiago.medeiros@prof.infnet.edu.br','M','17636766337');
INSERT INTO `turma` VALUES (1,'Turma 1',2,2,NULL,NULL),(2,'Turma 2',8,6,NULL,NULL),(3,'Turma 3',11,8,NULL,NULL);
INSERT INTO `turma_aluno` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),(2,51),(2,52),(2,53),(2,54),(2,55),(2,56),(2,57),(2,58),(2,59),(2,60),(3,61),(3,62),(3,63),(3,64),(3,65),(3,66),(3,67),(3,68),(3,69),(3,70),(3,71),(3,72),(3,73),(3,74),(3,75),(3,76),(3,77),(3,78),(3,79),(3,80),(3,81),(3,82),(3,83),(3,84),(3,85),(3,86),(3,87),(3,88),(3,89),(3,90);

INSERT INTO `infbloco`.`topico`(`id_topico`,`texto`) VALUES (1,'Avaliação geral da Pós-Graduação');
INSERT INTO `infbloco`.`topico`(`id_topico`,`texto`) VALUES (2,'Avaliação do professor no módulo');
INSERT INTO `infbloco`.`topico`(`id_topico`,`texto`) VALUES (3,'Avaliação de conteúdo e infra-estrutura no módulo');

INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (1,'Até agora, o curso está atingindo as minhas expectativas.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (2,'Até agora, eu indicaria o curso para um amigo.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (3,'Até agora, o curso me parece voltado para as necessidades do mercado.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (4,'Até agora, a coordenação pedagógica parece comprometida com a qualidade do curso.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (5,'Até agora, minha turma parece proporcionar um networking relevante para a minha carreira.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (6,'Até agora, o atendimento de Secretaria que recebi está atingindo as minhas expectativas.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (7,'O professor contribuiu para o meu aprendizado.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (8,'O professor é atencioso e esteve disponível para tirar dúvidas.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (9,'O professor aproveitou bem o tempo em sala de aula.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (10,'O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizado.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (11,'O professor aproveitou bem os recursos da sala de aula.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (12,'Gostaria de cursar outros módulos com esse professor.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (13,'Eu adquiri as competências propostas para o módulo.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (14,'O módulo foi útil para o meu crescimento profissional.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (15,'A carga horária do módulo foi apropriada.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (16,'O acervo da biblioteca atendeu as necessidades desse módulo.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (17,'A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada.','O');
INSERT INTO `infbloco`.`questao`(`id_questao`,`texto`,`tipo_questao`) VALUES (18,'Você tem comentários e sugestões?','D');

INSERT INTO `infbloco`.`questionario` (`id_questionario`,`nome`) VALUES (1, 'Questionário INFNET');

INSERT INTO `infbloco`.`questionario_topico`(`id_questionario_topico`,`id_questionario`,`id_topico`,`ordem`) VALUES(1,1,1,1);
INSERT INTO `infbloco`.`questionario_topico`(`id_questionario_topico`,`id_questionario`,`id_topico`,`ordem`) VALUES(2,1,2,3);
INSERT INTO `infbloco`.`questionario_topico`(`id_questionario_topico`,`id_questionario`,`id_topico`,`ordem`) VALUES(3,1,3,3);

INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (1,1,1,1);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (2,1,2,2);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (3,1,3,3);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (4,1,4,4);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (5,1,5,5);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (6,1,6,6);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (7,2,7,1);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (8,2,8,2);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (9,2,9,3);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (10,2,10,4);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (11,2,11,5);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (12,2,12,6);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (13,3,13,1);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (14,3,14,2);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (15,3,15,3);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (16,3,16,4);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (17,3,17,5);
INSERT INTO `infbloco`.`questionario_topico_questao`(`id_questionario_topico_questao`,`id_questionario_topico`,`id_questao`,`ordem`) VALUES (18,3,18,6);

INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (1, 'Concordo Totalmente', 1);
INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (2, 'Concordo', 2);
INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (3, 'Não concordo nem Discordo',3);
INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (4, 'Discordo',4);
INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (5, 'Discordo Totalmente',5);
INSERT INTO alternativa(id_alternativa, texto, ordem) VALUES (6, 'Não Sei Avaliar',6);