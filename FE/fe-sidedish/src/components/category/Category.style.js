import styled from 'styled-components';
import { ButtonType } from './Category';

const Container = styled.section`
  margin-top: 50px;
`;

const Wrapper = styled.div`
  width: 1440px;
  padding: 0 80px;
  margin: 0 auto;
`;

const Title = styled.h2`
  color: ${({ theme }) => theme.color.grey1};
  font-size: ${({ theme }) => `${theme.fontSize.xLarge}`};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
  letter-spacing: -0.008em;
  margin-bottom: 40px;
`;

const Slide = styled.div`
  position: relative;
`;

const SlideWrapper = styled.div`
  overflow: hidden;
`;

const SlideButton = styled.button`
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
  Title,
  Slide,
  SlideWrapper,
  SlideButton,
  CardList,
};
