import React from 'react';
import '../App.css';
import styled from 'styled-components';
import Text from '../components/Text';
import MoreButton from '../components/MoreButton';
import Tag from '../components/Tag';
import TabButton from '../components/TabButton';

const TemplateTitle = styled.h3({
  margin: '20px 0 -5px',
  'font-size': '30px',
  'font-family': 'Outfit',
});

const TemplateSubTitle = styled.span({
  margin: '15px 0 5px',
  display: 'block',
  color: '#777',
});

export default function Template() {
  return (
    <div className="Template">
      <TemplateTitle>LOGOTYPE</TemplateTitle>
      <TemplateSubTitle>Basic</TemplateSubTitle>

      <TemplateTitle>TYPOGRAPHY</TemplateTitle>
      <TemplateSubTitle>Small Regular</TemplateSubTitle>
      <Text size="SMALL" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Base Regular</TemplateSubTitle>
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Medium Regular</TemplateSubTitle>
      <Text size="MEDIUM" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Large Medium</TemplateSubTitle>
      <Text size="LARGE" weight="MEDIUM" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <TemplateSubTitle>X-Large Bold</TemplateSubTitle>
      <Text size="X_LARGE" weight="BOLD" color="BLACK" value="맛있는 반찬을 배달해드립니다." />

      <TemplateTitle>COLORS</TemplateTitle>
      <TemplateSubTitle>Black</TemplateSubTitle>
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray1</TemplateSubTitle>
      <Text size="BASE" color="GREY1" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray2</TemplateSubTitle>
      <Text size="BASE" color="GREY2" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray3</TemplateSubTitle>
      <Text size="BASE" color="GREY3" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray4</TemplateSubTitle>
      <Text size="BASE" color="GREY4" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Off-White</TemplateSubTitle>
      <Text size="BASE" color="OFF_WHITE" value="맛있는 반찬을 배달해드립니다." />

      <TemplateTitle>LABELS</TemplateTitle>
      <TemplateSubTitle>Event</TemplateSubTitle>
      <Tag type="이벤트특가" />
      <TemplateSubTitle>New</TemplateSubTitle>
      <Tag type="런칭특가" />

      <TemplateTitle>BUTTONS</TemplateTitle>
      <TemplateSubTitle>More Button</TemplateSubTitle>
      <MoreButton value="모든 카테고리 보기" />
      <TemplateSubTitle>Tab button</TemplateSubTitle>
      <TabButton value="풍성한 고기 반찬" />
    </div>
  );
}
