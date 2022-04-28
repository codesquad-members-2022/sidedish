/* eslint-disable no-unused-vars */
/* eslint-disable react/self-closing-comp */
import Button from 'components/common/Button';
import Tag from 'components/common/Card/Tag';
import IconButton from 'components/common/IconButton';
import Text from 'components/utils/Text';
import React from 'react';
import styled from 'styled-components';
import THEME from 'variable/theme';
import Picture from 'components/Modal/Picture';
import DeliveryInfo from './DeliveryInfo';

export default function Modal({ setClickedCard }) {
  return (
    <Wrap
      onClick={() => {
        setClickedCard(false);
      }}
    >
      <ModalContainer onClick={e => e.stopPropagation()}>
        <ProductDetail>
          <Row>
            <Picture />
            <Column>
              <Text size="X_LARGE" weight="MEDIUM" value="오리 주물럭_반조리" />
              <NormalPrice>
                <Text weight="MEDIUM" color="GREY_300" value="15,800원" />
              </NormalPrice>
              <SellingPrice>
                <Tag type="런칭특가" />
                <Text weight="X_LARGE" color="MEDIUM" value="12,640원" />
              </SellingPrice>
              <DeliveryInfo />
              <TotalWrap>
                <Quantity>
                  <IconButton width="8.5px" height="15px" stroke={THEME.COLOR.GREY[200]} icon="minus" />
                  <Number>1</Number>
                  <IconButton width="15px" height="15px" stroke={THEME.COLOR.GREY[200]} icon="plus" />
                </Quantity>
                <TotalPrice>
                  <Text size="MEDIUM" color="GREY_200" value="총 주문금액" />
                  <Text size="X_LARGE" value="12,640원" />
                </TotalPrice>
              </TotalWrap>
              <Button value="주문하기" />
            </Column>
          </Row>
        </ProductDetail>
        <Recommend></Recommend>
      </ModalContainer>
    </Wrap>
  );
}

const Wrap = styled.span({
  width: '100vw',
  height: '100vh',
  backgroundColor: '#00000066',
  position: 'fixed',
  top: '0',
  left: '0',
  zIndex: '1'
});

const ModalContainer = styled.div({
  width: '960px',
  height: '992px',
  backgroundColor: 'white',
  margin: 'auto auto'
});

const ProductDetail = styled.div({
  padding: '76px 48px 48px 48px',
  height: '596px'
});

const Row = styled.div({
  display: 'flex'
});

const Column = styled.div({
  display: 'flex',
  flexDirection: 'column'
});

const SellingPrice = styled(Row)({
  alignItems: 'center',
  gap: '8px',
  marginBottom: '24px'
});

const NormalPrice = styled.div({
  marginTop: '16px',
  marginBottom: '16px'
});

const Quantity = styled(Row)({
  marginRight: '160px'
});

const Number = styled.div({
  alignSelf: 'center'
});

const TotalPrice = styled(Row)({
  alignSelf: 'center',
  gap: '16px'
});

const TotalWrap = styled(Row)({
  marginTop: '26px',
  marginBottom: '122px'
});

const Recommend = styled.div({
  padding: '48px 48px 64px 48px',
  height: '396px'
});
