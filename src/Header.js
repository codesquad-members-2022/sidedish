import React from "react";
import styled from "styled-components";
import { flexCenter, flexBetween } from "./css/mixins";

const Header = () => {
  return (
    <StyledHeader>
      <FlexBetween>
        <HeaderTitle>Ordering</HeaderTitle>
        <HeaderGnb>
          <HeaderGnbTap>
            <span>든든한 메인요리</span>
            <HeaderGnbCategory>
              <HeaderGnbContent>육류 요리</HeaderGnbContent>
              <HeaderGnbContent>해산물 요리</HeaderGnbContent>
            </HeaderGnbCategory>
          </HeaderGnbTap>

          <HeaderGnbTap>
            <span>뜨끈한 국물요리</span>
            <HeaderGnbCategory>
              <HeaderGnbContent>국/탕/찌개</HeaderGnbContent>
            </HeaderGnbCategory>
          </HeaderGnbTap>

          <HeaderGnbTap>
            <span>정갈한 밑반찬</span>
            <HeaderGnbCategory>
              <HeaderGnbContent>나물/무침</HeaderGnbContent>
              <HeaderGnbContent>조림/볶음</HeaderGnbContent>
              <HeaderGnbContent>절임/장아찌</HeaderGnbContent>
            </HeaderGnbCategory>
          </HeaderGnbTap>
        </HeaderGnb>
      </FlexBetween>
      <HeaderMenu>
        <HeaderMenuIcon src='assets/search.png' alt='search'></HeaderMenuIcon>
        <HeaderMenuIcon src='assets/user.png' alt='user'></HeaderMenuIcon>
        <HeaderMenuIcon src='assets/basket.png' alt='basket'></HeaderMenuIcon>
      </HeaderMenu>
    </StyledHeader>
  );
};

const HeaderGnb = styled.section`
  ${flexBetween}
`;

const HeaderGnbTap = styled.div`
  padding: 24px;
  &:hover {
    ul {
      display: block;
      position: absolute;
      margin-top: 10px;
    }
  }
`;

const HeaderGnbCategory = styled.ul`
  display: none;
`;

const HeaderGnbContent = styled.li`
  padding-top: 10px;
`;

const StyledHeader = styled.header`
  ${flexBetween}
`;

const FlexBetween = styled.div`
  ${flexBetween}
`;

const HeaderTitle = styled.h2`
  margin: 18px 40px 30px 80px;
  font-size: 40px;
  font-weight: 900;
`;

const HeaderMenu = styled.div`
  ${flexCenter}
  margin-right: 80px;
`;

const HeaderMenuIcon = styled.img`
  padding: 16px;
`;

export default Header;
