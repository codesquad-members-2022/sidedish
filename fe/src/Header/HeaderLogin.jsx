import React, { useState } from 'react';
import styled from 'styled-components';
import { ReactComponent as PersonImage } from 'image/person.svg';

const Login = styled.div`
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
  const onMouseOver = () => setHover(true);
  const onMouseOut = () => setHover(false);

  return (
    <>
      <Login onMouseOver={onMouseOver}>
        <PersonImage className="icon" />
        <AccountModal hover={hover} onMouseOut={onMouseOut}>
          <a href="https://github.com/login/oauth/authorize?client_id=7fa807988dbe1e60acc4&scope=user">
            Github 로그인
          </a>
        </AccountModal>
      </Login>
    </>
  );
};

export default HeaderLogin;
