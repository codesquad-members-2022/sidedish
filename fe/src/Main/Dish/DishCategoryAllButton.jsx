import { useState } from 'react';
import styled from 'styled-components';
import DishContainer from 'Main/Dish/DishContainer';

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
  const [allCategopryOpen, setAllCategoryOpen] = useState(true);

  const onClick = () => {
    setAllCategoryOpen(false);
  };

  return (
    <>
      {allCategopryOpen ? (
        <CategoryButtonWrapper>
          <CategeoryButton onClick={onClick}>모든 카테고리 보기</CategeoryButton>
        </CategoryButtonWrapper>
      ) : (
        <>
          <DishContainer />
          <DishContainer />
        </>
      )}
    </>
  );
};

export default DishCategoryAllButton;
