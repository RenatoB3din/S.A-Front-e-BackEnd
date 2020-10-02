import React, { useState } from 'react';
import { BsUpload } from 'react-icons/bs'

import api from '../../services/api';
import './styles.css';

import { storage } from '../../components/Firebase/firebaseConfig';
import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function InventoryMovement() {
    const [nf, setNf] = useState('');                              
    const [tipomovimento, setTipomovimento] = useState('');
    const [datanf, setDatanf] = useState('');
    const [fornecedor, setFornecedor] = useState('');
    const [produto, setProduto] = useState('');
    const [quantidade, setQuantidade] = useState('');
    const [valor, setValor] = useState('');
    const [lote, setLote] = useState('');
    const [validade, setValidade] = useState('');
    const [image, setImage] = useState(null);
    const [imagemURL, setImagemUrl] = useState("");
    const [progress, setProgress] = useState(0);
    const [error, setError] = useState("");



    // useEffect(() => {
    //     api.get('inventorytemporary')
    //     .then(response => {
    //         setProdutos(response.data);
    //     })
    // })

    function Reset(e) {
        e.preventDefault();
        
        setNf('');
        setTipomovimento('');
        setDatanf('');
        setFornecedor('');
        setProduto('');
        setQuantidade('');
        setValor('');
        setLote('');
        setValidade('');
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

    async function handleInventory(e) {
        e.preventDefault();                 // Não atualiza a página ao dar submit

        const data = {                      // Dados armazanados via input para o POST!
            nf,
            tipomovimento,
            datanf,
            fornecedor,
            produto,
            quantidade,
            valor,
            lote,
            validade,
            imagemURL
        };

        try{
            await api.post('inventory', data);               // POST na API com o ENDPOINT


         } catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda' },
        { label: 'Movimentar Inventário', link: '/newinventory', active: true },
        { label: 'Relatórios', link: '/relatorio' },
      ];

    return (
        <div>
        <header>
            <Menu links={links} logo={logo} />
        </header>
        <div className="movinventory-container">
        <div className="content">
            <section>
                <h1>MOVIMENTAÇÃO DE ESTOQUE</h1>

                <form onSubmit={handleInventory}>

                <fieldset>
                    <legend>Tipo de Movimento</legend>
                        <select 
                            value={tipomovimento}
                            onChange={e => setTipomovimento(e.target.value)}
                        >
                            <option value="" disabled ></option>

                            <option                  
                                value="Compra"
                                >Compra
                            </option>

                            <option
                                value="DevolucaooFornecedor"
                                >Devolução Fornecedor
                            </option>

                            <option
                                value="DevolucaoCliente"
                                >Devolução Cliente
                            </option>
                        </select>
                </fieldset>
                    
                <div className="input-group">
                    <fieldset style={{ width: 200 }}>
                        <legend>Número da NF</legend>
                            <input 
                                type="number"
                                placeholder="Nota Fiscal "
                                value={nf}
                                onChange={e => setNf(e.target.value)}
                            />       
                    </fieldset>

                    <fieldset style={{ width: 200 }} >
                        <legend>Data da NF</legend>
                            <input 
                                type="date" 
                                style={{ width: 280 }} 
                                value={datanf}
                                onChange={e => setDatanf(e.target.value)}
                            />
                    </fieldset>

                    <fieldset>
                        <legend>Imagem NF</legend>
                            <input id="img_nf" style={{ width: 500}} type="file" name="arquivos" onChange={handChange} /> 

                            <div style={{ height: "5px" }}>
                                {progress > 0? <progress value={progress} max="100" /> : ""}
                                <p style={{color: "red" }}>{error}</p>
                            </div>
                    </fieldset>

                    <fieldset style={{ width: 0}}>
                        <button id="btn_upload" onClick={handleUpdate}> <BsUpload/> </button> 
                        </fieldset>
                </div>
                        
                    <fieldset>
                        <legend>Fornecedor</legend>
                        <select 
                            value={fornecedor}
                            onChange={e => setFornecedor(e.target.value)}
                        >
                            <option value="" disabled ></option>

                            <option                  
                                value="FornecedorA"
                                >Fornecedor A
                            </option>

                            <option
                                value="FornecedorB"
                                >Fornecedor B
                            </option>

                            <option
                                value="FornecedorC"
                                >Fornecedor C
                            </option>    
                        </select>
                    </fieldset>

                <div className="input-group">
                    <fieldset>
                        <legend>Produto</legend>
                        <select 
                            value={produto}
                            onChange={e => setProduto(e.target.value)}
                            >
                        <option value="" disabled ></option>

                        <option                  
                            value="ProdutoA"
                            >Produto A
                        </option>

                        <option
                            value="ProdutoB"
                            >Produto B
                        </option>

                        <option
                            value="ProdutoC"
                            >Produto C
                        </option>  

                        </select>
                    </fieldset>

                        <fieldset style={{ width: 180 }} >
                            <legend>Quantidade de Produtos</legend>
                            <input 
                                type="number" 
                                style={{ width: 180 }} 
                                placeholder="Quantidade"
                                value={quantidade}
                                onChange={e => setQuantidade(e.target.value)}
                                />
                        </fieldset>
                    </div>
                        

                    <div className="input-group">
                        <fieldset>
                            <legend>Valor Unitário</legend>
                            <input 
                                type="number" 
                                placeholder="Valor: R$ 000,00"
                                value={valor}
                                onChange={e => setValor(e.target.value)}
                                /> 
                        </fieldset>

                        <fieldset style={{ width: 220 }}>
                            <legend>Lote</legend>
                            <input 
                                type="number"
                                style={{ width: 220 }} 
                                placeholder="Lote"
                                value={lote}
                                onChange={e => setLote(e.target.value)}
                                />
                        </fieldset>

                        <fieldset style={{ width: 220 }} >
                            <legend>Validade</legend>
                                <input 
                                    type="date"
                                    style={{ width: 220 }} 
                                    value={validade}
                                    onChange={e => setValidade(e.target.value)}
                                    />
                        </fieldset>
                        

                    </div>
                        <div className="operacaoProduto">
                            <button id="btn_add" type="submit">Movimentar Inventário</button>

                            <button id="btn_cancel" onClick={Reset} >Cancelar Operação</button>
                        </div>

                </form>
             
                </section>
            </div>
        </div>
    </div>
    );
}