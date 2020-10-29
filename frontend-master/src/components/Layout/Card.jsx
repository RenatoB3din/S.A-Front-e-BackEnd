import React from 'react';
import "./Card.css";

export default props => {

    const cardStyle = {
        backgroundColor: props.color || '#F00',
        borderColor: props.color || '#F00'
    }

    return (
        <div className="Card" style={cardStyle}>
            <div className="Title"><strong>{props.titulo}</strong></div>
            <div className="Url"> <img src={props.url}/> </div>
            <div className="Preco"><h2>Preço:</h2><h2 id="h3valor">R${props.preco}</h2></div>
        </div>
    )
}