import styled from "styled-components";

export const DeliveryServiceHoverContainer = styled.div`
  display: none;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  /* TODO: figma 값을 그대로 복사했는데 매직넘버는 다시 고려해보기 */
  width: 150px;
  height: 150px;
  top: 20px;
  right: 20px;
  background: rgba(248, 247, 247, 0.8);
  border: 1px solid ${({ theme: { color } }) => color.black};
  box-sizing: border-box;
  border-radius: 50%;
  span {
    color: ${({ theme: { color } }) => color.black};
    font-size: ${({ theme: { fontSize } }) => fontSize.medium};
    font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
    margin: 8px 0;
  }
`;

export const Card = styled.li`
  position: relative;
  display: flex;
  flex-direction: column;
  align-self: flex-start;
  img {
    width: ${({ imageSize }) => imageSize}px;
    height: ${({ imageSize }) => imageSize}px;
  }
  &:hover ${DeliveryServiceHoverContainer} {
    display: flex;
  }
`;

export const SpanDivider = styled.div`
  width: 50%;
  height: 1px;
  background-color: ${({ theme: { color } }) => color.black};
`;

export const CardInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  h4 {
    color: ${({ theme: { color } }) => color.grey1};
    font-size: ${({ theme: { fontSize } }) => fontSize.medium};
    font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
    margin: 8px 0px;
  }
  p {
    color: ${({ theme: { color } }) => color.grey2};
    font-size: ${({ theme: { fontSize } }) => fontSize.small};
    font-weight: ${({ theme: { fontWeight } }) => fontWeight.regular};
    margin: 8px 0px;
  }
`;

export const PriceContainer = styled.div`
  margin: 8px 0px;
  span {
    &:first-child {
      color: ${({ theme: { color } }) => color.black};
      font-size: ${({ theme: { fontSize } }) => fontSize.medium};
      font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
    }
    &:last-child {
      margin: 0px 8px;
      color: ${({ theme: { color } }) => color.grey3};
      font-size: ${({ theme: { fontSize } }) => fontSize.small};
      font-weight: ${({ theme: { fontWeight } }) => fontWeight.regular};
      letter-spacing: -0.008em;
      text-decoration-line: line-through;
    }
  }
`;

export const DiscoutType = styled.div`
  margin: 10px 0px;
  width: 76px;
  height: 30px;
  border-radius: 20px;
  /* TODO: switch 문으로 바꾸기(분기처리에서 추가 속성이 추가될 수 있기 때문) */
  background-color: ${({ theme: { color }, isLaunchingDiscount }) =>
    isLaunchingDiscount ? color.orange : color.green};
  color: ${({ theme: { color } }) => color.white};
  font-size: ${({ theme: { fontSize } }) => fontSize.xSmall};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  text-align: center;
  line-height: 30px;
`;
