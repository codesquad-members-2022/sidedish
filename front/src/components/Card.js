import React, { useState } from 'react';
import styled from 'styled-components';

function Card({ size, item, showModal }) {
  const { id, image, title, contents, origin_price, discount_price, early_delivery, badge_title } = item;
  const cardSizes = {
    large: { width: 411, height: 565 },
    medium: { width: 302, height: 456 },
    small: { width: 160, height: 226 },
  };
  const badgeColores = {
    이벤트특가: '#6DD028',
    런칭특가: '#FF8E14',
  };

  const [isHover, setIsHover] = useState(false);

  function showDelevery() {
    setIsHover(true);
  }
  function hideDelevery() {
    setIsHover(false);
  }
  return (
    <StyledCard key={id} cardSize={cardSizes[size]} onClick={showModal}>
      <Thumbnail height={cardSizes[size].width} onMouseEnter={showDelevery} onMouseLeave={hideDelevery}>
        <Image src={image}></Image>
        {size !== 'small' && isHover && (
          <HoverThumbnail>
            <HoverInfo>
              <div>새벽배송</div>
              <Line />
              <div>전국택배</div>
            </HoverInfo>
          </HoverThumbnail>
        )}
      </Thumbnail>
      {size !== 'small' ? (
        <>
          <CardBody>
            <Title>{title}</Title>
            <Descript>{contents}</Descript>
            <Price>
              <DiscountPrice>{discount_price.toLocaleString()}</DiscountPrice>
              {discount_price !== origin_price && <OriginPrice>{origin_price.toLocaleString()}</OriginPrice>}
            </Price>
          </CardBody>
          <Badges>
            {badge_title.map((badgeTitle, index) => (
              <Badge key={index} background={badgeColores[badgeTitle]}>
                {badgeTitle}
              </Badge>
            ))}
          </Badges>
        </>
      ) : (
        <>
          <SmallTitle>{title}</SmallTitle>
          <Price>
            <DiscountPrice>{discount_price.toLocaleString()}</DiscountPrice>
            <OriginPrice>{origin_price.toLocaleString()}</OriginPrice>
          </Price>
        </>
      )}
    </StyledCard>
  );
}

Card.defaultProps = {
  size: 'large',
  item: {
    id: 0,
    image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
    title: '스테이크',
    contents: '스테이크 먹고싶다',
    origin_price: 50000,
    discount_price: 39800,
    early_delivery: true,
    badge_title: ['이벤트특가', '런칭특가'],
    categories: ['메인 요리'],
  },
};

const StyledCard = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: ${props => props.cardSize.width}px;
  height: ${props => props.cardSize.height}px;
`;
const Thumbnail = styled.div`
  position: relative;
  height: ${props => props.height}px;
`;
const Image = styled.img`
  display: block;
  width: 100%;
  height: auto;
`;
const CardBody = styled.div`
  height: 92px;
  margin: 16px 0;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;
const HoverThumbnail = styled.div`
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: linear-gradient(0deg, rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1));
`;
const HoverInfo = styled.div`
  position: absolute;
  top: 20px;
  right: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 40px;

  background: rgba(248, 247, 247, 0.8);
  border: 1px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;

  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
`;
const Line = styled.div`
  width: 62px;
  height: 1px;
  margin: 8px 0;
  background: #1b1b1b;
`;
const Title = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
`;
const SmallTitle = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: #3f3f3f;
`;
const Descript = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: #777777;
`;
const Price = styled.div`
  display: flex;
  align-items: center;
`;
const OriginPrice = styled.div`
  margin-left: 8px;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: #bcbcbc;
  text-decoration-line: line-through;
`;
const DiscountPrice = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
`;
const Badges = styled.div`
  display: flex;
  height: 30px;
`;
const Badge = styled.div`
  margin-right: 8px;
  padding: 6px 16px;
  border-radius: 999px;
  background: ${props => props.background};
  text-align: center;
  font-weight: 500;
  font-size: 12px;
  line-height: 18px;
  color: #ffffff;
`;

export default Card;
