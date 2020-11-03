import React, { useState } from 'react';
import api from '../../services/api';
import {storage} from '../../components/Firebase/firebaseConfig';
import { BsUpload } from 'react-icons/bs'
import { MdAddCircleOutline } from 'react-icons/md'

import './styles.css';
import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';
import Modal from '../../components/Modal/Modal';

import { useHistory } from 'react-router-dom';

export default function CadastroProduto() {
    const [codBarras, setCodBarras] = useState('');
    const [cont, setCont] = useState(0);
    const [cdgProduto, setCdgProduto] = useState(0);
    const [nomeProduto, setNomeProduto] = useState('');
    const [descricaoProduto, setDescricaoProduto] = useState('');
    const [unidade, setUnidade] = useState('');
    const [image, setImage] = useState(null);
    const [imagemURL, setImagemUrl] = useState("");
    const [progress, setProgress] = useState(0);
    const [error, setError] = useState("");
    const [percentualSobreVenda, setPercentualSobreVenda] = useState('');

    const [isModalVisible, setIsModalVisible] = useState(false);



 

    const history = useHistory();
    const token = localStorage.getItem('token');

    if(token === null){
        history.push('/');
    }


    function gerarCodigo(e) {
        e.preventDefault();
        if (cont === 0) {
            const btncdg = document.getElementById("btn_Cdg");
            setCdgProduto(Math.floor(Math.random() * (10000000 - 1000000)) + 1000000);
            btncdg.style.disabled = true;
            setCont(1);
        }
    }

    const handChange = e => {
        const file = e.target.files[0];
        if(file) {
            const fileType = file["type"];
            const validImageTypes = ["image/gif", "image/jpeg", "image/png"];
            if (validImageTypes.includes(fileType)) {
                setError("");
                setImage(file);
            } else {
                setError("Favor selecionar uma imagem para Upload")
            }
        }
    };


    const handleUpdate = (e) => {
        e.preventDefault();
        if(image) {
            const uploadTask = storage.ref(`images/${image.name}`).put(image)

            uploadTask.on(
                "state_changed",
                snapshot => {
                    const progress = Math.round(
                        (snapshot.bytesTransferred / snapshot.totalBytes) * 100 
                    );
                    setProgress(progress);
                },
                error => {
                    setError(error);
                },
                () => {
                    storage
                        .ref("images")
                        .child(image.name)
                        .getDownloadURL().then(url => {
                            setImagemUrl(url)
                            setProgress(0);
                    })
                }
                );
        } else {
            setError("Erro, favor escolher uma imagem para Upload");
        }
    };
    
    function Reset() {
        setCodBarras('');
        setNomeProduto('');
        setDescricaoProduto('');
        setUnidade('');
        setPercentualSobreVenda('');
        setCdgProduto('');
        setImagemUrl('');
        setImage(null);
        setCont(0);
     }
    
    
    async function lidarComCadastroProduto(e) {
        e.preventDefault();

            
           
            const data = {
                codBarras,
                nomeProduto,
                descricaoProduto,
                unidade,
                percentualSobreVenda,
                imagemURL,
                cdgProduto
            };

            console.log(data);

            
            try{
                await api.post('product/register', data, {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    }
                });  
                
                setIsModalVisible(true)

                history.push('/novoproduto');

                Reset();

            } catch (err) {
                    alert('Erro no cadastro, tente novamente.');
             }

             
        }
            


    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto', active: true},     
        { label: 'Vendas', link: '/venda' },
        { label: 'Movimentar Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '/relatorio' },
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
                
                {isModalVisible ? 
                    <Modal onClose={() => setIsModalVisible(false) }>
                        Realizado com sucesso!
                    </Modal>
                : null}

                <form onSubmit={lidarComCadastroProduto}>

                <div>

                <div className="input-group">
                <fieldset >
                <legend>Nome do Produto</legend>
                    <input 
                        type="text"
                        placeholder="Nome Produto "
                        value={nomeProduto}
                        onChange={e => setNomeProduto(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 225 }}>
                <legend>Código do Produto</legend>
                    <input 
                        disabled
                        type="text"
                        placeholder=""
                        value={cdgProduto}
                        onChange={e => setCdgProduto(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 0 }}>
                        <button disabled id="btn_Cdg" type="" onMouseOver={gerarCodigo}><MdAddCircleOutline/></button> 
                    </fieldset>
                </div>

                <div className="input-group">

                <fieldset >
                <legend>Código de barras do Produto</legend>
                    <input 
                        type="number"
                        placeholder="Código de Barras"
                        value={codBarras}
                        onChange={e => setCodBarras(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 180 }}>
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

                <div className="input-group">
                <fieldset>
                <legend>Descrição do Produto</legend>
                    <textarea 
                        style={{ resize: "none" }} 
                        value={descricaoProduto}
                        onChange={e => setDescricaoProduto(e.target.value)}
                    /> 
                </fieldset>

                <fieldset style={{ width: 180 }}>
                    <legend>Inflação do Produto</legend>
                        <input 
                            type="number"
                            placeholder="0.0%"
                            value={percentualSobreVenda}
                            onChange={e => setPercentualSobreVenda(e.target.value)}
                        />  
                    </fieldset> 
                    </div>

                <div className="input-img" >
                    <fieldset>
                        <legend>Imagem Produto</legend>
                            <input id="img_produto" style={{ width: 500, height:55  }} type="file"  className="btn btn-success" onChange={handChange} /> 
        
                            <div style={{ height: "100px" }}>
                                {progress > 0? <progress value={progress} max="100" /> : ""}
                                <p style={{color: "red" }}>{error}</p>
                            </div>
                    </fieldset>

                    <fieldset>
                        <button id="btn_upload" onClick={handleUpdate}> <BsUpload/> </button> 
                    </fieldset>

                </div>

                    <div className="imgproduto">
                        <img id="imgdoproduto" src={imagemURL} alt={nomeProduto}></img>
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