/* eslint-disable camelcase */
/* API에서 받아오는 값중에 _가 포함되어 있어 규칙을 비활성화 합니다. */
import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import THEME from 'variable/theme';
import Button from 'components/common/Button';
import Tag from 'components/common/Card/Tag';
import IconButton from 'components/common/IconButton';
import Text from 'components/utils/Text';
import Picture from 'components/Modal/Picture';
import DeliveryInfo from 'components/Modal/DeliveryInfo';

const END_POINT = 'https://api.codesquad.kr/onban/';
const CATEGORIES = ['main', 'soup', 'side'];

export default function Modal({ setClickedCard, cardHash, selectedTabNum }) {
  const [sideDish, setSideDish] = useState(false);
  const [curPrice, setCurPrice] = useState(0);
  const [quantity, setQuantity] = useState(1);
  const { title, badge, image, alt, n_price, s_price } = sideDish;

  useEffect(() => {
    fetchModalData();
  }, []);

  useEffect(() => {
    const DEFAULT_MONEY = '0원';
    const sellingPrice = detachNumberToMoneyStr(sideDish.s_price || DEFAULT_MONEY);
    setCurPrice(sellingPrice);
  }, [sideDish]);

  return (
    <Wrap onClick={() => setClickedCard(false)}>
      <ModalContainer onClick={e => e.stopPropagation()}>
        <ProductDetail>
          <Row>
            <Picture image={image} alt={alt} />
            <Column>
              <Text size="X_LARGE" weight="MEDIUM" value={title} />
              <NormalPrice>
                <Text weight="MEDIUM" color="GREY_300" value={n_price} />
              </NormalPrice>
              <SellingPrice>
                {sideDish.badge && badge.map((type, idx) => <Tag key={idx} type={type} />)}
                <Text weight="X_LARGE" color="MEDIUM" value={s_price} />
              </SellingPrice>
              <DeliveryInfo />
              <TotalWrap>
                <Quantity>
                  <IconButton
                    onClick={handleQuantitySubtract}
                    width="8.5px"
                    height="15px"
                    stroke={THEME.COLOR.GREY[200]}
                    icon="minus"
                  />
                  <Number>{quantity}</Number>
                  <IconButton
                    onClick={handleQuantityAddition}
                    width="15px"
                    height="15px"
                    stroke={THEME.COLOR.GREY[200]}
                    icon="plus"
                  />
                </Quantity>
                <TotalPrice>
                  <Text size="MEDIUM" color="GREY_200" value="총 주문금액" />
                  <Text size="X_LARGE" value={attachComaAndUnit(curPrice * quantity, '원')} />
                </TotalPrice>
              </TotalWrap>
              <Button value="주문하기" />
            </Column>
          </Row>
        </ProductDetail>
        {/* TODO: Recommend 컴포넌트 추가 */}
        <Recommend />
      </ModalContainer>
    </Wrap>
  );

  function fetchModalData() {
    const URL = `${END_POINT}${CATEGORIES[selectedTabNum]}/${cardHash}`;

    fetch(URL)
      .then(res => res.json())
      .then(sideDishJSON => setSideDish(sideDishJSON), handleError);

    function handleError(error) {
      setSideDish({});
      throw new Error(`${error}: 데이터를 성공적으로 불러오지 못했습니다.`);
    }
  }

  function handleQuantitySubtract() {
    const isUnderQuantityOne = quantity < 1;
    if (isUnderQuantityOne) {
      return;
    }
    setQuantity(+quantity - 1);
  }

  function handleQuantityAddition() {
    setQuantity(+quantity + 1);
  }

  function detachNumberToMoneyStr(str) {
    const regExpComaAndUnit = /(,|원)/g;
    return str.replaceAll(regExpComaAndUnit, '');
  }

  function attachComaAndUnit(num, unit) {
    const res = num.toString().split('');
    const len = res.length;
    let cnt = 0;
    for (let i = len - 1; i > 0; i -= 1) {
      cnt += 1;
      if (cnt === 3) {
        res.splice(i, 0, ',');
        cnt = 0;
      }
    }
    return `${res.join('')}${unit}`;
  }
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
  marginRight: '140px'
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
