import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Register from './pages/Register';
import Logon from './pages/Logon';
import CadastroProduto from './pages/CadastroProduto';
import CadastroFornecedor from './pages/CadastroFornecedor';
import InventoryMovement from './pages/InventoryMovement';
import Greeting from './pages/Greeting';

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Logon} />
                <Route path="/register" component={Register} />
                <Route path="/novoproduto" component={CadastroProduto} />
                <Route path="/novofornecedor" component={CadastroFornecedor} />
                <Route path="/newinventory" component={InventoryMovement} />
                <Route path="/greeting" component={Greeting} />
            </Switch>
        </BrowserRouter>
    );
}