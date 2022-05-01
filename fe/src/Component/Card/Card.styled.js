import styled, { css } from "styled-components";

const CardLi = styled.li`
  ${({ theme: { colors, cardSize, boldFonts, regularFonts }, type }) => {
    return css`
      position: relative;
      width: ${cardSize[type].width};
      height: ${cardSize[type].height};
      cursor: pointer;

      img {
        display: block;
        width: ${cardSize[type].width};
        height: ${cardSize[type].width};
      }

      .name {
        ${boldFonts.medium}
        margin-top: 16px;
        color: ${colors.black};
      }

      .desc {
        ${regularFonts.small}
        margin-top: 8px;
        color: ${colors.grey2};
      }
    `;
  }}
`;

const CardImage = styled.img`
  ${({ isHover }) => {
    return css`
      opacity: ${isHover && 50}%;
    `;
  }}
`;

const CardFlag = styled.div`
  ${({
    theme: { colors },
    flag: { dawnDeliveryFlag, wholeNationDeliveryFlag },
    isHover,
  }) => {
    return css`
      background: rgba(248, 247, 247, 0.8);
      display: flex;
      flex-direction: column;
      align-items: center;
      position: absolute;
      width: 140px;
      height: 140px;
      border: 1px solid ${colors.black};
      border-radius: 140px;
      top: 20px;
      right: 20px;

      ${!isHover &&
      css`
        visibility: hidden;
      `}

      > div {
        height: 50%;
      }

      > :nth-child(1) {
        ${!dawnDeliveryFlag &&
        css`
          visibility: hidden;
        `};
        line-height: 100px;
        border-bottom: solid 0.5px ${colors.black};
      }

      > :nth-child(2) {
        ${!wholeNationDeliveryFlag &&
        css`
          visibility: hidden;
        `};
        line-height: 40px;
        border-top: solid 0.5px ${colors.black};
      }
    `;
  }}
`;

const CardPriceDiv = styled.div`
  ${({ theme: { colors, regularFonts, boldFonts } }) => css`
    margin-top: 8px;
    > :nth-child(1) {
      ${boldFonts.medium};
      color: ${colors.black};
      margin-right: 10px;
    }
    > :nth-child(2) {
      ${regularFonts.small}
      color: ${colors.grey3};
      text-decoration: line-through;
    }
  `}
`;

export { CardLi, CardImage, CardFlag, CardPriceDiv };
