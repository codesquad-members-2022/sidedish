import React from 'react';
import styled from 'styled-components';
import { flexCenter, flexBetween } from './css/mixins';

const Header = () => {
  return (
    <StyledHeader>
      <FlexBetween>
        <Title>Ordering</Title>
        <Gnb>
          <GnbTap>
            <GnbTitle>든든한 메인요리</GnbTitle>
            <GnbCategory>
              <GnbContent>육류 요리</GnbContent>
              <GnbContent>해산물 요리</GnbContent>
            </GnbCategory>
          </GnbTap>

          <GnbTap>
            <GnbTitle>뜨끈한 국물요리</GnbTitle>
            <GnbCategory>
              <GnbContent>국/탕/찌개</GnbContent>
            </GnbCategory>
          </GnbTap>

          <GnbTap>
            <GnbTitle>정갈한 밑반찬</GnbTitle>
            <GnbCategory>
              <GnbContent>나물/무침</GnbContent>
              <GnbContent>조림/볶음</GnbContent>
              <GnbContent>절임/장아찌</GnbContent>
            </GnbCategory>
          </GnbTap>
        </Gnb>
      </FlexBetween>

      <Menu>
        <MenuIcon src="assets/search.png" alt="search"></MenuIcon>
        <MenuIcon src="assets/user.png" alt="user"></MenuIcon>
        <MenuIcon src="assets/basket.png" alt="basket"></MenuIcon>
      </Menu>
    </StyledHeader>
  );
};

const StyledHeader = styled.header`
  ${flexBetween}
  border-bottom: 1px solid black;
`;

const FlexBetween = styled.div`
  ${flexBetween}
`;

const Title = styled.h2`
  margin: 18px 40px 30px 80px;
  font-size: 40px;
  font-weight: 900;
`;

const Gnb = styled.section`
  ${flexBetween}
`;

const GnbTap = styled.div`
  padding: 35px 24px 24px 0;
  &:hover {
    height: 90px;
    ul {
      display: block;
      position: absolute;
      margin-top: 10px;
    }
  }
`;

const GnbTitle = styled.span`
  cursor: pointer;
`;

const GnbCategory = styled.ul`
  display: none;
`;

const GnbContent = styled.li`
  padding-top: 10px;
  cursor: pointer;
  &:hover {
    text-decoration: underline;
  }
`;

const Menu = styled.div`
  ${flexCenter}
  margin: 16px 80px 0 0;
`;

const MenuIcon = styled.img`
  padding: 16px;
`;

export default Header;
