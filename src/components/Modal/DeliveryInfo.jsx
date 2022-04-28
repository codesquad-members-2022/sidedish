import Text from 'components/utils/Text';
import React from 'react';
import styled from 'styled-components';

function DeliveryInfo() {
  return (
    <Wrap>
      <Row>
        <Grey>
          <Text size="SMALL" color="GREY_200" value="적립금" />
        </Grey>
        <Text size="SMALL" value="126원" />
      </Row>
      <Row>
        <Grey>
          <Text size="SMALL" color="GREY_200" value="배송정보" />
        </Grey>
        <Text size="SMALL" value="서울 경기 새벽 배송, 전국 택배 배송" />
      </Row>
      <Row>
        <Grey>
          <Text size="SMALL" color="GREY_200" value="배송비" />
        </Grey>
        <Text size="SMALL" value="2,500원 (40,000원 이상 구매 시 무료)" />
      </Row>
    </Wrap>
  );
}

const Row = styled.div({
  display: 'flex'
});

const Column = styled.div({
  display: 'flex',
  flexDirection: 'column'
});

const Wrap = styled(Column)({
  width: '440px',
  height: '103px',
  gap: '8px',
  borderTop: ({ theme }) => `1px solid ${theme.COLOR.GREY[400]}`,
  borderBottom: ({ theme }) => `1px solid ${theme.COLOR.GREY[400]}`,
  paddingTop: '16px',
  paddingBottom: '16px'
});

const Grey = styled.div({
  width: '60px',
  marginRight: '16px'
});

export default DeliveryInfo;
