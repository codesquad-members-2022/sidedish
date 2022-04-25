import React from 'react';
import styled from 'styled-components';
import { SIZE, WEIGHT, FAMILY } from '../variable/font';
import COLOR from '../variable/color';

export default function Text({ size, weight, family, color, value }) {
  return (
    <SPAN size={size} weight={weight} family={family} color={color}>
      {value}
    </SPAN>
  );
}

Text.defaultProps = {
  size: SIZE.BASE,
  weight: WEIGHT.REGULAR,
  family: FAMILY.BASE,
  color: COLOR.BLACK,
  line: '',
  value: ''
};

const SPAN = styled.span({
  display: 'block',
  fontSize: props => SIZE[props.size] || props.size,
  fontWeight: props => WEIGHT[props.weight] || props.weight,
  fontFamily: props => FAMILY[props.family] || props.family,
  color: props => COLOR[props.color] || props.color,
  textDecoration: props => (props.line ? 'line-through' : '')
});
