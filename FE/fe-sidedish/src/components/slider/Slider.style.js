import styled from 'styled-components';
import { ButtonType } from '../../constants/slider';

const Container = styled.div`
  position: relative;
`;

const Wrapper = styled.div`
  overflow: hidden;
`;

const Button = styled.button`
  position: absolute;
  top: 50%;
  ${({ type }) => type === ButtonType.PREV && 'left: -60px;'}
  ${({ type }) => type === ButtonType.NEXT && 'right: -60px;'}
  width: 32px;
  height: 32px;
  font-size: 0;
  transform: translateY(-50%);
`;

const CardList = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 24px;
`;

export {
  Container,
  Wrapper,
  Button,
  CardList,
};
