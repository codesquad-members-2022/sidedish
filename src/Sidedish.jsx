import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSlider from 'components/MenuSection/MenuSection';
import MoreButton from 'components/MoreButton';
import React, { Fragment, useState } from 'react';
import styled from 'styled-components';

export default function Sidedish() {
  const [isClickedMoreBtn, setClikedMoreBtn] = useState(false);
  return (
    <div>
      <Header />
      <Main>
        <MainCategory />
        <MenuSlider />
        {isClickedMoreBtn ? <OthersMenuSlider /> : null}
        {isClickedMoreBtn ? null : <MoreButton setClikedMoreBtn={setClikedMoreBtn} value="모든 카테고리 보기" />}
      </Main>
    </div>
  );
}

function OthersMenuSlider() {
  const dummyData = ['국물 요리', '메인 요리'];
  // TODO: 데이터 fetch 해오면 교체
  return (
    <>
      {dummyData.map((_, idx) => (
        <MenuSlider key={idx} />
      ))}
    </>
  );
}

const Main = styled.main({
  maxWidth: '1440px',
  margin: '0 auto',
  paddingBottom: '56px'
});
