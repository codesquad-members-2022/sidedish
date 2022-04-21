import React from 'react';
import styled from 'styled-components';
import Text from '../components/Text';
import Button from '../components/Button';
import IconButton from '../components/IconButton';
import MoreButton from '../components/MoreButton';
import Tag from '../components/Tag';
import TabButton from '../components/TabButton';
import TabBar from '../components/TabBar';
import Header from '../components/Header';
import Card from '../components/Card';

export default function Template() {
  return (
    <Wrap>
      <TemplateTitle>LOGOTYPE</TemplateTitle>
      <TemplateSubTitle>Basic</TemplateSubTitle>
      <h1>
        <Text size="2.857rem" family="LOGO" value="Ordering" />
      </h1>

      <TemplateTitle>TYPOGRAPHY</TemplateTitle>
      <TemplateSubTitle>Small Regular</TemplateSubTitle>
      <Text size="SMALL" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Base Regular</TemplateSubTitle>
      <Text value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Medium Regular</TemplateSubTitle>
      <Text size="MEDIUM" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Large Medium</TemplateSubTitle>
      <Text size="LARGE" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>X_LARGE Medium</TemplateSubTitle>
      <Text size="X_LARGE" weight="MEDIUM" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>TITLE_3</TemplateSubTitle>
      <Text size="TITLE_3" weight="BOLD" value="맛있는 반찬을 배달해드립니다." />

      <TemplateTitle>COLORS</TemplateTitle>
      <TemplateSubTitle>Black</TemplateSubTitle>
      <Text value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Gray1</TemplateSubTitle>
      <Text color="GREY1" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Gray2</TemplateSubTitle>
      <Text color="GREY2" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Gray3</TemplateSubTitle>
      <Text color="GREY3" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Gray4</TemplateSubTitle>
      <Text color="GREY4" value="맛있는 반찬을 배달해드립니다." />
      <br />

      <TemplateSubTitle>Off-White</TemplateSubTitle>
      <Text color="OFF_WHITE" value="맛있는 반찬을 배달해드립니다." />

      <TemplateTitle>LABELS</TemplateTitle>
      <TemplateSubTitle>Event</TemplateSubTitle>
      <Tag type="이벤트특가" />

      <TemplateSubTitle>New</TemplateSubTitle>
      <Tag type="런칭특가" />

      <TemplateTitle>BUTTONS</TemplateTitle>
      <TemplateSubTitle>Button</TemplateSubTitle>
      <Button value="주문하기" />
      <Button value="품절" disabled />

      <TemplateSubTitle>Icon Button</TemplateSubTitle>
      <Row>
        <IconButton icon="search" width="24px" height="24px" />
        <IconButton icon="user" width="22px" height="22px" />
        <IconButton icon="cart" width="27px" height="28px" />
        <IconButton icon="prev" width="11px" height="20px" />
        <IconButton icon="next" width="11px" height="20px" />
        <IconButton icon="minus" width="16px" height="2px" />
        <IconButton icon="plus" width="32px" height="32px" />
      </Row>

      <TemplateSubTitle>More Button</TemplateSubTitle>
      <MoreButton value="모든 카테고리 보기" />

      <TemplateSubTitle>Tab button</TemplateSubTitle>
      <TabButton value="Text" />
      <TabButton isSelected value="Text" />

      <TemplateTitle>Tab Bar</TemplateTitle>
      <TabBar tabNames={['훌륭한 고기 반찬', '편리한 반찬 세트', '맛있는 제철 요리', '우리 아이 영양 반찬']} />

      <TemplateTitle>Card</TemplateTitle>
      <Row>
        <div>
          <TemplateSubTitle>Large</TemplateSubTitle>
          <Card
            size="LARGE"
            imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
            title="오리 주물럭_반조리"
            desc="감질맛 나는 매콤한 양념"
            curPrice="12,640원"
            prevPrice="15,800원"
            tags={['이벤트특가', '런칭특가']}
          />
        </div>
        <div>
          <TemplateSubTitle>Medium</TemplateSubTitle>
          <Card
            size="MEDIUM"
            imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
            title="오리 주물럭_반조리"
            desc="감질맛 나는 매콤한 양념"
            curPrice="12,640원"
            prevPrice="15,800원"
            tags={['이벤트특가', '런칭특가']}
          />
        </div>
        <div>
          <TemplateSubTitle>Small</TemplateSubTitle>
          <Card
            size="SMALL"
            imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
            title="오리 주물럭_반조리"
            desc="감질맛 나는 매콤한 양념"
            curPrice="12,640원"
            prevPrice="15,800원"
            tags={['이벤트특가', '런칭특가']}
          />
        </div>
      </Row>

      <TemplateTitle>HEADER</TemplateTitle>
      <Header />
    </Wrap>
  );
}

const TemplateTitle = styled.h3`
  margin: 50px 0 15px;
  font-size: 30px;
  font-family: 'Outfit', sans-serif;
  &:first-child {
    margin-top: 0;
  }
`;

const TemplateSubTitle = styled.span`
  margin: 15px 0 5px;
  display: block;
  color: #777;
  font-size: 12px;
  font-style: italic;
  h3 + & {
    margin-top: -10px;
  }
`;

const Row = styled.div({
  display: 'flex',
  gap: '30px',
});

const Wrap = styled.div({
  padding: '30px',
});
