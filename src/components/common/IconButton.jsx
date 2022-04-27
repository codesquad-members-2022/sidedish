/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import styled from 'styled-components';
import { ReactComponent as Search } from 'images/icon_search.svg';
import { ReactComponent as User } from 'images/icon_user.svg';
import { ReactComponent as Cart } from 'images/icon_cart.svg';
import { ReactComponent as Prev } from 'images/icon_prev.svg';
import { ReactComponent as Next } from 'images/icon_next.svg';
import { ReactComponent as Plus } from 'images/icon_plus.svg';
import { ReactComponent as Minus } from 'images/icon_minus.svg';
import THEME from '../../variable/theme';

function Icon({ icon, width, height, fill }) {
  const svgInfo = { icon, width, height, fill, stroke: fill };
  const Icons = {
    search: <Search {...svgInfo} />,
    user: <User {...svgInfo} />,
    cart: <Cart {...svgInfo} />,
    prev: <Prev {...svgInfo} />,
    next: <Next {...svgInfo} />,
    plus: <Plus {...svgInfo} />,
    minus: <Minus {...svgInfo} />
  };
  return Icons[icon];
}

export default function IconButton({ icon, width, height, fill, onClick, as }) {
  return (
    <Wrap as={as} onClick={onClick}>
      <Icon icon={icon} width={width} height={height} fill={fill} />
    </Wrap>
  );
}

IconButton.defaultProps = {
  icon: null,
  width: '24px',
  height: '24px',
  fill: THEME.COLOR.BLACK[100]
};

const Wrap = styled.a({
  padding: '10px'
});
