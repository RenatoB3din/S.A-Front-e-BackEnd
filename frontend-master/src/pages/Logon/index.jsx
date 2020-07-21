import React, { useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import './styles.css';

import api from '../../services/api';

import logoImg from '../../assets/logo.png';
import projetoSaImg from '../../assets/projetosa.png';

export default function Logon(){
    const [user, setUser ] = useState('');
    const [password, setPassword ] = useState('');
    const history = useHistory();

    async function handleLogin(e) {
        e.preventDefault();

        try{
          const response = await api.post('sessions', { user, password });
          
          localStorage.setItem('userId', response.data.id);
          localStorage.setItem('userName', user);

          history.push('/newinventory');
        } catch (err) {
            alert('Usuário e/ou senha inválidos');
        }
    }

    return(
        <div className="logon-container">
            <section className="form">
                <img src={logoImg} alt="logoSa" />

                <form onSubmit={handleLogin}>
                    <h1>Faça seu logon</h1>

                    <input 
                        placeholder="Usuário" 
                        value={user}
                        onChange={e => setUser(e.target.value)}
                    />
                    <input 
                        placeholder="Senha" 
                        type="password"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                    />

                    <div className="rec_senha">
                        <Link className="back-link" to="/register">Esqueceu sua senha?</Link>
                    </div>
                    <button className="button" type="submit">Entrar</button>

                </form>
            </section>

            <img src={projetoSaImg} alt="projetoSa" />
        </div>
    );
}