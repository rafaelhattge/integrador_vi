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
