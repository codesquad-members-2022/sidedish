import React, { useState } from 'react';
import styled from 'styled-components';
import Badges from './Badges';

function Card({ size, item, showModal }) {
  const { id, image, title, contents, origin_price, discount_price, early_delivery, badge_title } = item;
  const [isHover, setIsHover] = useState(false);

  function showDelevery() {
    setIsHover(true);
  }
  function hideDelevery() {
    setIsHover(false);
  }
  return (
    <StyledCard key={id} cardSize={size} onClick={() => showModal(id)}>
      <Thumbnail cardSize={size} onMouseEnter={showDelevery} onMouseLeave={hideDelevery}>
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
          <Badges badge_title={badge_title} />
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

const StyledCard = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: ${({ theme, cardSize }) => theme.cardSizes[cardSize].width}px;
  height: ${({ theme, cardSize }) => theme.cardSizes[cardSize].height}px;
`;
const Thumbnail = styled.div`
  position: relative;
  height: ${({ theme, cardSize }) => theme.cardSizes[cardSize].width}px;
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
  border: 1px solid ${({ theme }) => theme.colors.black};
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
  background: ${({ theme }) => theme.colors.black};
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
  color: ${({ theme }) => theme.colors.gray1};
`;
const Descript = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: ${({ theme }) => theme.colors.gray2};
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
  color: ${({ theme }) => theme.colors.gray3};
  text-decoration-line: line-through;
`;
const DiscountPrice = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
`;

export default Card;
