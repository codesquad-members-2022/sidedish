import styled from "styled-components";

const Container = styled.div`
  padding: 4.8rem 4.8rem 6.4rem 4.8rem;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Title = styled.h3`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.medium};
`;

export { Container, Header, Title };
