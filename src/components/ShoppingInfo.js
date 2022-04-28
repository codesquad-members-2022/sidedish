import React from 'react';

import styled from 'styled-components';

const ShoppingInfo = ({ price, orderNum }) => {
  return (
    <StyledArticle>
      <StyledSpan>적립금 : {Math.floor(price * 0.01) * orderNum}원</StyledSpan>
      <StyledSpan>배송정보 : 서울 경기 새벽 배송, 전국 택배 배송</StyledSpan>
      <StyledSpan>배송비 : 2500원 (40,000원 이상 구매 시 무료)</StyledSpan>
    </StyledArticle>
  );
};

const StyledArticle = styled.article``;

const StyledSpan = styled.span`
  display: block;
  margin-top: 10px;
`;

export default ShoppingInfo;
