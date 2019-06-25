CREATE TYPE tipoUser AS ENUM ('Administrador','Estudante');
CREATE DOMAIN mostraMesan AS char (3)
DEFAULT 'sim'
NOT NULL
CHECK (VALUE IN ('sim','nao'));

CREATE TABLE IF NOT EXISTS usuario (
id serial,
nome character varying (300) not null,
email character varying (300) not null unique,
usuario character varying (300) not null,
senha character varying (8) not null,
tipo tipouser default 'Estudante',
mensagem mostraMesan ,
constraint pkusuario PRIMARY KEY (id)
);

Insert into usuario values(default, 'ADMIN', 'admin@universo.univates.br', 'admin', 'admin','Administrador',default);
Insert into usuario values(default, 'ALUNO', 'aluno.nunes@universo.univates.br', 'aluno', 'aluno','Estudante',default);

CREATE TABLE IF NOT EXISTS mensagem (
id serial,
mensagem text not null,
constraint pkmensagem PRIMARY KEY (id)
);

Insert into mensagem values(default, 'Tudo o que um sonho precisa para ser realizado é alguém que acredite que ele possa ser realizado.');
Insert into mensagem values(default, 'Evite desencorajar-se: mantenha ocupações e faça do otimismo a maneira de viver. Isso restaura a fé em si.');
Insert into mensagem values(default, 'Imagine uma nova história para sua vida e acredite nela.');
Insert into mensagem values(default, 'Lute. Acredite. Conquiste. Perca. Deseje. Espere. Alcance. Invada. Caia. Seja tudo o quiser ser, mas acima de tudo, seja você sempre.');
Insert into mensagem values(default, 'Diga o que você pensa com esperança.
Pense no que você faz com fé.
Faça o que você deve fazer com amor!');
Insert into mensagem values(default, 'Pessimismo leva à fraqueza, otimismo ao poder.');
Insert into mensagem values(default, ' O otimismo é a fé em ação. Nada se pode levar a efeito sem otimismo.');

ALTER TABLE usuario
ALTER COLUMN tipo TYPE character varying,
ALTER COLUMN mensagem TYPE character varying;

CREATE TABLE IF NOT EXISTS curso (idcurso SERIAL PRIMARY KEY,
				    			  nome VARCHAR(128) NOT NULL,
								  idusuario INTEGER REFERENCES usuario(id) ON DELETE CASCADE);
								  
CREATE TABLE IF NOT EXISTS disciplina (iddisciplina SERIAL PRIMARY KEY,
						 			   nome VARCHAR(128) NOT NULL,
						 			   datainicio DATE NOT NULL,
						 			   datatermino DATE NOT NULL,
						 			   domingo BOOLEAN NOT NULL,
						 			   segunda BOOLEAN NOT NULL,
						 			   terca BOOLEAN NOT NULL,
						 			   quarta BOOLEAN NOT NULL,
						 			   quinta BOOLEAN NOT NULL,
						 			   sexta BOOLEAN NOT NULL,
						 			   sabado BOOLEAN NOT NULL,
									   idcurso INTEGER REFERENCES curso(idcurso) ON DELETE CASCADE);
						 
CREATE TABLE IF NOT EXISTS tarefa (idtarefa SERIAL PRIMARY KEY,
								    nome VARCHAR(128) NOT NULL,
								    data DATE NOT NULL,
								    hora TIME NOT NULL,
								    descricao VARCHAR(1024),
								    status BOOLEAN NOT NULL,
								    iddisciplina INTEGER REFERENCES disciplina(iddisciplina) ON DELETE CASCADE);
					 
CREATE TABLE IF NOT EXISTS subtarefa (idsubtarefa SERIAL PRIMARY KEY,
					       			  nome VARCHAR(128) NOT NULL,
					       			  status BOOLEAN NOT NULL,
					       			  idtarefa INTEGER REFERENCES tarefa(idtarefa) ON DELETE CASCADE);