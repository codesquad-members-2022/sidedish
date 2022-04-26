import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import React from 'react';
import styled from 'styled-components';

export default function Sidedish() {
  return (
    <div>
      <Header />
      <Main>
        <MainCategory />
      </Main>
    </div>
  );
}

const Main = styled.main({
  borderTop: ({ theme }) => `1px solid ${theme.COLOR.BLACK[100]}`
});
