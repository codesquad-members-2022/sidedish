import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';
import TabBar from 'components/MainCategory/Tab/TabBar';
import Contents from 'components/MainCategory/Contents';

const MAIN_CATEGORY_TITLE = '한 번 주문하면 두 번 반하는 반찬';
const TAB_NAMES = ['풍성한 고기반찬', '편리한 반찬 세트', '맛있는 제철 요리', '우리 아이 영양 반찬'];

export default function MainCategory() {
  return (
    <Wrap>
      <Title>
        <Label>기획전</Label>
        <Text size="40px" weight="BOLD" value={MAIN_CATEGORY_TITLE} />
      </Title>
      <TabBar tabNames={TAB_NAMES} />
      <Contents />
    </Wrap>
  );
}

const Wrap = styled.div({
  padding: '56px 80px'
});

const Title = styled.h2({
  display: 'flex',
  gap: '16px',
  marginBottom: '24px'
});

const Label = styled.div({
  padding: '0 16px',
  lineHeight: '42px',
  border: ({ theme }) => `2px solid ${theme.COLOR.BLACK[100]}`,
  fontSize: ({ theme }) => theme.FONT.SIZE.MEDIUM,
  borderRadius: '21px'
});
