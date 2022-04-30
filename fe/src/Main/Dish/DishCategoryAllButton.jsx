import { useState, useCallback } from 'react';
import styled from 'styled-components';
import DishContainer from 'Main/Dish/DishContainer';
import axios from 'axios';
import { SERVER_URL } from 'constant.js';
import Loading from 'common/Loading';
import ErrorComponent from 'common/Error';

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
    fetchData();
  };

  const [firstCategory, setFirstCategory] = useState({});
  const [secondCategory, setSecondCategory] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);

  const fetchData = useCallback(async () => {
    try {
      const [firstData, secondData] = await axios.all([
        axios.get(`${SERVER_URL}categories/2/`),
        axios.get(`${SERVER_URL}categories/3/`),
      ]);
      if (firstData && secondData) {
        setIsLoading(false);
        setFirstCategory(firstData.data);
        setSecondCategory(secondData.data);
        setIsLoading(false);
      }
    } catch (error) {
      console.error('에러');
      setIsLoading(false);
      setIsError(true);
    }
  }, []);

  const renderAllCategory = () => {
    return !isError ? (
      <>
        {Object.keys(firstCategory).length !== 0 && (
          <DishContainer items={firstCategory}></DishContainer>
        )}
        {Object.keys(secondCategory).length !== 0 && (
          <DishContainer items={secondCategory}></DishContainer>
        )}
      </>
    ) : (
      <ErrorComponent />
    );
  };

  return (
    <>
      {allCategopryOpen ? (
        <CategoryButtonWrapper>
          <CategeoryButton onClick={onClick}>모든 카테고리 보기</CategeoryButton>
        </CategoryButtonWrapper>
      ) : (
        <>{!isLoading ? renderAllCategory() : <Loading />}</>
      )}
    </>
  );
};

export default DishCategoryAllButton;
