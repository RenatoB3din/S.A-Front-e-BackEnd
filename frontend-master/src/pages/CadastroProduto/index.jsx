import React, { useState } from 'react';
import './styles.css';

import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function CadastroProduto() {
    const [cdgBarras, setCdgBarras] = useState('');
    const [nome, setNome] = useState('');
    const [desc, setDesc] = useState('');
    const [unidade, setUnidade] = useState('');
    const [picture, setPicture] = useState(null);
    const [imgData, setImgData] = useState(null);
    const [valorVenda, setValorVenda] = useState('');


    const onChangePicture = e => {
        if (e.target.files[0]) {
            setPicture(URL.createObjectURL(e.target.files[0]));
            const reader = new FileReader();
            reader.addEventListener("load", () => {
            setImgData(reader.result);
        });
            reader.readAsDataURL(e.target.files[0]);
        }
    };
    
    async function lidarComCadastroProduto(e) {
        e.preventDefault();
 
        
            const data = {
                cdgBarras,
                nome,
                desc,
                unidade,
                valorVenda,
                picture,
                imgData
            };

            console.log(data);

            
        // try{
            //     await api.post('cadastroProduto', data);               // POST na API com o ENDPOINT
            
            
            //  } catch (err) {
                //     alert('Erro no cadastro, tente novamente.');
                //  }
            }
            

    function Reset() {
        setCdgBarras('');
        setNome('');
        setDesc('');
        setUnidade('');
        setValorVenda('');
     }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto', active: true},     
        { label: 'Vendas', link: '#home' },
        { label: 'Movimentação de Inventário', link: '/newinventory' },
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
                <h1>CADASTRO DE PRODUTO</h1>

                <form onSubmit={lidarComCadastroProduto}>

                <div>

                <fieldset >
                <legend>Nome do Produto</legend>
                    <input 
                        type="text"
                        placeholder="Nome Produto "
                        value={nome}
                        onChange={e => setNome(e.target.value)}
                    />  
                </fieldset> 

                <div className="input-group">

                <fieldset>
                <legend>Código de barras do Produto</legend>
                    <input 
                        type="number"
                        placeholder="Código de Barras"
                        value={cdgBarras}
                        onChange={e => setCdgBarras(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 220 }}>
                <legend>Unidade</legend>
                    <select
                        value={unidade}
                        onChange={e => setUnidade(e.target.value)}
                    >
                            <option                  
                                value="UnidadeA"
                                >Unidade A
                            </option>

                            <option
                                value="UnidadeB"
                                >Unidade B
                            </option>
                    </select>
                </fieldset>

                </div>

                <fieldset>
                <legend>Descrição do Produto</legend>
                    <textarea 
                        value={desc}
                        onChange={e => setDesc(e.target.value)}
                    /> 
                </fieldset>

                <div className="input-group">
                    <fieldset>
                        <legend>Imagem Produto</legend>
                            <input id="arquivo" style={{ width: 450 }} type="file"  className="btn btn-success" onChange={onChangePicture} />  
                    </fieldset>


                    <fieldset>
                    <legend>Porcentagem sobre as vendas</legend>
                        <input 
                            type="number"
                            placeholder="% Porcentagem sobre vendas"
                            value={valorVenda}
                            onChange={e => setValorVenda(e.target.value)}
                        />  
                    </fieldset> 
                </div>

            <div className="previewProfilePic" >
                <img className="playerProfilePic_home_tile" alt="teste"  src={picture && picture}></img>
              </div>

                    <div className="operacaoProduto">
                            <button id="btn_add" type="submit">Adicionar Produto</button>

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