import React from 'react';
import styled, { css } from 'styled-components';
import { FlexDiv } from 'common/FlexDiv';
import { setPrice } from 'util';
import ModalOrder from './ModalOrderInfo';

const DetailContainer = styled.div`
  min-width: 440px;
  position: relative;
  display: flex;
  flex-direction: column;
`;

const ModalProductInfo = styled.div`
  margin-bottom: 24px;

  h3 {
    margin-bottom: 16px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.largeBold};
  }

  .item__default-price {
    display: inline-block;
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.gray3};
    ${({ theme }) => theme.fontStyles.smallBold};
  }

  .item__normal-price {
    ${({ theme }) => theme.fontStyles.largeBold};
  }
`;

const ItemTag = styled.span`
  display: inline-block;
  padding: 6px 16px;
  margin-right: 8px;
  border-radius: 999px;
  ${({ theme }) => theme.fontStyles.smallBold};
  color: ${({ theme }) => theme.colors.white};
  background: ${(props) => {
    switch (props.tag) {
      case '런칭특가':
        return css`
          ${({ theme }) => theme.colors.orange}
        `;
      case '이벤트특가':
        return css`
          ${({ theme }) => theme.colors.green}
        `;
      case '정가':
        return css`
          ${({ theme }) => theme.colors.black}
        `;
      default:
        return;
    }
  }};
`;

const ModalDeliveryInfo = styled.div`
  margin-bottom: 26px;
  padding: 16px 0;
  border-top: 1px solid ${({ theme }) => theme.colors.gray3};
  border-bottom: 1px solid ${({ theme }) => theme.colors.gray3};
`;

const DeliveryInnerDiv = styled.div`
  margin: 8px 0;
  ${({ theme }) => theme.fontStyles.xSmallRegular};

  .delivery__title {
    display: inline-block;
    min-width: 60px;
    margin-right: 16px;
    color: ${({ theme }) => theme.colors.gray2};
  }

  .delivery__content {
    color: ${({ theme }) => theme.colors.black};
  }
`;

const ModalDetailContainer = ({ item }) => {
  return (
    <DetailContainer>
      <ModalProductInfo>
        <h3>{item.name}</h3>
        {item.discountPrice !== item.normalPrice ? (
          <>
            <span className="item__default-price">{setPrice(item.normalPrice)}원</span>
            <FlexDiv column={'center'}>
              <ItemTag className="item__tag" tag={item.discountPolicy}>
                {item.discountPolicy}
              </ItemTag>
              <span className="item__normal-price">{setPrice(item.discountPrice)}원</span>
            </FlexDiv>
          </>
        ) : (
          <span className="item__normal-price">{setPrice(item.discountPrice)}원</span>
        )}
      </ModalProductInfo>
      <ModalDeliveryInfo>
        <DeliveryInnerDiv>
          <span className="delivery__title">적립금</span>
          <span className="delivery__content">{setPrice(item.point)}원</span>
        </DeliveryInnerDiv>
        <DeliveryInnerDiv>
          <span className="delivery__title">배송정보</span>
          <span className="delivery__content">서울 경기 새벽 배송, 전국 택배 배송</span>
        </DeliveryInnerDiv>
        <DeliveryInnerDiv>
          <span className="delivery__title">배송비</span>
          <span className="delivery__content">2,500원 (40,000원 이상 구매 시 무료)</span>
        </DeliveryInnerDiv>
      </ModalDeliveryInfo>
      <ModalOrder item={item} />
    </DetailContainer>
  );
};

export default React.memo(ModalDetailContainer);
