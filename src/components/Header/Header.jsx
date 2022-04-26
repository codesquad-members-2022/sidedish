import React from 'react';
import styled from 'styled-components';
import Logo from 'components/Header/Logo';
import GNBWrap from 'components/Header/GNB';
import IconButton from 'components/common/IconButton';

const iconButtons = {
  search: {
    width: '24px',
    height: '24px'
  },
  user: {
    width: '22px',
    height: '22px'
  },
  cart: {
    width: '27px',
    height: '28px'
  }
};

export default function Header() {
  return (
    <Wrap>
      <Logo size="2.857rem" />
      <GNBWrap />
      <MyUtils>
        {Object.keys(iconButtons).map((iconName, index) => (
          <li key={`${iconName}_${index}`}>
            <IconButton icon={iconName} width={iconButtons[iconName].width} height={iconButtons[iconName].hieght} />
          </li>
        ))}
      </MyUtils>
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

const MyUtils = styled.ul({
  display: 'flex',
  gap: '15px'
});
