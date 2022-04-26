import styled from 'styled-components';

const Container = styled.header`
  border-bottom: 1px solid ${({ theme }) => theme.color.black};
  height: ${({ isOpen }) => (isOpen ? '176px' : '97px')};
  transition: all ease-out 0.1s;
  overflow: hidden;
`;

const Wrapper = styled.div`
  margin: 0 auto;
  width: 1440px;
  padding: 16px 80px 16px;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
`;

const Title = styled.h2`
  font-family: 'Outfit';
  font-weight: ${({ theme }) => theme.fontWeight.heavy};
  font-size: ${({ theme }) => theme.fontSize.display};
  a {
    display: block;
    color: ${({ theme }) => theme.color.black};
  }
`;

const CategoryList = styled.ul`
  margin: 0 auto 0 20px;
  padding: 20px 20px 8px;
  display: flex;
  gap: 24px;
`;

const IconMenuList = styled.ul`
  margin: 16px 0 0;
  display: flex;
  gap: 16px;
`;

const IconMenu = styled.li`
  width: 32px;
  height: 32px;
  overflow: hidden;
  a {
    display: block;
    height: 32px;
    font-size: 0;
    svg:hover {
      fill: ${({ theme }) => theme.color.orange};
      transition: all ease-out 0.1s;
    }
  }
`;

const CategoryTitle = styled.p`
  margin: 0 0 12px;
`;

const CategoryMenuList = styled.ul`
  display: flex;
  flex-direction: column;
  gap: 8px;
  content-visibility: ${({ isOpen }) => (isOpen ? 'visible' : 'hidden')};
`;

const CategoryMenu = styled.li`
  font-size: ${({ theme }) => theme.fontSize.small};

  a {
    display: block;
    color: ${({ theme }) => theme.color.black};
    &:hover {
      color: ${({ theme }) => theme.color.orange};
      text-decoration: underline;
    }
  }
`;

export {
  Container,
  Wrapper,
  Title,
  CategoryList,
  CategoryTitle,
  CategoryMenuList,
  CategoryMenu,
  IconMenuList,
  IconMenu,
};
