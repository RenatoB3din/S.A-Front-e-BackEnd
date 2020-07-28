import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';
import './styles.css';

import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function Venda() {
    const [nomeCliente, setNomeCliente] = useState('');
    const [cpfCliente, setCpfCliente] = useState('');
    const [vendedor, setVendedor] = useState('');
    const [codigoProduto, setCodigoProduto] = useState('');
    const [pagamento, setPagamento] = useState('');


    const history = useHistory();


    async function lidarComVenda(e) {
        e.preventDefault(); 

        const data = {
            nomeCliente,
            cpfCliente,
            vendedor,
            pagamento
        };

        try{
            const response = await api.post('vendas', data);

            console.log(`${response.data.id}`);


            history.push('/');

            reset();
         } catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }

    function reset() {
        setNomeCliente('');
        setCpfCliente('');
        setVendedor('');
        setPagamento('');
     }

    let links = [
        { label: 'Usuário', link: '/register'},
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda', active: true  },
        { label: 'Movimentar Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '#contact-us' },
      ];

    return (
        <div>
        <header>
            <Menu links={links} logo={logo} />
        </header>
        <div className="novoproduto-container">
        <div className="content">
            <section>
                <form onSubmit={lidarComVenda}>
                <div className="input-group">
                <fieldset >
                <legend>Nome do Cliente</legend>
                    <input 
                        type="text"
                        placeholder="Nome do Cliente"
                        value={nomeCliente}
                        onChange={e => setNomeCliente(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 300 }}>
                <legend>CPF/CNPJ</legend>
                    <input 
                        type="text"
                        placeholder="CPF"
                        value={cpfCliente}
                        onChange={e => setCpfCliente(e.target.value)}
                    />  
                </fieldset> 
                </div>

                <div className="input-group">
                <fieldset>
                <legend>Vendedor</legend>
                    <select
                        value={vendedor}
                        onChange={e => setVendedor(e.target.value)}
                    >       
                            <option value="" disabled ></option>
                            
                            <option                  
                                value="VendedorA"
                                >Vendedor A
                            </option>

                            <option
                                value="VendedorB"
                                >Vendedor B
                            </option>
                    </select>
                </fieldset>


                <fieldset style={{ width: 300 }}>
                <legend>Tipo de Pagamento</legend>
                    <select
                        value={pagamento}
                        onChange={e => setPagamento(e.target.value)}
                    >
                            <option                  
                                value="vista"
                                >À vista
                            </option>

                            <option
                                value="prazo"
                                >À prazo
                            </option>
                    </select>
                </fieldset>
                </div>

                <fieldset>
                <legend></legend>
                    <input id="cdgProduto"
                        type="text"
                        placeholder="Código Produto"
                        value={codigoProduto}
                        onChange={e => setCodigoProduto(e.target.value)}
                    />  
                </fieldset> 
                    
                </form>
            </section>
        </div>
        </div>
        </div>
    );
}