import styled from 'styled-components';

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

export {
  Container,
  Wrapper,
  Title,
};
