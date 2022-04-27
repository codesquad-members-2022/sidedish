import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSlider from 'components/MenuSlider';
import MoreButton from 'components/MoreButton';
import React from 'react';
import styled from 'styled-components';

export default function Sidedish() {
  return (
    <div>
      <Header />
      <Main>
        <MainCategory />
        <MenuSlider />
        <MoreButton value="모든 카테고리 보기" />
      </Main>
    </div>
  );
}

const Main = styled.main({
  maxWidth: '1440px',
  margin: '0 auto',
  paddingBottom: '56px'
});
