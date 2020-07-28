import React, { useState } from 'react';
import './styles.css';
import api from '../../services/api';
import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function CadastroProduto() {
    const [codBarras, setCodBarras] = useState('');
    const [nomeProduto, setNomeProduto] = useState('');
    const [descricaoProduto, setDescricaoProduto] = useState('');
    const [unidade, setUnidade] = useState('');
    const [imagemURL, setImagemURL] = useState(null);
    const [imgData, setImgData] = useState(null);
    const [percentualSobreVenda, setPercentualSobreVenda] = useState('');

    const token = localStorage.getItem('token');

    const onChangePicture = e => {
        if (e.target.files[0]) {
            setImagemURL(URL.createObjectURL(e.target.files[0]));
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
                codBarras,
                nomeProduto,
                descricaoProduto,
                unidade,
                percentualSobreVenda,
                imagemURL
            };

            console.log(data);

            
            try{
                await api.post('product/register', data, {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    }
                });               // POST na API com o ENDPOINT
            
            
            } catch (err) {
                    alert('Erro no cadastro, tente novamente.');
                 }
            }
            

    function Reset() {
        setCodBarras('');
        setNomeProduto('');
        setDescricaoProduto('');
        setUnidade('');
        setPercentualSobreVenda('');
     }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto', active: true},     
        { label: 'Vendas', link: '/venda' },
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
                <h1>CADASTRO DE PRODUTO</h1>

                <form onSubmit={lidarComCadastroProduto}>

                <div>

                <fieldset >
                <legend>Nome do Produto</legend>
                    <input 
                        type="text"
                        placeholder="Nome Produto "
                        value={nomeProduto}
                        onChange={e => setNomeProduto(e.target.value)}
                    />  
                </fieldset> 

                <div className="input-group">

                <fieldset>
                <legend>Código de barras do Produto</legend>
                    <input 
                        type="number"
                        placeholder="Código de Barras"
                        value={codBarras}
                        onChange={e => setCodBarras(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 220 }}>
                <legend>Unidade</legend>
                    <select
                        value={unidade}
                        onChange={e => setUnidade(e.target.value)}
                    >
                            <option value="" disabled ></option>

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
                        value={descricaoProduto}
                        onChange={e => setDescricaoProduto(e.target.value)}
                    /> 
                </fieldset>

                <div className="input-group">
                    <fieldset>
                        <legend>Imagem Produto</legend>
                            <input id="img_produto" style={{ width: 450 }} type="file"  className="btn btn-success" onChange={onChangePicture} />  
                    </fieldset>


                    <fieldset>
                    <legend>Porcentagem sobre as vendas</legend>
                        <input 
                            type="number"
                            placeholder="% Porcentagem sobre vendas"
                            value={percentualSobreVenda}
                            onChange={e => setPercentualSobreVenda(e.target.value)}
                        />  
                    </fieldset> 
                </div>

            {/* <div className="previewProfilePic" >
                <img className="playerProfilePic_home_tile" alt="teste"  src={picture && picture}></img>
              </div> */}

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