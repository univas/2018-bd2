INSERT INTO DEPARTMENT (CODE,NAME) VALUES (1, 'Vendas');
INSERT INTO DEPARTMENT (CODE,NAME) VALUES (2, 'Compras');
INSERT INTO DEPARTMENT (CODE,NAME) VALUES (3, 'Financeiro');

INSERT INTO ROLE (CODE, NAME, WAGE) VALUES (1, 'Analista de Sistema', 5000);
INSERT INTO ROLE (CODE, NAME, WAGE) VALUES (2, 'Vendedor', 2000);
INSERT INTO ROLE (CODE, NAME, WAGE) VALUES (3, 'Faxineiro', 1000);
INSERT INTO ROLE (CODE, NAME, WAGE) VALUES (4, 'Cozinheiro', 3000);

INSERT INTO EMPLOYEE (REGISTRY,NAME,ACTIVE,DEPARTMENT_CODE,ROLE_CODE) 
	VALUES (1, 'José', true, 1, 2);

INSERT INTO EMPLOYEE (REGISTRY,NAME,ACTIVE,DEPARTMENT_CODE,ROLE_CODE) 
	VALUES (2, 'João', false, 2, 3);

INSERT INTO EMPLOYEE (REGISTRY,NAME,ACTIVE,DEPARTMENT_CODE,ROLE_CODE) 
	VALUES (3, 'Josie', true, 2, 1);

INSERT INTO EMPLOYEE (REGISTRY,NAME,ACTIVE,DEPARTMENT_CODE,ROLE_CODE) 
	VALUES (4, 'Jane', true, 2, 3);

INSERT INTO EMPLOYEE (REGISTRY,NAME,ACTIVE,DEPARTMENT_CODE,ROLE_CODE) 
	VALUES (5, 'Joaquim', true, null, 3);

