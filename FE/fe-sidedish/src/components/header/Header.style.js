import styled from "styled-components";

const Container = styled.header`
  border-bottom: 1px solid ${({ theme }) => theme.color.black};
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
  font-family: "Outfit";
  font-weight: ${({ theme }) => theme.fontWeight.heavy};
  font-size: ${({ theme }) => theme.fontSize.display};
`;

const CategoryList = styled.ul`
  margin: 20px auto 0 40px;
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
      filter: invert(58%) sepia(62%) saturate(1704%) hue-rotate(348deg)
        brightness(103%) contrast(104%);
    }
  }
`;

const Category = styled.li``;

const CategoryTitle = styled.span``;

const CategoryMenuList = styled.ul`
  margin: 12px 0 0;
  display: flex;
  flex-direction: column;
  gap: 8px;
`;

const CategoryMenu = styled.li`
  font-size: ${({ theme }) => theme.fontSize.small};
  a {
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
  Category,
  CategoryTitle,
  CategoryMenuList,
  CategoryMenu,
  IconMenuList,
  IconMenu,
};
