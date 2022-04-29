import { useContext } from 'react';
import styled from 'styled-components';

import { moneyToWon } from '../../common/utils';
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
  console.log(ModalInfo.cardInfo);
  return (
    <ProductInfoWrap>
      <Name>
        <Text font={FONT.LARGE_BOLD}>{ModalInfo.cardInfo.title}</Text>
      </Name>
      <PrimeCost>
        <Text font={FONT.SMALL_BOLD} textColor={colors.greyThree}>
          {ModalInfo.cardInfo.price}
        </Text>
      </PrimeCost>
      <BadgeAndPrice>
        <Badge>
          {[ModalInfo.cardInfo.badge].map((badgeName, idx) => (
            <Tag key={badgeName + idx} badge={badgeName} />
          ))}
        </Badge>
        <DiscountPrice>
          <Text font={FONT.MEDIUM_XBOLD}>
            {moneyToWon(ModalInfo.cardInfo.discountPrice)}
          </Text>
        </DiscountPrice>
      </BadgeAndPrice>
      <Info>
        <Point>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            적립금
          </Text>
          <InfoDetail>
            <Text font={FONT.SMALL_BOLD}>
              {moneyToWon(ModalInfo.cardInfo.rewardPoint)}
            </Text>
          </InfoDetail>
        </Point>
        <DeliveryInfo>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            배송정보
          </Text>
          <DeliveryInfoDetail>
            <Text font={FONT.SMALL_BOLD}>
              {ModalInfo.cardInfo.shipInfo.shippingDescription}
            </Text>
          </DeliveryInfoDetail>
        </DeliveryInfo>
        <Charge>
          <Text font={FONT.XSMALL} textColor={colors.greyTwo}>
            배송비
          </Text>
          <InfoDetail>
            <Text font={FONT.SMALL_BOLD}>
              {moneyToWon(ModalInfo.cardInfo.shipInfo.shippingFee)}
            </Text>
          </InfoDetail>
        </Charge>
      </Info>
    </ProductInfoWrap>
  );
};

export default ProductInfo;
