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

        if (response.data === 'success') {
          const userEmail = response.headers.useremail;
          const userImage =
            response.headers.userImage ??
            'http://www.classictvinfo.com/PerryMason/TVSeries1/Person.jpg';
          localStorage.setItem('userEmail', userEmail);
          localStorage.setItem('userImage', userImage);
          alert('이동');
          navigate('/');
        }
      } catch (error) {}
    };

    getToken();
  }, [oauthURI, navigate, search]);
};

export default Callback;
