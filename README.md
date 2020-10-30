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
	&emsp;&emsp;"name": "Renato Bedin",</br>
	&emsp;&emsp;"username": "rb3din",</br>
	&emsp;&emsp;"email": "renatob3din@gmail.com",</br>
	&emsp;&emsp;"password": "123456",</br>
	&emsp;&emsp;"cpf": "10000778672",</br>
	&emsp;&emsp;"role": ["admin"] // ["manager"] // ["diferenteDosDoisPrimerios"] = Perfil de usuário </br>
}


REALIZAR LOGIN >>  http://localhost:8080/api/auth/sigin</br>

{</br>
	&emsp;&emsp;"username": "rb3din",</br>
	&emsp;&emsp;"password": "123456",</br>
}</br>

CADASTRO DE FORNECEDOR >> http://localhost:8080/provider/register </br>
{</br>
&emsp;&emsp;"nomeFantasia":"nomeFantasia",</br>
&emsp;&emsp;"razaoSocial":"razaoSocial",</br>
&emsp;&emsp;"cnpj":"cnpj",</br>
&emsp;&emsp;"nomeContato":"nomeContato",</br>
&emsp;&emsp;"telefone":"telefone",</br>
&emsp;&emsp;"email":"email",</br>
&emsp;&emsp;"fornecedorEnderecos":[{</br>
&emsp;&emsp;&emsp;&emsp;"cep":"cep",</br>
&emsp;&emsp;&emsp;&emsp;"logradouro":"rua",</br>
&emsp;&emsp;&emsp;&emsp;"complemento":"numero",</br>
&emsp;&emsp;&emsp;&emsp;"outroComplemento":"complemento",</br>
&emsp;&emsp;&emsp;&emsp;"bairro":"bairro",</br>
&emsp;&emsp;&emsp;&emsp;"localidade":"municipio",</br>
&emsp;&emsp;&emsp;&emsp;"uf":"uf"</br>
&emsp;&emsp;&emsp;&emsp;"tipoEndereco":"RESIDENCIAL"</br>
&emsp;&emsp;}]</br>
}</br>


CADASTRO DE PRODUTO >> http://localhost:8080/product/register </br>
{</br>
&emsp;&emsp;"cdgProduto":"cdgProduto",</br>
&emsp;&emsp;"nomeProduto":"nomeProduto",</br>
&emsp;&emsp;"descricaoProduto":"descricaoProduto",</br>
&emsp;&emsp;"codBarras":"codBarras",</br>
&emsp;&emsp;"unidade":"unidade",</br>
&emsp;&emsp;"percentualSobreVenda":1,</br>
&emsp;&emsp;"imagemURL":"imagemURL"</br>
}</br>

CADASTRO DE MOVIMENTO ESTOQUE >> http://localhost:8080/stockMovement/register/provider/{idProvider}</br>
{</br>
&emsp;&emsp;"nrNotaFiscal":"0000005",</br>
&emsp;&emsp;"dataNotaFiscal":"28/07/2020",</br>
&emsp;&emsp;"imgNotaFiscal":"imgNotaFiscal",</br>
&emsp;&emsp;"tipoMovimento":"MOV_COMPRA"</br>
}</br>

CADASTRO DE MOVIMENTO ESTOQUE ITEM >> http://localhost:8080/stockMovement/register/moviment/{idMoviment}/product/{idProduct}</br>
Obs.: da forma que está hoje, cada vez que é inserido um item na movimentação, já incluí o mesmo no banco de dados.
{</br>
&emsp;&emsp;"valor":40,</br>
&emsp;&emsp;"qtde":400</br>
}</br>

CADASTRO DE VENDA >> http://localhost:8080/sales/register</br>
{</br>
&emsp;&emsp;"dataVenda":"30/10/2020",</br>
&emsp;&emsp;"nomeCliente":"Leo Lemos",</br>
&emsp;&emsp;"cpfCnpj": "00742215903",</br>
&emsp;&emsp;"nomeVendedor":"RB3d1n",</br>
&emsp;&emsp;"tipoMovimento":"MOV_VENDA"</br>
}</br>

CADASTRO DE VENDA ITEM >> http://localhost:8080/sales/register/sales/{idSales}/product/{idProduct}</br>
{</br>
&emsp;&emsp;"nrItemVenda":1,</br>
&emsp;&emsp;"qtde":2,</br>
&emsp;&emsp;"valorUnitario":25,</br>
&emsp;&emsp;"valorDesconto": 5</br>
}</br>

</p>


<h5>#FRONTEND</h5>
<h6>Ao clonar o projeto, inserir no terminal:</h6> 
" npm install (--save "opcional") " </br></br>

<h6>Subindo o projeto em React:</h6> 
" npm start "</br>

<h6>Rotas:</h6> 
/                     [login]</br>
/register             [cadastro usuário]</br>
/novoproduto          [cadastro produto]</br>
/novofornecedor       [cadastro fornecedor]</br>
/newinventory         [movimentação de inventário]</br>
