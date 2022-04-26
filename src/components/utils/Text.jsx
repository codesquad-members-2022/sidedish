import React from 'react';
import styled from 'styled-components';
import THEME from 'variable/theme';

export default function Text({ size, weight, family, color, value, line }) {
  return (
    <SPAN size={size} weight={weight} family={family} color={color} line={line}>
      {value}
    </SPAN>
  );
}

Text.defaultProps = {
  size: THEME.FONT.SIZE.BASE,
  weight: THEME.FONT.WEIGHT.REGULAR,
  family: THEME.FONT.FAMILY.BASE,
  color: THEME.COLOR.BLACK[100],
  line: '',
  value: ''
};

const SPAN = styled.span({
  display: 'block',
  fontSize: ({ theme, size }) => theme.FONT.SIZE[size] || size,
  fontWeight: ({ theme, weight }) => theme.FONT.WEIGHT[weight] || weight,
  fontFamily: ({ theme, family }) => theme.FONT.FAMILY[family] || family,
  color: ({ theme, color }) => getColorStyle(theme, color),
  textDecoration: props => (props.line ? 'line-through' : 'none')
});

function getColorStyle(theme, color) {
  const [colorName, scale] = color.split('_');
  return scale ? theme.COLOR[colorName][scale] : colorName;
}
