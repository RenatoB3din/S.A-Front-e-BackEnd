import React, { useState, useEffect } from 'react';

// import api from '../../services/api';
import apiexterna from '../../services/apiexterna';
import './styles.css';

import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';



export default function CadastroFornecedor() {

    const [nomefantasia, setNomeFantasia] = useState('');
    const [razaosocial, setRazaoSocial] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [cep, setCep] = useState('');
    const [logradouro, setLogradouro] = useState('');
    const [complemento, setComplemento] = useState('');
    const [bairro, setBairro] = useState('');
    const [localidade, setLocalidade] = useState('');
    const [uf, setUf] = useState('');
    const [outroComplemento, setOutroComplemento] = useState('');
    const [nomeresponsavel, setNomeResponsavel] = useState('');
    const [telefoneresponsavel, setTelefoneResponsavel] = useState('');
    const [emailresponsavel, setEmailResponsavel] = useState('');
    const [query, setQuery] = useState('');
    const [url, setUrl] = useState(
        `${query}/json/`,
    );

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
        setNomeResponsavel('');
        setTelefoneResponsavel('');
        setEmailResponsavel('');
     }

        
            useEffect(() => { 
                if(query.length === 8) {
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
            nomefantasia,
            razaosocial,
            cnpj,
            cep,
            logradouro,
            complemento,
            bairro,
            localidade,
            uf,
            outroComplemento,
            nomeresponsavel,
            telefoneresponsavel,
            emailresponsavel
        };

        console.log(data)

        // try{
        //     await api.post('CadastroFornecedor', data);      // POST na API com o ENDPOINT


        //  } catch (err) {
        //     alert('Erro no cadastro, tente novamente.');
        //  }
    }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor', active: true},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '#home' },
        { label: 'Movimentação de Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '#contact-us' },
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
                            value={nomefantasia}
                            onChange={e => setNomeFantasia(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset >
                    <legend>Razão Social</legend>
                        <input 
                            type="text"
                            placeholder="Razão Social"
                            value={razaosocial}
                            onChange={e => setRazaoSocial(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset >
                    <legend>CNPJ</legend>
                        <input 
                            type="text"
                            placeholder="CNPJ"
                            value={cnpj}
                            onChange={e => setCnpj(e.target.value)}
                        />  
                    </fieldset> 


                    <h2>Endereço</h2>

                    <div className="input-group">
                    <fieldset >
                    <legend>CEP</legend>
                        <input 
                            type="number"
                            value={query}
                            onChange={event => setQuery(event.target.value)}
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

                    <fieldset>
                    <legend>Complemento</legend>
                        <input 
                            type="text"
                            placeholder="Complemento"
                            value={outroComplemento}
                            onChange={e => setOutroComplemento(e.target.value)}
                        />  
                    </fieldset> 

                    <h2>Responsável</h2>
                    <fieldset>
                    <legend>Nome </legend>
                        <input 
                            type="text"
                            placeholder="Nome do Responsável"
                            value={nomeresponsavel}
                            onChange={e => setNomeResponsavel(e.target.value)}
                        />  
                    </fieldset> 

                    <div className="input-group">
                    <fieldset style={{ width: 380 }}>
                    <legend>Telefone </legend>
                        <input 
                            type="number"
                            placeholder="Telefone do Responsável"
                            value={telefoneresponsavel}
                            onChange={e => setTelefoneResponsavel(e.target.value)}
                        />  
                    </fieldset> 

                    <fieldset>
                    <legend>E-mail </legend>
                        <input 
                            type="email"
                            placeholder="E-mail do Responsável"
                            value={emailresponsavel}
                            onChange={e => setEmailResponsavel(e.target.value)}
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
