import { useState, useEffect } from 'react';
import styled from 'styled-components';
import HeaderCategory from 'Header/HeaderCategory';
import { ReactComponent as CartImage } from 'image/cart.svg';
import { ReactComponent as SearchImage } from 'image/search.svg';
import { CATEGORY_TEXTS } from 'MockData/dummyData';
import HeaderLogin from './HeaderLogin';
import axios from 'axios';

const HeaderLogo = styled.div`
  ${({ theme }) => theme.fontStyles.logo};
  margin-right: 40px;
  cursor: pointer;
`;

const HeaderWrapper = styled.div`
  ${({ theme }) => theme.flexLayout.default};
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

const HeaderTemplate = styled.header`
  padding: 16px 0;
  border-bottom: 1px solid ${({ theme }) => theme.colors.black};
  transition: height 0.25s ease-out;
  height: ${(props) => (props.open ? '190px' : '80px')};
`;

const HeaderInnerTemplate = styled.div`
  width: 100%;
  height: 50px;
  ${({ theme }) => theme.flexLayout.default};
  justify-content: space-between;
  align-items: center;
`;

const CategoryTemplate = styled.div`
  ${({ theme }) => theme.flexLayout.default};
`;

const IconTemplate = styled.div`
  ${({ theme }) => theme.flexLayout.default};
  align-items: center;

  .icon {
    cursor: pointer;
    margin: 0 12px;
  }
`;

export default function Template() {
  const [subCategoryOpen, setSubCategoryOpen] = useState(false);
  const [isLogin, setIsLogin] = useState(false);
  const token = localStorage.getItem('token');

  const onMouseOver = () => {
    setSubCategoryOpen(true);
  };

  const onMouseOut = () => {
    setSubCategoryOpen(false);
  };

  const handleLogin = async () => {
    try {
      const response = await axios.get(
        'https://github.com/login/oauth/authorize?client_id=7fa807988dbe1e60acc4&scope=user'
      );
      const data = await response.json();
      console.log(data);
      localStorage.setItem('token', data);
    } catch (error) {
      throw new Error(error);
    }
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
  };

  const categoryList = CATEGORY_TEXTS.map((category, index) => {
    return <HeaderCategory open={subCategoryOpen} key={index} category={category}></HeaderCategory>;
  });

  const iconList = () => {
    return (
      <>
        <CartImage className="icon" />
        <HeaderLogin handleLogin={handleLogin}></HeaderLogin>
        <SearchImage className="icon" />
      </>
    );
  };

  useEffect(() => {
    if (token) {
      setIsLogin(true);
    }
  }, [token]);

  return (
    <HeaderTemplate open={subCategoryOpen}>
      <HeaderWrapper>
        <HeaderLogo>Ordering</HeaderLogo>
        <HeaderInnerTemplate>
          <CategoryTemplate onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
            {categoryList}
          </CategoryTemplate>
          <IconTemplate>{iconList()}</IconTemplate>
        </HeaderInnerTemplate>
      </HeaderWrapper>
    </HeaderTemplate>
  );
}
