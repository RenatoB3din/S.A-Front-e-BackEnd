<h3>#SCRIPT BANCO DE DADOS</h3>
<h5>#CRIAR E COLOCAR EM USO O BANCO DE DADOS</h5>
CREATE DATABASE sa_salesinventory_hmlg;</br>
USE sa_salesinventory_hmlg;
<h5>#INSERIR ROLES NO BANCO DE DADOS</h5>
<h6>OBS.: INSERIR SOMENTE APÓS RODAR O PROJETO</h6>
INSERT INTO role(name) VALUES('ROLE_SALLESMAN');</br>
INSERT INTO role(name) VALUES('ROLE_MANAGER');</br>
INSERT INTO role(name) VALUES('ROLE_AuserDMIN');</br>


#MODELO JSON

POST >>  http://localhost:8080/api/users

{
	"nome":"NATO MO QUERIDO",
	"cpf": "99234567800",
	"login":"natao",
	"senha":"moquerido",
	"email":"nato@moquerido.CM.BR",
	"cargo":"donodaporratoda"
	
}


{
	"nomeProduto":"PRODUTO 001",
	"descricaoProduto":"PRODUTO 001",
	"codBarras":"1234567890000",
	"unidadeMovimento":"UN",
	"qtdEstoqueAtual":100.00,
	"valorCompra":15.00
}


{
	"razaoSocial":"FORNECEDOR 001",
	"nomeFantasia":"FORNECEDOR 001 FANTASIA",
	"cnpj":"12345678000111",
	"fornecedorEnderecos":[{
		"cep":"88117420",
		"rua":"RUA DO ENDERECO",
		"numero":"123456",
		"complemento":"COMPLEMENTO DO ENDERECO",
		"bairro":"BAIRRO DO ENDERECO",
		"municipio":"MUNICIPIO DO ENDERECO",
		"uf":"UF",
		"referencia":"REFERENCIA DO ENDERECO",
	}]
	"fornecedorContatos":[{
		"nomeContato":"CONTATO DO FORNECEDOR",
		"nrTelefone":"12345678900",
		"emailContato":"FORNECEDOR@FORNECEDOR.COM.BR",
	}]
}
