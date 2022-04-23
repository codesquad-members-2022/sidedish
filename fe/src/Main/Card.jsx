import { useState } from 'react';
import styled, { css } from 'styled-components';
import CardDeliveryInfo from 'Main/CardDeliveryInfo';

const CardItem = styled.div`
  margin-right: 24px;
  cursor: pointer;
`;

const CardImgWrapper = styled.div`
  position: relative;
`;

const CardItemImg = styled.img`
  background: ${({ theme }) => theme.colors.gray3};
  ${({ imageSize }) => {
    switch (imageSize) {
      case 'large':
        return css`
          ${({ theme }) => theme.cardSize.large}
        `;
      case 'medium':
        return css`
          ${({ theme }) => theme.cardSize.medium}
        `;
      case 'small':
        return css`
          ${({ theme }) => theme.cardSize.small}
        `;
      default:
        return;
    }
  }}
`;

const CardItemInfo = styled.div`
  margin: 16px 0;
  .item__title {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__desc {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.gray2};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }

  .item__default-price {
    margin-right: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__normal-price {
    text-decoration-line: line-through;
    color: ${({ theme }) => theme.colors.gray3};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }
`;

const CardItemTag = styled.p`
  display: inline-block;
  padding: 6px 16px;
  border-radius: 999px;
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
      default:
        return;
    }
  }};
  ${({ theme }) => theme.fontStyles.smallBold};
`;

const Card = ({ item, imageSize }) => {
  const [hover, setHover] = useState(false);
  const setPrice = (price) => Number(price).toLocaleString();

  const onMouseOver = () => setHover(true);

  const onMouseOut = () => setHover(false);

  return (
    <CardItem>
      <CardImgWrapper onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
        <CardItemImg key={item.id} src={item.img} imageSize={imageSize}></CardItemImg>
        <CardDeliveryInfo infos={item.deliveryType} hover={hover}></CardDeliveryInfo>
      </CardImgWrapper>
      <CardItemInfo>
        <p className="item__title">{item.title}</p>
        <p className="item__desc">{item.desc}</p>
        {item.salePrice ? (
          <>
            <span className="item__default-price">{setPrice(item.salePrice)}원</span>
            <span className="item__normal-price">{setPrice(item.normalPrice)}원</span>
          </>
        ) : (
          <span className="item__default-price">{setPrice(item.normalPrice)}원</span>
        )}
      </CardItemInfo>
      {item.tag ? <CardItemTag tag={item.tag}>{item.tag}</CardItemTag> : ''}
    </CardItem>
  );
};

export default Card;
