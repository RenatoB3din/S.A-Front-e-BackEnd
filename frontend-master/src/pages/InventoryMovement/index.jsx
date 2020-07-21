import React, { useState } from 'react';

// import TableInventory from '../../components/InventoryTable/TabelaProdutos'
import api from '../../services/api';
import './styles.css';

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
    const [imagemnf, setImagemnf] = useState('');

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
            imagemnf
        };

        try{
            await api.post('inventory', data);               // POST na API com o ENDPOINT


         } catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }


    async function handleInventoryTemporary(e) {
        e.preventDefault(); // Não atualiza a pág ao dar submit

        const data = {
            produto,
            quantidade,
            valor,
            lote,
            validade
        };

        try{
            await api.post('inventorytemporary', data);


         } catch (err) {
            alert('Erro na listagem do produto, tente novamente.');
         }
    }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '#home' },
        { label: 'Movimentação de Inventário', link: '/newinventory', active: true },
        { label: 'Relatórios', link: '#contact-us' },
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

                <div>

                <fieldset>
                    <legend>Tipo de Movimento</legend>
                        <select 
                            value={tipomovimento}
                            onChange={e => setTipomovimento(e.target.value)}
                        >
                            <option value="" data-default disabled selected></option>

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

                    </div>
                    
                    <div className="input-group">
                    
                    <fieldset>
                        <legend>Número da NF</legend>

                            <input 
                                type="number"
                                placeholder="Nota Fiscal "
                                value={nf}
                                onChange={e => setNf(e.target.value)}
                            />
                            
                    </fieldset>

                    <fieldset style={{ width: 280 }} >
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

                            <input id="img_nf" style={{ width: 450 }} type="file" name="arquivos" class="btn btn-success"  accept="image/png, image/jpeg" value={imagemnf} onChange={e => setImagemnf(e.target.value)} multiple /> 
                            
                    </fieldset>

                    </div>
                        
                    <div>

                    <fieldset>
                        <legend>Fornecedor</legend>
                        <select 
                            value={fornecedor}
                            onChange={e => setFornecedor(e.target.value)}
                        >
                            <option value="" data-default disabled selected></option>

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
                        
                    </div>

                        <button id="realizarMovimento" className="button" type="submit">Realizar Movimento</button>

                    </form>






                    <div id="parteProduto">

                    <form onSubmit={handleInventoryTemporary}>
                    <div className="input-group">
                    <fieldset>
                        <legend>Produto</legend>
                        <select 
                            value={produto}
                            onChange={e => setProduto(e.target.value)}
                        >
                        <option value="" data-default disabled selected></option>

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
                        <legend>Valor Total</legend>
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
                            <button id="btn_add" type="submit">Adicionar Produto</button>

                            <button id="btn_cancel" >Cancelar Operação</button>
                        </div>
                    </form>

                    {/* <TableInventory></TableInventory> */}

                    </div>
                </section>
            </div>
        </div>
    </div>
    );
}