import React /*, {useState}*/ from 'react'; 
import api from '../../services/api';

import produtos from '../../data/produtos';

import Card from '../../components/Layout/Card'
import './styles.css';
import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';

export default function Relatorio() {


    function getCards() {
        return produtos.map((produto, i) => {
            return (
                <Card titulo={produto.nome} preco={produto.preco} url={produto.url} color="#E8B71A"/>
            )
        })
    }

    let links = [
        { label: 'Usuário', link: '/register' },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda' },
        { label: 'Movimentar Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '/relatorio', active: true },
      ];

    return (
        <div>
        <header>
            <Menu links={links} logo={logo} />
        </header>
        <div className="relatorio-container">
        <div className="content">
            <section>
                <h1>RELATÓRIO GERAL</h1>
            
            <div className="Cards">
                {getCards()}
            </div>   

            </section> 
        </div>
        </div>

        </div>
)}