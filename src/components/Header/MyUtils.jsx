import React from 'react';
import styled from 'styled-components';
import IconButton from 'components/common/IconButton';
import THEME from '../../variable/theme';

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

export default function MyUtils() {
  return (
    <Wrap>
      {Object.keys(iconButtons).map((iconName, index) => (
        <li key={`${iconName}_${index}`}>
          <IconButton
            icon={iconName}
            width={iconButtons[iconName].width}
            height={iconButtons[iconName].hieght}
            fill={THEME.COLOR.BLACK[100]}
          />
        </li>
      ))}
    </Wrap>
  );
}

const Wrap = styled.ul({
  display: 'flex',
  gap: '15px',
  marginTop: '4px'
});
