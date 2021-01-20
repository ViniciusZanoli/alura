-- QUANDO TEM ESSE ARQUIVO data.sql NO RESOURCES O SPRING EXECUTA ESSAS LINHAS DE COMANDO PARA INSERIR OS DADOS
-- NESSA CASO EM NOSSO H2
INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', 123456);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML', 'Front-End');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Dúvida 1', 'error 123', '2019-05-05', 'NAO_RESPONDIDO', '1', '1');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Dúvida 2', 'error 456', '2019-05-09', 'NAO_RESPONDIDO', '1', '1');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
VALUES('Dúvida 3', 'error 789', '2019-05-15', 'NAO_RESPONDIDO', '1', '2');