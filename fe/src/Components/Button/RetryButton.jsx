import styled from 'styled-components';

import { Colors } from '@/Constants';

const Button = styled.button`
  display: flex;
  padding: 16px 24px;
  margin: 230px auto;
  border-radius: 999px;
  color: ${Colors.WHITE};
  background-color: ${Colors.GREY};
  transition: all 200ms ease-in-out;

  &:hover {
    background-color: ${Colors.BLACK};
  }
`;

export const RetryButton = ({ onClick }) => {
  return (
    <Button className={'fonts-lg'} onClick={onClick}>
      다시 시도
    </Button>
  );
};
