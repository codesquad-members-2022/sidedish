import styled from "styled-components";

const Container = styled.div`
  margin: 56px 0 0;
`;

const TitleWrapper = styled.div`
  margin: 0 auto 24px;
  width: 1440px;
  padding: 0 80px;
  display: flex;
  gap: 16px;
  align-items: center;
`;

const Title = styled.h4`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.display};
`;

const Badge = styled.div`
  margin: 6px 0 0;
  padding: 6px 16px;
  height: 42px;
  border: 2px solid ${({ theme }) => theme.color.black};
  background: ${({ theme }) => theme.color.offWhite};
  box-sizing: border-box;
  border-radius: 999px;
  overflow: hidden;
`;

const TapBarContainer = styled.div`
  margin: 0 auto;
  width: 1440px;
  padding: 0 80px;
  display: flex;
  gap: 32px;
`;

const Button = styled.button`
  padding: 0 0 16px;
  font-size: ${({ theme }) => theme.fontSize.large};
  border-bottom: 2px solid ${({ theme }) => theme.color.white};
  &.active {
    border-bottom: 2px solid ${({ theme }) => theme.color.black};
  }
`;
const DishListWrapper = styled.div`
  border-top: 1px solid ${({ theme }) => theme.color.grey4};
  border-bottom: 1px solid ${({ theme }) => theme.color.grey4};
`;

const DishListContainer = styled.ul`
  margin: 32px auto 56px;
  width: 1440px;
  padding: 0 80px;
  display: flex;
  gap: 24px;
`;

export {
  Container,
  TitleWrapper,
  Title,
  Badge,
  TapBarContainer,
  Button,
  DishListWrapper,
  DishListContainer,
};
