import React, { useState, useEffect } from 'react';
import "./Card.css";
import api from '../../services/api';
import Modal from '../../components/Modal/Modal';
import { useHistory } from 'react-router-dom';


export default props => {

    const [isModalVisible, setIsModalVisible] = useState(false);
    const [idExclusao, setIdExclusão] = useState('');
    const [radio, setRadio] = useState('');

    const token = localStorage.getItem('token');
    const history = useHistory();

    const cardStyle = {
        backgroundColor: props.color || '#F00',
        borderColor: props.color || '#F00'
    }

    function refreshPage() {
        window.location.href = "http://www.localhost:3000/relatorio";
    }


    async function handleDelete(id){
        setIdExclusão(id);
        setIsModalVisible(true);
        setRadio(true);
    }

    async function excluir(e){
        e.preventDefault();
        try{
            if(radio === 'true'){
                await api.delete(`product/register/${idExclusao}`, {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    }
                })
                refreshPage()
            } 
            if(radio === 'false'){
                setIsModalVisible(false)
            }
        } catch (err) {
            await alert('Tudo OK');
        }
    }



    
    return (


        <div className="Card" style={cardStyle}>
            {isModalVisible ? 
                <Modal scrolling="no" onClose={() => setIsModalVisible(false) }>
                    <form onSubmit={excluir}>
                        <input type="radio" 
                            checked={radio === "true"}
                            value="true"
                            onChange={(e)=>{setRadio(e.target.value)}}/> 

                        <input type="radio" 
                            checked={radio === "false"}
                            value="false"
                            onChange={(e)=>{setRadio(e.target.value);/*console.log(radio)*/}}/> 
                        <br/>

                        <button type="submit">Confirmar Exclusão</button>

                    </form>
                </Modal>
            : null}

            <div className="Title"><strong>{props.titulo}</strong>
                <button className="close" onClick={() => handleDelete(props.idCodigo)} type="button"/>
            </div>

            {/* <div className="Title"><strong>{props.titulo}</strong>
                <button className="close" onClick={handleStatus} type="button"/>
            </div> */}

            <div className="CdgProduto"> 
                <h2>Código do Produto:</h2><h2>{props.cdgProduto}</h2>
            </div>

            <div className="QtdeProduto"> 
                <h2>{props.quantidade} Unidades</h2>
            </div>
            
            <div className="Url"> <img src={props.url} alt=""/> </div>

            <div className="Descricao">
                <h2>{props.descricao}</h2>
            </div>
            
            <div className="Preco">
                <h2>{Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(props.preco)}</h2>
            </div>
        
        </div>
    )
}