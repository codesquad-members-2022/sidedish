import React, { useState } from 'react';
import { MainWrapper, AllCategoryBtn } from './Main.style.js';
import categoryTitleData from 'data/categoryTitle';
import Slider from 'components/Slider/Slider.jsx';

const Main = () => {
  const [visibleIdx, setVisibleIdx] = useState(0);
  const [isBtnAvailable, setIsBtnAvailable] = useState(true);

  const handleAllCategoryBtnClick = () => {
    setVisibleIdx(categoryTitleData.length - 1);
    setIsBtnAvailable(false);
  };

  return (
    <MainWrapper>
      {categoryTitleData.map((v, i) => {
        return <Slider key={i} title={v.name} id={v.id} display={i <= visibleIdx ? 'block' : 'none'} />;
      })}
      {isBtnAvailable && <AllCategoryBtn onClick={handleAllCategoryBtnClick}>모든 카테고리 보기</AllCategoryBtn>}
    </MainWrapper>
  );
};

export default Main;
