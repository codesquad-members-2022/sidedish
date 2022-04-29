import React from 'react';
import { ReactComponent as LoginIcon } from 'assets/login.svg';

const Login = () => {
  const API_URL =
    'https://github.com/login/oauth/authorize?client_id=177df418e8432fdceb2b&scope=id,name,email,avatar_url';

  const handleLoginClick = () => {
    openPopup();
  };

  const openPopup = () => {
    const width = 600;
    const height = 800;
    const left = window.innerWidth / 2 - width / 2;
    const top = window.innerHeight / 2 - height / 2;
    const url = `${API_URL}`;

    return window.open(
      url,
      '',
      `toolbar=no, location=no, directories=no, status=no, menubar=no, 
      scrollbars=no, resizable=no, copyhistory=no, width=${width}, 
      height=${height}, top=${top}, left=${left}`
    );
  };

  return <LoginIcon onClick={handleLoginClick} />;
};

export default Login;
