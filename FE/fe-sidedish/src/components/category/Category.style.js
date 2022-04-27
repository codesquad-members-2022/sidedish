import styled, { css } from 'styled-components';
import { CARD_SIZE } from '../../constants/card';

const Container = styled.section`
  margin-top: 50px;
  ${({ cardSize }) => cardSize === CARD_SIZE.SMALL && SmallContainer}
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

const SmallContainer = css`
  margin-top: 0;
  
  ${Wrapper} {
    padding: 0;
  }

  ${Title} {
    font-size: ${({ theme }) => `${theme.fontSize.large}`};
    margin-bottom: 28px;
  }
`;

export { Container, Wrapper, Title };
