import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSection from 'components/MenuSection/MenuSection';
import MoreButton from 'components/MoreButton';
import React, { useState } from 'react';
import styled from 'styled-components';
import Modal from 'components/Modal/Modal';

const sectionTitles = [
  '식탁을 풍성하게 하는 정갈한 밑반찬',
  '정성이 담긴 뜨끈뜨끈 국물 요리',
  '모두가 좋아하는 든든한 메인 요리'
];
const PATHs = ['side', 'soup', 'main'];

export default function Sidedish() {
  const [isClickedMoreBtn, setClikedMoreBtn] = useState(false);
  const [isClickedCard, setClickedCard] = useState(false);
  const [cardHash, setCardHash] = useState('');
  const [selectedCardCategory, setSelectedCardCategory] = useState('side');
  return (
    <>
      {isClickedCard && (
        <Modal selectedCardCategory={selectedCardCategory} setClickedCard={setClickedCard} cardHash={cardHash} />
      )}
      <Wrap>
        <Header />
        <Main>
          <MainCategory
            setClickedCard={setClickedCard}
            setCardHash={setCardHash}
            setSelectedCardCategory={setSelectedCardCategory}
          />
          <MenuSection
            key={PATHs[0]}
            title={sectionTitles[0]}
            menuName={PATHs[0]}
            setClickedCard={setClickedCard}
            setCardHash={setCardHash}
            setSelectedCardCategory={setSelectedCardCategory}
          />
          {isClickedMoreBtn && (
            <TheOthersSections
              setCardHash={setCardHash}
              setClickedCard={setClickedCard}
              setSelectedCardCategory={setSelectedCardCategory}
            />
          )}
          {isClickedMoreBtn || <MoreButton setClikedMoreBtn={setClikedMoreBtn} value="모든 카테고리 보기" />}
        </Main>
      </Wrap>
    </>
  );
}

function TheOthersSections({ setCardHash, setClickedCard, setSelectedCardCategory }) {
  return (
    <>
      {PATHs.map((PATH, idx) => {
        const isFirstIndex = idx === 0;
        if (isFirstIndex) {
          return null;
        }
        return (
          <MenuSection
            key={PATH}
            title={sectionTitles[idx]}
            menuName={PATH}
            setClickedCard={setClickedCard}
            setCardHash={setCardHash}
            setSelectedCardCategory={setSelectedCardCategory}
          />
        );
      })}
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
