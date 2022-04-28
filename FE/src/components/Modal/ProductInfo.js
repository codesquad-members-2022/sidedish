import { useContext } from 'react';
import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import Tag from '../Tag';
import Text from '../Text';

const ProductInfoWrap = styled.div`
  width: 100%;
  height: auto;
  border-bottom: solid 1px ${colors.greyFour};
`;

const Name = styled.div``;

const PrimeCost = styled.div``;

const BadgeAndPrice = styled.div`
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-top: 3%;
`;

const DiscountPrice = styled.div`
  margin-left: 8px;
`;

const Badge = styled.div`
  display: flex;
`;

const Info = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  border-top: solid 1px ${colors.greyFour};
  margin-top: 6%;
`;

const Point = styled.div`
  margin-top: 4px;
  display: flex;
  align-items: center;
`;

const InfoDetail = styled.div`
  margin-left: 40px;
`;

const DeliveryInfoDetail = styled.div`
  margin-left: 28px;
`;

const DeliveryInfo = styled.div`
  display: flex;
  align-items: center;
  margin-top: 7px;
`;

const Charge = styled.div`
  display: flex;
  align-items: center;
  margin: 7px 0;
`;

const ProductInfo = () => {
  const ModalInfo = useContext(ModalInfoContextStore);

  return (
    <ProductInfoWrap>
      <Name>
        <Text font={FONT.LARGE_BOLD}>
          {ModalInfo.cardInfo.product_description}
        </Text>
      </Name>
      <PrimeCost>
        <Text font={FONT.SMALL_BOLD} textColor={colors.greyThree}>
          {ModalInfo.cardInfo.n_price}
        </Text>
      </PrimeCost>
      <BadgeAndPrice>
        <Badge>
          {ModalInfo.cardInfo?.badge?.map((badgeName, idx) => (
            <Tag key={badgeName + idx} badge={badgeName} />
          ))}
        </Badge>
        <DiscountPrice>
          <Text font={FONT.MEDIUM_XBOLD}>
            {ModalInfo.cardInfo.s_price?.toLocaleString()}원
          </Text>
        </DiscountPrice>
      </BadgeAndPrice>
      <Info>
        <Point>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            적립금
          </Text>
          <InfoDetail>
            <Text font={FONT.SMALL_BOLD}>{ModalInfo.cardInfo.point}</Text>
          </InfoDetail>
        </Point>
        <DeliveryInfo>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            배송정보
          </Text>
          <DeliveryInfoDetail>
            <Text font={FONT.SMALL_BOLD}>
              {ModalInfo.cardInfo.delivery_info}
            </Text>
          </DeliveryInfoDetail>
        </DeliveryInfo>
        <Charge>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            배송비
          </Text>
          <InfoDetail>
            <Text font={FONT.SMALL_BOLD}>
              {ModalInfo.cardInfo.delivery_fee}
            </Text>
          </InfoDetail>
        </Charge>
      </Info>
    </ProductInfoWrap>
  );
};

export default ProductInfo;
