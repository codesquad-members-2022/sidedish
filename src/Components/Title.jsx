import styled from 'styled-components';
import { TextEllipsis } from '../Assets/CommonStyle';

const Heading = styled.h2`
  font-size: ${({ size, theme: { FontSize } }) => FontSize[size]};
  font-weight: ${({ weight, theme: { FontWeight } }) => FontWeight[weight]};
  color: ${({ color, theme: { Color } }) => Color[color]};
  ${({ as }) => (as ? TextEllipsis : null)}
`;

export default function Title({ title, fontSize, fontWeight, color, as }) {
  return (
    <Heading size={fontSize} weight={fontWeight} color={color} as={as}>
      {title}
    </Heading>
  );
}
