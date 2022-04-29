import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSection from 'components/MenuSection/MenuSection';
import MoreButton from 'components/MoreButton';
import React, { Fragment, useState } from 'react';
import styled from 'styled-components';
import Modal from 'components/Modal/Modal';

const sectionTitles = [
  '식탁을 풍성하게 하는 정갈한 밑반찬',
  '정성이 담긴 뜨끈뜨끈 국물 요리',
  '모두가 좋아하는 든든한 메인 요리'
];
const PATHs = ['main', 'soup', 'side'];

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
          {isClickedMoreBtn ? (
            <MenuSections setClickedCard={setClickedCard} setCardHash={setCardHash} />
          ) : (
            <MenuSection
              key={PATHs[0]}
              title={sectionTitles[0]}
              menuName={PATHs[0]}
              setClickedCard={setClickedCard}
              setCardHash={setCardHash}
            />
          )}
          {isClickedMoreBtn ? null : <MoreButton setClikedMoreBtn={setClikedMoreBtn} value="모든 카테고리 보기" />}
        </Main>
      </Wrap>
    </>
  );
}

function MenuSections() {
  return (
    <>
      {PATHs.map((PATH, idx) => (
        <MenuSection key={PATH} title={sectionTitles[idx]} menuName={PATH} />
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
