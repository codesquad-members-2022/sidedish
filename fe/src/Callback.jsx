import { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { API_SUCCESS_TEXT } from 'constant';
import { SERVER_URL } from 'constant';

const Callback = () => {
  const oauthURI = `${SERVER_URL}oauth`;

  const navigate = useNavigate();
  const { search } = useLocation();

  useEffect(() => {
    const getToken = async () => {
      try {
        const response = await axios.get(`${oauthURI}${search}`);

        if (response.data === API_SUCCESS_TEXT) {
          const userEmail = response.headers.useremail;
          const avataUrl =
            response.headers.avataurl ??
            'http://www.classictvinfo.com/PerryMason/TVSeries1/Person.jpg';
          localStorage.setItem('userEmail', userEmail);
          localStorage.setItem('avataUrl', avataUrl);
          alert('이동');
          navigate('/');
        }
      } catch (error) {}
    };

    getToken();
  }, [oauthURI, navigate, search]);
};

export default Callback;
