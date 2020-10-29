import React, { useState, useEffect } from 'react';

import api from '../../services/api';
import apiexterna from '../../services/apiexterna';
import './styles.css';
import {mask, unMask} from "remask";


import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

import { useHistory } from 'react-router-dom';


export default function CadastroFornecedor() {

    const [nomeFantasia, setNomeFantasia] = useState('');
    const [razaoSocial, setRazaoSocial] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [cep, setCep] = useState('');
    const [logradouro, setLogradouro] = useState('');
    const [complemento, setComplemento] = useState('');
    const [bairro, setBairro] = useState('');
    const [localidade, setLocalidade] = useState('');
    const [uf, setUf] = useState('');
    const [outroComplemento, setOutroComplemento] = useState('');
    const [tipoEndereco, setTipoEndereco] = useState('');
    const [nomeContato, setNomeContato] = useState('');
    const [telefone, setTelefone] = useState('');
    const [email, setEmail] = useState('');
    const [query, setQuery] = useState('');
    const [url, setUrl] = useState(
        `${query}/json/`,
    );

    const history = useHistory();
    const token = localStorage.getItem('token');
    const pattern = '99999-999';

        const MascararCNPJ = ev => {
            setCnpj(mask(ev.target.value, ['99.999.999/9999-99']))
        };

        const MascararCEP = ev => {
            setQuery(mask(ev.target.value, pattern))
        };

        const MascararTEL = ev => {
            const originalValue = unMask(ev.target.value);
            const maskedValue = mask(originalValue, [
                '(99)9999-9999',
                '(99)9 9999-9999'
            ]);
            setTelefone(maskedValue);
        };

    if(token === null){
        history.push('/');
    }  



    function Reset() {
        setNomeFantasia('');
        setRazaoSocial('');
        setCnpj('');
        setCep('');
        setLogradouro('');
        setComplemento('');
        setBairro('');
        setLocalidade('');
        setUf('');
        setOutroComplemento('');
        setNomeContato('');
        setTelefone('');
        setEmail('');
     }

        
            useEffect(() => { 
                if(query.length === 9) {
                    const fetchData = async () => {
                    const result = await apiexterna.get(url);
                
                    setLogradouro(result.data.logradouro);
                    setComplemento(result.data.complemento);
                    setBairro(result.data.bairro);
                    setLocalidade(result.data.localidade);
                    setUf(result.data.uf);  
                    setCep(result.data.cep);  
                    // console.log(result.data)
                };
            fetchData();
            }}, [url]);
        

        
    


    async function lidarComCadastroFornecedor(e) {
        e.preventDefault();

        const data = {
            nomeFantasia,
            razaoSocial,
            cnpj,
            nomeContato,
            telefone,
            email,
            cep,
            logradouro,
            complemento,
            bairro,
            localidade,
            uf,
            outroComplemento,
            tipoEndereco 
        };

        console.log(data)
        console.log(token)

        try{
            await api.post('provider/register', data, {
                headers: {
                    Authorization: `Bearer ${token}`,
                }
            });      // POST na API com o ENDPOINT

            history.push('/novofornecedor');

            Reset();

         } catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor', active: true},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda' },
        { label: 'Movimentar Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '/relatorio' },
      ];

    return (
        <div>
        <header>
            <Menu links={links} logo={logo} />
        </header>
        <div className="novofornecedor-container">
        <div className="content">
            <section>
                <h1>CADASTRO DE FORNECEDORES</h1>

                <form id="cad_form" onSubmit={lidarComCadastroFornecedor}>
                
                <div>

                    <fieldset >
                    <legend>Nome Fantasia</legend>
                        <input 
                            type="text"
                            placeholder="Nome Fantasia"
                            value={nomeFantasia}
                            onChange={e => setNomeFantasia(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset >
                    <legend>Razão Social</legend>
                        <input 
                            type="text"
                            placeholder="Razão Social"
                            value={razaoSocial}
                            onChange={e => setRazaoSocial(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset >
                    <legend>CNPJ</legend>
                        <input 
                            type="text"
                            placeholder="CNPJ"
                            value={cnpj}
                            onChange={MascararCNPJ}
                        />  
                    </fieldset> 

                    <h2>Endereço</h2>

                    <div className="input-group">
                    <fieldset >
                    <legend>CEP</legend>
                        <input 
                            type="text"
                            value={query}
                            // onChange={event => setQuery(event.target.value)}
                            onChange={MascararCEP}
                        />  
                    </fieldset> 

                    <fieldset style={{ width: 150 }}>
                        <button 
                        id="btn_cep"
                        type="button"
                        onClick={() =>
                        setUrl(`${query}/json/`)
                        }
                        >
                            
                        </button>
                    </fieldset>
                    </div>

                    <div className="input-group">
                    <fieldset >
                    <legend>Rua</legend>
                        <input 
                            type="text"
                            placeholder="Nome da Rua"
                            value={logradouro}
                            onChange={e => setLogradouro(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset style={{ width: 220 }}>
                    <legend>Nº</legend>
                        <input 
                            type="text"
                            placeholder="Número"
                            value={complemento}
                            onChange={e => setComplemento(e.target.value)}
                        />  
                    </fieldset>
                    </div> 


                    <div className="input-group">
                    <fieldset >
                    <legend>Bairro</legend>
                        <input 
                            type="text"
                            placeholder="Bairro"
                            value={bairro}
                            onChange={e => setBairro(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset >
                    <legend>Município</legend>
                        <input 
                            type="text"
                            placeholder="Município"
                            value={localidade}
                            onChange={e => setLocalidade(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset style={{ width: 300 }}>
                    <legend>Estado</legend>
                        <input 
                            type="text"
                            placeholder="Estado"
                            value={uf}
                            onChange={e => setUf(e.target.value)}
                        />  
                    </fieldset> 
                    </div>
                    
                    <div className="input-group">
                    <fieldset>
                    <legend>Complemento</legend>
                        <input 
                            type="text"
                            placeholder="Complemento"
                            value={outroComplemento}
                            onChange={e => setOutroComplemento(e.target.value)}
                        />  
                    </fieldset> 
                    
                    <fieldset style={{ width: 220 }}>
                    <legend>Tipo de Endereço</legend>
                        <select
                            value={tipoEndereco}
                            onChange={e => setTipoEndereco(e.target.value)}
                        >
                            <option value="" disabled ></option>
                            
                            <option                  
                                value="RESIDENCIAL"
                                >Residencial
                            </option>

                            <option
                                value="COMERCIAL"
                                >Comercial
                            </option>
                            <option
                                value="FATURAMENTO"
                                >Faturamento
                            </option>
                            <option
                                value="COBRANCA"
                                >Cobrança
                            </option>
                            <option
                                value="ENTREGA"
                                >Entrega
                            </option>
                        </select>
                    </fieldset>

                    </div>

                    <h2>Responsável</h2>
                    <fieldset>
                    <legend>Nome </legend>
                        <input 
                            type="text"
                            placeholder="Nome do Responsável"
                            value={nomeContato}
                            onChange={e => setNomeContato(e.target.value)}
                        />  
                    </fieldset> 

                    <div className="input-group">
                    <fieldset style={{ width: 380 }}>
                    <legend>Telefone </legend>
                        <input 
                            type="text"
                            placeholder="Telefone do Responsável"
                            value={telefone}
                            onChange={MascararTEL}
                        />  
                    </fieldset> 

                    <fieldset>
                    <legend>E-mail </legend>
                        <input 
                            type="email"
                            placeholder="E-mail do Responsável"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />  
                    </fieldset> 

                    </div>

                    
                    <div className="operacaoProduto">
                        <button id="btn_add" type="submit">Adicionar Fornecedor</button>

                        <button id="btn_cancel" onClick={Reset} >Cancelar Operação</button>
                    </div>



                </div>
                </form>
            </section>
        </div>
        </div>
        </div>
    );   
}
