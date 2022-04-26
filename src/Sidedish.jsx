import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSlider from 'components/MenuSlider';
import React from 'react';
import styled from 'styled-components';

export default function Sidedish() {
  return (
    <div>
      <Header />
      <Main>
        <MainCategory />
        <MenuSlider />
      </Main>
    </div>
  );
}

const Main = styled.main({
  borderTop: ({ theme }) => `1px solid ${theme.COLOR.BLACK[100]}`
});
