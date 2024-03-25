import axios from 'axios'

const api_url = "http://localhost:8081/api/v1";

export const signIn = (data) => axios.post(`${api_url}/auth/signin`,data);
export const register = (data) => axios.post(`${api_url}/auth/register`,data);
export const logout = () => axios.get(`${api_url}/auth/logout`);
// export const forgotPassword = (data) => axios.post(`${api_url}/auth/forgot-password,data`);
// export const resetPassword = (data) => axios.post(`${api_url}/auth/reset-password,data`);