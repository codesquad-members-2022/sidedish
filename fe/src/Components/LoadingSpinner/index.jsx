import styled from 'styled-components';

import Colors from '@/Constants/Colors';

const LoadingSpinnerWrapper = styled.div`
  width: 120px;
  height: 120px;
  border: 10px solid transparent;
  border-top-color: ${props => props.color};
  border-right-color: ${props => props.color};
  border-radius: 999px;
  margin: 200px auto;
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

export const LoadingSpinner = ({ color = Colors.BLACK }) => {
  return <LoadingSpinnerWrapper color={color} />;
};
