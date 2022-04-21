import styled from 'styled-components';

const CategoryButtonWrapper = styled.article`
  text-align: center;
`;

const CategeoryButton = styled.button`
  padding: 16px 24px;
  border: 1px solid ${({ theme }) => theme.colors.gray4};
  cursor: pointer;
  background: ${({ theme }) => theme.colors.white};
  color: ${({ theme }) => theme.colors.gray1};
  ${({ theme }) => theme.fontStyles.largeRegular};
`;

const DishCategoryAllButton = () => {
  return (
    <CategoryButtonWrapper>
      <CategeoryButton onClick={(e) => console.log(e.target)}>모든 카테고리 보기</CategeoryButton>
    </CategoryButtonWrapper>
  );
};

export default DishCategoryAllButton;
