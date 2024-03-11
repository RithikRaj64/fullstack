import axios from "axios";

const instance = axios.create();

const token = getToken();

instance.interceptors.request.use((config) => {
    if(token){
        config.headers['Authorization'] = `Bearer ${token}`;
        return config;
    }
},(error) =>{
    return Promise.reject(error);
});

function getToken() {
    return sessionStorage.getItem('token');
}


export default instance;
