import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { ReactComponent as PersonImage } from 'image/person.svg';
import { PROD_GITHUB_CALLBACK_URL } from 'constant';

const LoginWrapper = styled.div`
  position: relative;
`;

const AccountModal = styled.div`
  position: absolute;
  top: 40px;
  left: -80px;
  min-width: 200px;
  padding: 20px 40px;
  border: 1px solid ${({ theme }) => theme.colors.gray1};
  border-radius: 20px;
  color: ${({ theme }) => theme.colors.black};
  background: #fff;
  text-align: center;
  display: ${(props) => (props.hover ? 'block' : 'none')};

  a {
    text-decoration: none;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.smallBold};
  }

  a:hover {
    color: ${({ theme }) => theme.colors.blue};
  }

  p {
    margin-bottom: 16px;
    ${({ theme }) => theme.fontStyles.smallBold};
  }

  button {
    display: inline-block;
    padding: 8px 16px;
    border: none;
    border-radius: 16px;
    ${({ theme }) => theme.fontStyles.xSmallBold};
    background: ${({ theme }) => theme.colors.gray4};
    cursor: pointer;
  }

  button:hover {
    background: ${({ theme }) => theme.colors.blue};
    color: ${({ theme }) => theme.colors.white};
  }

  img {
    width: 60px;
    height: 60px;
    border-radius: 50%;
    background: green;
    margin-bottom: 8px;
  }
`;

const HeaderLogin = () => {
  const [hover, setHover] = useState(false);
  const [isLogin, setIsLogin] = useState(false);
  const onMouseOver = () => setHover(true);
  const onMouseOut = () => setHover(false);

  const handleLogout = () => {
    localStorage.removeItem('userEmail');
    localStorage.removeItem('avataUrl');
    alert('로그아웃 되었습니다.');
    setIsLogin(false);
    setHover(false);
  };

  useEffect(() => {
    const user = localStorage.getItem('userEmail');
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
              <a href={PROD_GITHUB_CALLBACK_URL}>Github 로그인</a>
            ) : (
              <>
                <img src={localStorage.getItem('avataUrl')} alt="UserProfileImage" />
                <p>{localStorage.getItem('userEmail')}</p>
                <button to="/" onClick={handleLogout}>
                  로그아웃
                </button>
              </>
            )}
          </AccountModal>
          <PersonImage className="icon" />
        </>
      </LoginWrapper>
    </>
  );
};

export default HeaderLogin;
