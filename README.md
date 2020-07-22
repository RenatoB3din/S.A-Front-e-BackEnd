<h3>#SCRIPT BANCO DE DADOS</h3>
<h5>#CRIAR E COLOCAR EM USO O BANCO DE DADOS</h5>
CREATE DATABASE sa_salesinventory_hmlg;</br>
USE sa_salesinventory_hmlg;
<h5>#INSERIR ROLES NO BANCO DE DADOS</h5>
<h6>OBS.: INSERIR SOMENTE APÓS RODAR O PROJETO</h6>
INSERT INTO role(name) VALUES('ROLE_SALLESMAN');</br>
INSERT INTO role(name) VALUES('ROLE_MANAGER');</br>
INSERT INTO role(name) VALUES('ROLE_AuserDMIN');</br>


<h5>#MODELO JSON</h5>

POST >>  http://localhost:8080/api/users</br>

{</br>
	&emsp;&emsp;"nome":"NATO MO QUERIDO",</br>
	&emsp;&emsp;"cpf": "99234567800",</br>
	&emsp;&emsp;"login":"natao",</br>
	&emsp;&emsp;"senha":"moquerido",</br>
	&emsp;&emsp;"email":"nato@moquerido.CM.BR",</br>
	&emsp;&emsp;"cargo":"donodaporratoda"</br>
}
</p>
