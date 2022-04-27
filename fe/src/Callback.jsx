import { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Callback = () => {
  const oauthURI = `http://3.37.194.187:8080/oauth`;

  const navigate = useNavigate();
  const { search } = useLocation();

  useEffect(() => {
    const getToken = async () => {
      try {
        const response = await axios.get(`${oauthURI}${search}`);
        console.log(response);
        if (response.data === 'success') {
          //   const user = response.user;
          const user = 'ADMIN';
          localStorage.setItem('user', user);
          alert('이동');
          navigate('/');
        }
      } catch (error) {}
    };

    getToken();
  }, [oauthURI, navigate, search]);
};

export default Callback;
