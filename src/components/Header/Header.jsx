import React from 'react';
import styled from 'styled-components';
import Logo from 'components/Header/Logo';
import GNBWrap from 'components/Header/GNB';
import MyUtils from 'components/Header/MyUtils';

export default function Header() {
  return (
    <Wrap>
      <InBox>
        <Logo size="2.857rem" />
        <GNBWrap />
        <MyUtils />
      </InBox>
    </Wrap>
  );
}

Header.defaultProps = {
  value: '',
  disabled: false
};

const Wrap = styled.header({
  borderBottom: ({ theme }) => `1px solid ${theme.COLOR.BLACK[100]}`
});

const InBox = styled.div({
  display: 'flex',
  gap: '40px',
  maxWidth: '1440px',
  margin: '0 auto',
  padding: '30px 80px 16px'
});
