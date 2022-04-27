import styled, { css } from "styled-components";

const CARD_SIZE = {
  width: css`
    ${({ theme: { cardSize } }) => cardSize.small.width}
  `,
  margin: css`
    ${({ theme: { cardSize } }) => cardSize.small.margin}
  `,
};

const Wrapper = styled.div`
  position: relative;
  ${({ theme: { center, padding } }) =>
    css`
      max-width: calc(
        (${padding.large} * 2) + (${CARD_SIZE.margin} * 3) +
          (${CARD_SIZE.width} * 4)
      );
      margin: ${center.margin};
    `};
`;

const CategoryWrapper = styled.div`
  padding: ${({ theme: { padding } }) => `${padding.middle} ${padding.large}`};
`;

const Title = styled.p`
  ${({ theme: { boldFonts } }) => boldFonts.xLarge}
`;

export { Wrapper, CategoryWrapper, Title };
