import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import {mask, unMask} from "remask";

import api from '../../services/api';
import './styles.css';

import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function Venda() {
    const [nomeCliente, setNomeCliente] = useState('');
    const [cpfCnpj, setCpfCnpj] = useState('');
    const [nomeVendedor, setNomeVendedor] = useState('');
    const [tipoPagamento, setTipoPagamento] = useState('');
    const [dataVenda, setDataVenda] = useState('');
    const [nrCupomFiscal, setNrCupomFiscal] = useState('');
    const [tipoMovimento] = useState('MOV_VENDA');
    const [produtos, setProdutos] = useState([]);
    const [produto, setProduto] = useState('');
    
    const [valorUnitario, setValorUnitario] = useState('');
    const [qtde, setQtde] = useState('');
    const [valorDesconto, setValorDesconto] = useState('');

    const history = useHistory();
    const token = localStorage.getItem('token');

    if(token === null){
        history.push('/');
    }

    const MascararCNPJeCPF = ev => {
        const originalValue = unMask(ev.target.value);
            const maskedValue = mask(originalValue, [
                '999.999.999-99',
                '99.999.999/9999-99'
            ]);
            setCpfCnpj(maskedValue);
        };


    useEffect(() => { 
        const fetchData = async () => {
        const result = await api.get('product/register', {
            headers: {
                Authorization: `Bearer ${token}`,
            } 
         });
        
        setProdutos(result.data);
    };
    fetchData();
    }, []);

    function PreencherListaProduto() {
        if (produtos.length !== 0) {
            return produtos.map(produto => (
                <option 
                key={produto.idProduto}
                value={produto.idProduto}
                >{produto.nomeProduto}
                </option>
            )) 
        }
    }


    function ResetVenda() {      
        setProduto('');
        setValorUnitario('');
        setQtde('');
        setValorDesconto('')
    }

    function ResetAll(e) {      
        e.preventDefault();
        setNomeCliente('');
        setCpfCnpj('');
        setNomeVendedor('');
        setTipoPagamento('');
        setDataVenda('');
        setNrCupomFiscal('');
        setProduto('');
        setValorUnitario('');
        setQtde('');
        setValorDesconto('')

        document.getElementById("input_nomeCliente").disabled = false;
        document.getElementById("input_cpfCnpj").disabled = false;
        document.getElementById("input_vendedor").disabled = false;
        document.getElementById("input_cupomFiscal").disabled = false;
        document.getElementById("input_dtVenda").disabled = false;
        document.getElementById("select_tpPagamento").disabled = false;
        document.getElementById("select_produto").disabled = true;
        document.getElementById("input_qtde").disabled = true;
        document.getElementById("input_valor").disabled = true;
        document.getElementById("input_desconto").disabled = true;
    }


    async function lidarComVenda(e) {
        e.preventDefault(); 

        const data = {
            nomeCliente,
            cpfCnpj,
            nomeVendedor,
            tipoPagamento,
            dataVenda,
            nrCupomFiscal,
            tipoMovimento
        };

        document.getElementById("input_nomeCliente").disabled = true;
        document.getElementById("input_cpfCnpj").disabled = true;
        document.getElementById("input_vendedor").disabled = true;
        document.getElementById("input_cupomFiscal").disabled = true;
        document.getElementById("input_dtVenda").disabled = true;
        document.getElementById("select_tpPagamento").disabled = true;
        document.getElementById("select_produto").disabled = false;
        document.getElementById("input_qtde").disabled = false;
        document.getElementById("input_valor").disabled = false;
        document.getElementById("input_desconto").disabled = false;

        try{
            await api.post('sales/register', data, {
                headers: {
                    Authorization: `Bearer ${token}`,
                }
            });      


         }catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }

    async function lidarComVendaItem(e) {
        e.preventDefault(); 

        const data = {
            produto,
            qtde,
            valorUnitario,
            valorDesconto
        };

        try{
            await api.post(`salesItem/register/${nrCupomFiscal}/product/${produto}`, data, {
                headers: {
                    Authorization: `Bearer ${token}`,
                }
            });      

         } catch (Exception) {
            alert('Quantidade indisponível em estoque');
            console.log(Exception);
            console.log(data);
         }

         ResetVenda();
    }


    let links = [
        { label: 'Usuário', link: '/register'},
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda', active: true  },
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
            <h1>REGISTRO DE VENDAS</h1>
                <form onSubmit={lidarComVenda}>
                <div className="input-group">
                <fieldset >
                <legend>Nome do Cliente</legend>
                    <input 
                        id="input_nomeCliente"
                        type="text"
                        placeholder="Nome do Cliente"
                        value={nomeCliente}
                        onChange={e => setNomeCliente(e.target.value)}
                    />  
                </fieldset> 

                <fieldset style={{ width: 300 }}>
                <legend>CPF/CNPJ</legend>
                    <input 
                        id="input_cpfCnpj"
                        type="text"
                        placeholder="CPF"
                        value={cpfCnpj}
                        onChange={MascararCNPJeCPF}
                    />  
                </fieldset> 
                </div>

                <div className="input-group">
                <fieldset>
                <legend>Vendedor</legend>
                    <input 
                        id="input_vendedor"
                        type="text"
                        placeholder="Vendedor"
                        value={nomeVendedor}
                        onChange={e => setNomeVendedor(e.target.value)}
                    />  
                </fieldset>
                </div>

                <div className="input-group">

                <fieldset >
                <legend>Número do Cupom Fiscal</legend>
                    <input 
                        id="input_cupomFiscal"
                        type="number"
                        placeholder="Número do Cupom Fiscal "
                        value={nrCupomFiscal}
                        onChange={e => setNrCupomFiscal(e.target.value)}
                />       
                </fieldset>

                <fieldset style={{ width: 200 }} >
                <legend>Data da Venda</legend>
                    <input 
                        id="input_dtVenda"
                        type="date" 
                        style={{ width: 280 }} 
                        value={dataVenda}
                        onChange={e => setDataVenda(e.target.value)}
                />
                </fieldset>

                <fieldset style={{ width: 300 }}>
                <legend>Pagamento</legend>
                    <select
                        id="select_tpPagamento"
                        value={tipoPagamento}
                        onChange={e => setTipoPagamento(e.target.value)}
                    >       
                            <option value=""></option>
                            
                            <option                  
                                value="A_VISTA"
                                >À vista
                            </option>

                            <option
                                value="A_PRAZO"
                                >À prazo
                            </option>
                    </select>
                </fieldset>

                </div>

                <div className="operacaoProduto">
                    <button id="btn_tpMov" type="submit">CONFIRMAR TIPO DE VENDA</button>
                </div>
                </form>

                <form onSubmit={lidarComVendaItem}>
                
                <fieldset>
                        <legend>Produto</legend>
                        <select 
                            id="select_produto"
                            disabled
                            value={produto}
                            onChange={e => setProduto(e.target.value)}
                            >
                            
                            <option value=""></option>

                            {PreencherListaProduto()}

                        </select>
                    </fieldset>
                
                {/* <fieldset>
                <legend>Código do Produto</legend>
                    <input id="cdgProduto"
                        type="text"
                        placeholder="Código Produto"
                        value={nrItemVenda}
                        onChange={e => setNrItemVenda(e.target.value)}
                    />  
                </fieldset>  */}

                <div className="input-group">
                <fieldset>
                <legend>Quantidade</legend>
                    <input 
                        id="input_qtde"
                        type="number"
                        placeholder="Quantidade"
                        disabled
                        value={qtde}
                        onChange={e => setQtde(e.target.value)}
                    />  
                </fieldset> 

                <fieldset>
                <legend>Valor Unitário</legend>
                    <input  
                        id="input_valor"
                        type="number"
                        placeholder="Valor"
                        disabled
                        value={valorUnitario}
                        onChange={e => setValorUnitario(e.target.value)}
                    />  
                </fieldset> 

                <fieldset>
                <legend>Valor Desconto</legend>
                    <input 
                        id="input_desconto"
                        type="number"
                        placeholder="Desconto"
                        disabled
                        value={valorDesconto}
                        onChange={e => setValorDesconto(e.target.value)}
                    />  
                </fieldset> 
                </div>

                <div className="operacaoProduto">
                            <button id="btn_add" type="submit">Vender do Produto</button>
                            <button id="btn_cancel" onClick={ResetAll}>Nova Venda</button>
                    </div>
                    
                </form>
            </section>
        </div>
        </div>
        </div>
    );
}