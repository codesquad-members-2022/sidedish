import React from 'react';
import styled from 'styled-components';

import { flexCenter } from '../css/mixins';

const Menu = ({ menuInfo }) => {
  return (
    <MenuBox>
      {menuInfo.map(({ url, alt }, idx) => (
        <MenuIcon key={`${alt}-${idx}`} src={url} alt={alt} />
      ))}
    </MenuBox>
  );
};

const MenuBox = styled.div`
  ${flexCenter}
  margin: 16px 80px 0 0;
`;

const MenuIcon = styled.img`
  padding: 16px;
`;

export default Menu;
