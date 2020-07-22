<h3>#SCRIPT BANCO DE DADOS</h3>
<h5>#CRIAR E COLOCAR EM USO O BANCO DE DADOS</h5>
CREATE DATABASE sa_salesinventory_hmlg;</br>
USE sa_salesinventory_hmlg;
<h5>#INSERIR ROLES NO BANCO DE DADOS</h5>
<h6>OBS.: INSERIR SOMENTE APÓS RODAR O PROJETO</h6>
INSERT INTO role(name) VALUES('ROLE_SALLESMAN');</br>
INSERT INTO role(name) VALUES('ROLE_MANAGER');</br>
INSERT INTO role(name) VALUES('ROLE_userADMIN');</br>


<h5>#MODELO JSON</h5>

CADASTRAR UM USUÁRIO >>  http://localhost:8080/api/auth/signup</br>

{</br>
	&emsp;&emsp;"name":"Renato Bedin",</br>
	&emsp;&emsp;"username": "rb3din",</br>
	&emsp;&emsp;"email":"renatob3din@gmail.com",</br>
	&emsp;&emsp;"password":"123456",</br>
	&emsp;&emsp;"cpf":"10000778672",</br>
	&emsp;&emsp;"role":["admin"]</br> // ["manager"] // ["diferenteDosDoisPrimerios"] = Perfil de usuário 
}
</p>
