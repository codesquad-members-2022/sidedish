import React from 'react';
import styled from 'styled-components';
import Logo from 'components/Header/Logo';
import GNBWrap from 'components/Header/GNB';
import MyUtils from 'components/Header/MyUtils';

export default function Header() {
  return (
    <Wrap>
      <Logo size="2.857rem" />
      <GNBWrap />
      <MyUtils />
    </Wrap>
  );
}

Header.defaultProps = {
  value: '',
  disabled: false
};

const Wrap = styled.header({
  display: 'flex',
  gap: '40px',
  padding: '30px 80px 16px',
  borderBottom: `1px solid ${({ theme }) => theme.COLOR.BLACK[100]}`
});
