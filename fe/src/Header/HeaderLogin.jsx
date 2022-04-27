import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { ReactComponent as PersonImage } from 'image/person.svg';

const LoginWrapper = styled.div`
  position: relative;
`;

const AccountModal = styled.div`
  position: absolute;
  top: 40px;
  left: -40px;
  width: 200px;
  heigth: 300px;
  background: coral;
  text-align: center;
  display: ${(props) => (props.hover ? 'block' : 'none')};

  a {
    display: inline-block;
    padding: 20px;
    background: transparent;
    border: none;
  }
`;

const HeaderLogin = () => {
  const [hover, setHover] = useState(false);
  const [isLogin, setIsLogin] = useState(false);
  const onMouseOver = () => setHover(true);
  const onMouseOut = () => setHover(false);

  const handleLogout = () => {
    localStorage.removeItem('user');
    alert('로그아웃 되었습니다.');
    setIsLogin(false);
    setHover(false);
  };

  useEffect(() => {
    const user = localStorage.getItem('user');
    if (user) {
      setIsLogin(true);
    }
  }, [isLogin]);

  return (
    <>
      <LoginWrapper onMouseOver={onMouseOver}>
        <>
          <AccountModal hover={hover} onMouseOut={onMouseOut}>
            {!isLogin ? (
              <a href="https://github.com/login/oauth/authorize?client_id=7fa807988dbe1e60acc4&redirect_uri=http://localhost:3000/callback&scope=user">
                Github 로그인
              </a>
            ) : (
              <button to="/" onClick={handleLogout}>
                로그아웃
              </button>
            )}
          </AccountModal>
          <PersonImage className="icon" />
        </>
      </LoginWrapper>
    </>
  );
};

export default HeaderLogin;
