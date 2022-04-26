import React, { useState } from 'react';
import CategoryMenu from './CategoryMenu';
import styled from 'styled-components';

function Main({ categories, showModal }) {
  const [isShowAllCategories, setIsShowAllCategories] = useState(false);

  function showAllCategories() {
    setIsShowAllCategories(true);
  }
  return (
    <MainWrap>
      {isShowAllCategories ? (
        categories.map(({ name, id }) => <CategoryMenu key={id} name={name} showModal={showModal}></CategoryMenu>)
      ) : (
        <>
          <CategoryMenu key={categories[0].id} name={categories[0].name} showModal={showModal}></CategoryMenu>
          <CategoryShowButton onClick={showAllCategories}>모든 카테고리 보기</CategoryShowButton>
        </>
      )}
    </MainWrap>
  );
}
const MainWrap = styled.div`
  display: flex;
  flex-direction: column;
`;

const CategoryShowButton = styled.button`
  width: 250px;
  display: flex;
  justify-content: center;
  font-weight: 400;
  font-size: 20px;
  line-height: 30px;
  letter-spacing: -0.008em;
  padding: 16px 24px;
  margin: 85px auto 56px auto;
  border: 1px solid #ebebeb;
`;

export default Main;
