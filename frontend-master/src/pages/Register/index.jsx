import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';
import './styles.css';

import logoImg from '../../assets/logo.png';

import Menu from '../../components/Header/Menu';
import logo from '../../components/Header/logo.png';


export default function Register() {
    const [name, setName] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [cpf, setCpf] = useState('');
    const [role, setRole] = useState('');

    const history = useHistory();

    function reset() {
        setName('');
        setUsername('');
        setPassword('');
        setEmail('');
        setCpf('');
        setRole('');
     }

    async function handleRegister(e) {
        e.preventDefault(); // Não atualiza a pág ao dar submit

        const data = {
            name,
            username,
            email,
            password,
            cpf,
            role:[role]
        };

        try{
            const response = await api.post('api/auth/signup', data);

            console.log(`Seu Usuário é: ${response.data.id}`);


            history.push('/');

            reset();
         } catch (err) {
            alert('Erro no cadastro, tente novamente.');
         }
    }

    let links = [
        { label: 'Usuário', link: '/register', active: true },
        { label: 'Fornecedor', link: '/novofornecedor'},
        { label: 'Produtos', link: '/novoproduto'},     
        { label: 'Vendas', link: '/venda' },
        { label: 'Movimentar Inventário', link: '/newinventory' },
        { label: 'Relatórios', link: '#contact-us' },
      ];

    return (
        <div>
        <header>
            <Menu links={links} logo={logo} />
        </header>
        <div className="register-container">
            <div className="content">
                <section>
                    <img src={logoImg} alt="logoSa" />

                    <h1>Cadastro</h1>
                    <p>Faça seu cadastro, entre na plataforma e ajude-nos a crescer cada vez mais.</p>

                </section>
                
                <form onSubmit={handleRegister}>
                    <input 
                        placeholder="Nome Completo"
                        value={name}
                        onChange={e => setName(e.target.value)}
                    />
                    <input 
                        placeholder="Usuário"
                        value={username}
                        onChange={e => setUsername(e.target.value)}
                    />
                    <input 
                        type="password" 
                        placeholder="Senha"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                    />
                    <input 
                        type="email" 
                        placeholder="E-mail"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                    />

                    <div className="input-group">
                        <input 
                            placeholder="CPF"
                            value={cpf}
                            onChange={e => setCpf(e.target.value)}
                        />
                        <select 
                            name="perfil" 
                            style={{ width: 180 }}
                            value={role}
                            onChange={e => setRole(e.target.value)}
                        >

                            <option value="" disabled ></option>

                            <option
                                value="admin"
                            >Admin</option>

                            <option                  
                                value="manager"
                            >Gerente</option>

                            <option                  
                                value="role_sallesman"
                            >Vendedor</option>
                        </select>
                    </div>

                    <button className="button" type="submit">Cadastrar</button>
                </form>
            </div>
        </div>
        </div>
    );
}