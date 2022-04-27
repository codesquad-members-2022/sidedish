import React from 'react';
import styled from 'styled-components';
import { ReactComponent as Search } from 'images/icon_search.svg';
import { ReactComponent as User } from 'images/icon_user.svg';
import { ReactComponent as Cart } from 'images/icon_cart.svg';
import { ReactComponent as Prev } from 'images/icon_prev.svg';
import { ReactComponent as Next } from 'images/icon_next.svg';
import { ReactComponent as Plus } from 'images/icon_plus.svg';
import { ReactComponent as Minus } from 'images/icon_minus.svg';

const iconsComponents = {
  search: Search,
  user: User,
  cart: Cart,
  prev: Prev,
  next: Next,
  plus: Plus,
  minus: Minus
};

function Icon({ icon, width, height, fill }) {
  const IconComponent = iconsComponents[icon];
  if (!IconComponent) {
    throw new Error(`${icon} 컴포넌트를 찾을 수 없습니다. `);
  }
  return <IconComponent width={width} height={height} fill={fill} stroke={fill} />;
}

export default function IconButton({ icon, width, height, fill, stroke, onClick, as }) {
  return (
    <Wrap as={as} onClick={onClick}>
      <Icon icon={icon} width={width} height={height} fill={fill} stroke={stroke} />
    </Wrap>
  );
}

IconButton.defaultProps = {
  icon: null,
  width: '24px',
  height: '24px',
  fill: 'none',
  stroke: 'none'
};

const Wrap = styled.a`
  & svg {
    padding: 10px;
  }
`;
