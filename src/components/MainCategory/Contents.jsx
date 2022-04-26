import React from 'react';
import styled from 'styled-components';
import Card from 'components/common/Card/Card';

export default function MainCategory() {
  return (
    <Wrap>
      <Card
        size="LARGE"
        imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
        title="오리 주물럭_반조리"
        desc="감질맛 나는 매콤한 양념"
        curPrice="12,640원"
        prevPrice="15,800원"
        tags={['이벤트특가', '런칭특가']}
      />
      <Card
        size="LARGE"
        imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
        title="오리 주물럭_반조리"
        desc="감질맛 나는 매콤한 양념"
        curPrice="12,640원"
        prevPrice="15,800원"
        tags={['이벤트특가', '런칭특가']}
      />
      <Card
        size="LARGE"
        imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
        title="오리 주물럭_반조리"
        desc="감질맛 나는 매콤한 양념"
        curPrice="12,640원"
        prevPrice="15,800원"
        tags={['이벤트특가', '런칭특가']}
      />
    </Wrap>
  );
}

const Wrap = styled.div({
  display: 'flex',
  gap: '24px',
  paddingTop: '34px'
});
