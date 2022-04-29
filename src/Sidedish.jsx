import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSection from 'components/MenuSection/MenuSection';
import MoreButton from 'components/MoreButton';
import React, { Fragment, useState } from 'react';
import styled from 'styled-components';
import Modal from 'components/Modal/Modal';

export default function Sidedish() {
  const [isClickedMoreBtn, setClikedMoreBtn] = useState(false);
  const [isClickedCard, setClickedCard] = useState(false);
  const [cardHash, setCardHash] = useState('');
  const [selectedTabNum, setSelectedTabNum] = useState(0);
  return (
    <>
      {isClickedCard ? (
        <Modal selectedTabNum={selectedTabNum} setClickedCard={setClickedCard} cardHash={cardHash} />
      ) : null}
      <Wrap>
        <Header />
        <Main>
          <MainCategory
            selectedTabNum={selectedTabNum}
            setSelectedTabNum={setSelectedTabNum}
            setClickedCard={setClickedCard}
            setCardHash={setCardHash}
          />
          <MenuSection setClickedCard={setClickedCard} setCardHash={setCardHash} />
          {isClickedMoreBtn ? <OthersMenuSlider /> : null}
          {isClickedMoreBtn ? null : <MoreButton setClikedMoreBtn={setClikedMoreBtn} value="모든 카테고리 보기" />}
        </Main>
      </Wrap>
    </>
  );
}

function OthersMenuSlider() {
  const dummyData = ['국물 요리', '메인 요리'];
  // TODO: 데이터 fetch 해오면 교체
  return (
    <>
      {dummyData.map((_, idx) => (
        <MenuSection key={idx} />
      ))}
    </>
  );
}

const Wrap = styled.div({
  zIndex: '0'
});

const Main = styled.main({
  maxWidth: '1440px',
  margin: '0 auto',
  paddingBottom: '56px'
});
