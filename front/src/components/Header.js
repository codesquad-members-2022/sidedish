import React, { useState } from 'react';
import styled, { keyframes } from 'styled-components';
import LogoSrc from '../images/Logo.svg';
import SearchSrc from '../images/search.svg';
import MypageSrc from '../images/Mypage.svg';
import ShoppingCartSrc from '../images/Shopping-cart.svg';

function Header({ categories }) {
  const [isSubCategoriesShown, setIsSubCategoriesShown] = useState(false);
  function showSubCategory() {
    setIsSubCategoriesShown(true);
  }
  function hideSubCategory() {
    setIsSubCategoriesShown(false);
  }
  return (
    <HeaderWrap>
      <HeaderLeft>
        <Logo className="logo" src={LogoSrc}></Logo>
        <GNB
          isSubCategoriesShown={isSubCategoriesShown}
          className="GNB"
          onMouseEnter={showSubCategory}
          onMouseLeave={hideSubCategory}
        >
          {categories.map(({ id, name, children }) => (
            <Category key={id}>
              <MainCategory className="main-category">{name}</MainCategory>
              {isSubCategoriesShown ? (
                <SubCategories>
                  <ul>
                    {children.map(({ id, name }) => (
                      <SubCategory key={id}>{name}</SubCategory>
                    ))}
                  </ul>
                </SubCategories>
              ) : (
                ''
              )}
            </Category>
          ))}
        </GNB>
      </HeaderLeft>
      <Icons>
        <Search src={SearchSrc}></Search>
        <Mypage src={MypageSrc}></Mypage>
        <ShoppingCart src={ShoppingCartSrc}></ShoppingCart>
      </Icons>
    </HeaderWrap>
  );
}
const headerAnimation = keyframes`
from{
height:83px;
}
to{
height:190px;
}
`;
const HeaderWrap = styled.header`
  display: flex;
  border-bottom: 1px solid black;
  justify-content: space-between;
  width: 100vw;
  box-sizing: border-box;
  padding: 0 80px;

  /* animation-duration: 0.5s;
  animation-name: ${headerAnimation}; */
`;
const HeaderLeft = styled.div`
  display: flex;
`;
const Logo = styled.img`
  width: 174px;
  height: 50px;
  margin-top: 16px;
`;
const GNB = styled.div`
  display: flex;
  justify-content: flex-start;
  margin-top: 28px;
  margin-left: 40px;

  max-height: ${props => (props.isSubCategoriesShown ? 500 : 67)}px;

  overflow: hidden;
  transition: max-height 2s;
`;
const Category = styled.div`
  margin-right: 24px;
`;
const MainCategory = styled.div`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
`;
const SubCategories = styled.div`
  display: flex;
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  margin-bottom: 24px;
`;
const Icons = styled.div`
  margin-top: 28px;
  display: flex;
`;
const SubCategory = styled.li`
  &:hover {
    color: ${({ theme }) => theme.colors.orange};
    text-decoration: underline;
  }
  margin: 8px 0px;
`;
const Search = styled.img`
  width: 23px;
  height: 23px;
`;
const Mypage = styled.img`
  width: 21px;
  height: 21px;
  margin: 0 22px;
`;
const ShoppingCart = styled.img`
  width: 26px;
  height: 26px;
`;

export default Header;
