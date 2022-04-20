import React from 'react';
import Gnb from './GNB';
import styled from 'styled-components';

const HEADER = styled.header`
  display: flex;
  justify-content: space-between;
  padding: 16px 80px;
  border-bottom: 1px solid #1b1b1b;
`;
const HeaderLeft = styled.div`
  display: flex;
  align-items: center;
`;
const Logo = styled.h1`
  font-size: 40px;
  font-weight: bold;
`;

export default function Header() {
  return (
    <HEADER>
      <HeaderLeft>
        <Logo>Ordering</Logo>
        <Gnb></Gnb>
      </HeaderLeft>
    </HEADER>
  );
}
