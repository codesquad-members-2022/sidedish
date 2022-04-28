import axios from 'axios';

const baseURL = process.env.REACT_APP_API_URL;

const client = axios.create({
  baseURL,
});

export default client;
