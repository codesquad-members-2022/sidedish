import React from 'react';
import styled from 'styled-components';
import COLOR from '../variable/color';
import { ReactComponent as Search } from '../images/icon_search.svg';
import { ReactComponent as User } from '../images/icon_user.svg';
import { ReactComponent as Cart } from '../images/icon_cart.svg';
import { ReactComponent as Prev } from '../images/icon_prev.svg';
import { ReactComponent as Next } from '../images/icon_next.svg';
import { ReactComponent as Plus } from '../images/icon_plus.svg';
import { ReactComponent as Minus } from '../images/icon_minus.svg';

function Icon(props) {
  const { icon, width, height, fill } = props;
  switch (icon) {
    case 'search':
      return <Search width={width} height={height} fill={fill} stroke={fill} />;
    case 'user':
      return <User width={width} height={height} fill={fill} stroke={fill} />;
    case 'cart':
      return <Cart width={width} height={height} fill={fill} stroke={fill} />;
    case 'prev':
      return <Prev width={width} height={height} fill={fill} stroke={fill} />;
    case 'next':
      return <Next width={width} height={height} fill={fill} stroke={fill} />;
    case 'plus':
      return <Plus width={width} height={height} fill={fill} stroke={fill} />;
    case 'minus':
      return <Minus width={width} height={height} fill={fill} stroke={fill} />;
    default:
      return null;
  }
}

export default function IconButton(props) {
  const { icon, width, height, fill } = props;
  return (
    <Wrap>
      <Icon icon={icon} width={width} height={height} fill={fill} />
    </Wrap>
  );
}

IconButton.defaultProps = {
  icon: null,
  width: '24px',
  height: '24px',
  fill: COLOR.BLACK
};

const Wrap = styled.a({
  padding: '10px'
});
