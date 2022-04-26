import React from 'react';
import styled from 'styled-components';
import IconButton from 'components/common/IconButton';
import Card from './common/Card/Card';

export default function Slider() {
  return (
    <Wrap>
      <Button>
        <IconButton icon="prev" width="8px" height="16px" />
      </Button>
      <CardWrap>
        <Card
          size="MEDIUM"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={['이벤트특가', '런칭특가']}
        />
        <Card
          size="MEDIUM"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={['이벤트특가', '런칭특가']}
        />
        <Card
          size="MEDIUM"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={['이벤트특가', '런칭특가']}
        />
        <Card
          size="MEDIUM"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={['이벤트특가', '런칭특가']}
        />
      </CardWrap>
      <Button>
        <IconButton icon="next" width="8px" height="16px" />
      </Button>
    </Wrap>
  );
}

const Wrap = styled.div({
  display: 'flex'
});

const CardWrap = styled.div({
  display: 'flex',
  gap: '24px',
  maxWidth: '1280px',
  overflowX: 'hidden'
});

const Button = styled.button({});
