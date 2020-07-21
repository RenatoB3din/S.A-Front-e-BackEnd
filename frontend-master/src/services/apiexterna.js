import axios from 'axios';

const apiexterna = axios.create({
    // baseURL: 'http://localhost:3333',    
    baseURL: 'https://viacep.com.br/ws/',  
})

export default apiexterna; 
