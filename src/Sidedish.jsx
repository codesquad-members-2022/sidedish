import Header from 'components/Header/Header';
import MainCategory from 'components/MainCategory/MainCategory';
import MenuSection from 'components/MenuSection/MenuSection';
import MoreButton from 'components/MoreButton';
import React, { Fragment, useState } from 'react';
import styled from 'styled-components';

const sectionTitles = [
  '식탁을 풍성하게 하는 정갈한 밑반찬',
  '정성이 담긴 뜨끈뜨끈 국물 요리',
  '모두가 좋아하는 든든한 메인 요리'
];
const PATHs = ['main', 'soup', 'side'];

export default function Sidedish() {
  const [isClickedMoreBtn, setClikedMoreBtn] = useState(false);
  return (
    <div>
      <Header />
      <Main>
        <MainCategory />
        {isClickedMoreBtn ? (
          <MenuSections />
        ) : (
          <MenuSection key={PATHs[0]} title={sectionTitles[0]} menuName={PATHs[0]} />
        )}
        {isClickedMoreBtn ? null : <MoreButton setClikedMoreBtn={setClikedMoreBtn} value="모든 카테고리 보기" />}
      </Main>
    </div>
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

const Main = styled.main({
  maxWidth: '1440px',
  margin: '0 auto',
  paddingBottom: '56px'
});
