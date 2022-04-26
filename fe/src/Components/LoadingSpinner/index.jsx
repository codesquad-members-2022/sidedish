import styled from 'styled-components';

import { Colors } from '@/Constants';

const LoadingSpinnerWrapper = styled.div`
  width: ${({ radius }) => radius}px;
  height: ${({ radius }) => radius}px;
  border: ${({ borderWidth }) => borderWidth}px solid transparent;
  border-top-color: ${({ color }) => color};
  border-right-color: ${({ color }) => color};
  border-radius: 999px;
  margin: ${({ margin }) => margin}px auto;
  animation: rotation 600ms infinite ease-in-out;

  @keyframes rotation {
    from {
      transform: rotate(0deg);
    }

    to {
      transform: rotate(360deg);
    }
  }
`;

const DEFAULT_SIZE = 10;
const DEFAULT_COLOR = Colors.BLACK;

export const LoadingSpinner = ({
  color = DEFAULT_COLOR,
  radius = DEFAULT_SIZE,
  margin = DEFAULT_SIZE,
  borderWidth = DEFAULT_SIZE,
}) => {
  return (
    <LoadingSpinnerWrapper
      color={color}
      radius={radius}
      margin={margin}
      borderWidth={borderWidth}
    />
  );
};
