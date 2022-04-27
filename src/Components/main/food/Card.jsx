import React from 'react';
import { useState } from 'react';
import styled from 'styled-components';
import {
  F_basic,
  F_basicCenter,
  F_Center,
  TextEllipsis,
} from '../../../Assets/CommonStyle';
import Title from '../../Title';

const ImgWrap = styled.div`
  position: relative;
`;

const ImgTag = styled.img`
  display: block;
  width: 100%;
`;

function Img({ data }) {
  const [isHover, setIsHover] = useState(false);

  const hoverHandler = () => {
    setIsHover(!isHover);
  };

  return (
    <ImgWrap onMouseEnter={hoverHandler} onMouseLeave={hoverHandler}>
      <ImgTag src={data.img} alt={data.alt} />
      {isHover ? <Delivery delivery_type={data.delivery} /> : null}
    </ImgWrap>
  );
}

const DeleveryBg = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.1);
`;

const DeleveryBox = styled.div`
  position: absolute;
  top: 20px;
  right: 20px;
  ${F_Center}
  flex-direction: column;
  width: 142px;
  height: 149px;
  border: 1px solid ${({ theme }) => theme.Color.black};
  border-radius: 50%;
  background: rgba(248, 247, 247, 0.8);

  span {
    font-size: 16px;
    font-weight: 500;
    padding: 8px 0;

    & + span {
      border-top: 1px solid ${({ theme }) => theme.Color.black};
    }
  }
`;

function Delivery({ delivery_type }) {
  if (!delivery_type) return;

  const DELIVERY_INFO = delivery_type.map((type, idx) => (
    <span key={idx}>{type}</span>
  ));

  return (
    <DeleveryBg>
      <DeleveryBox>{DELIVERY_INFO}</DeleveryBox>
    </DeleveryBg>
  );
}

const TestWrap = styled.div`
  padding-top: 16px;
`;

const Description = styled.p`
  margin: 8px 0;
  font-size: ${({ theme }) => theme.FontSize.Small};
  font-weight: ${({ theme }) => theme.FontWeight.Regular};
  color: ${({ theme }) => theme.Color.gray2};
  ${TextEllipsis}
`;

function Text({ data }) {
  return (
    <TestWrap>
      <Title
        title={data.title}
        fontSize="Medium"
        fontWeight="Bold"
        color="gray1"
        as="h3"
      />
      <Description>{data.description}</Description>
      <Price price={data} />
      <Badge info={data.badge} />
    </TestWrap>
  );
}

const PriceBox = styled.div`
  ${F_basicCenter}

  span:nth-child(1) {
    font-size: ${({ theme }) => theme.FontSize.Medium};
    font-weight: ${({ theme }) => theme.FontWeight.Bold};
  }

  span:nth-child(2) {
    margin-left: 8px;
    font-size: ${({ theme }) => theme.FontSize.Small};
    font-weight: ${({ theme }) => theme.FontWeight.Regular};
    color: ${({ theme }) => theme.Color.gray3};
    text-decoration: line-through;
  }
`;

function Price({ price }) {
  const SALE_PRICE = price.s_price ? <span>{price.s_price}</span> : null;
  const NORMAL_PRICE = price.n_price ? <span>{price.n_price}</span> : null;

  return (
    <PriceBox>
      {SALE_PRICE}
      {NORMAL_PRICE}
    </PriceBox>
  );
}

const BadgeBox = styled.div`
  ${F_basic}
  margin-top: 16px;
`;

const BadgeItem = styled.span`
  height: 30px;
  padding: 0 16px;
  border-radius: 15px;
  line-height: 30px;
  font-size: ${({ theme }) => theme.FontSize.XSmall};
  font-weight: ${({ theme }) => theme.FontWeight.Bold};
  color: ${({ theme }) => theme.Color.white};
  background: ${({ type, theme: { Color } }) => Color[getBadgeColor(type)]};

  & + span {
    margin-left: 8px;
  }
`;

function getBadgeColor(type) {
  switch (type) {
    case '런칭특가':
      return 'orange';
    case '이벤트특가':
      return 'green';
    default:
      return 'black';
  }
}

function Badge({ info }) {
  if (!info) return;

  const BADGES = info.map((item, idx) => {
    return (
      <BadgeItem key={idx} type={item}>
        {item}
      </BadgeItem>
    );
  });

  return <BadgeBox>{BADGES}</BadgeBox>;
}

const CardItem = styled.div`
  cursor: pointer;
`;

function Card({ cardData }) {
  const CARD_IMG_DATA = {
    img: cardData.image,
    alt: cardData.alt,
    delivery: cardData.delivery_type,
  };
  return (
    <CardItem data-hash={cardData.detail_hash}>
      <Img data={CARD_IMG_DATA} />
      <Text data={cardData} />
    </CardItem>
  );
}

export default Card;
