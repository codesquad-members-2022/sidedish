import styled, { css } from 'styled-components';

const Root = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 10px;
`;

const Image = styled.div`
  ${({ size }) => {
    return size === 'big'
      ? css`
          width: 411px;
          height: 411px;
        `
      : null;
  }};
`;

const Title = styled.span`
  display: block;
  margin-top: 12px;
  padding: 4px 0px;
`;

const Description = styled.span`
  display: block;
  padding: 4px 0px;
`;

const Price = styled.span`
  display: block;
  padding: 4px 0px;
`;

export const ProductCard = ({
  title,
  description,
  price,
  image,
  size,
  isSale,
}) => {
  return (
    <Root>
      <Image size={size}>
        <img
          src={
            'https://www.chuksannews.co.kr/data/photos/20210937/art_16316674227272_0aee8d.jpg'
          }
        />
      </Image>
      <Title>{title}</Title>
      <Description>{description}</Description>
      <Price>{price}</Price>
      {/* {isSale && <Badge />} */}
    </Root>
  );
};
