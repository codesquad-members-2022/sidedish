import styled from 'styled-components';

import { Colors, Fonts } from '@/Constants';

const Button = styled.button`
  display: flex;
  padding: 16px 24px;
  margin: ${({ margin }) => margin}px auto;
  border-radius: 999px;
  color: ${Colors.WHITE};
  background-color: ${Colors.GREY};
  transition: all 200ms ease-in-out;

  &:hover {
    background-color: ${Colors.BLACK};
  }
`;

const DEFAULT_MARGIN = 10;

export const RetryButton = ({ onClick, margin = { DEFAULT_MARGIN } }) => {
  return (
    <Button className={Fonts.LG} onClick={onClick} margin={margin}>
      다시 시도
    </Button>
  );
};
