ALTER TABLE aluno
ADD nr_matricula int not null UNIQUE,
ADD cpf varchar(11)  NOT null UNIQUE;

ALTER TABLE professor
ADD cpf varchar(11) not null UNIQUE;
