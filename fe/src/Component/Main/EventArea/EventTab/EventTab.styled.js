import styled, { css } from "styled-components";

const EventTabUl = styled.ul`
  ${({ theme: { center, boldFonts } }) => css`
    ${center}
    ${boldFonts.large};
  `}

  ${({ id, theme: { colors } }) =>
    id &&
    css`
      > :nth-child(${id}) {
        border-bottom: 2px solid ${colors.black};
      }
    `}

  font-family: "Noto Sans KR";
  display: flex;
  margin-top: 24px;

  > li {
    padding-bottom: 16px;

    &:not(:last-child) {
      margin-right: 32px;
    }

    :hover {
      ${({ theme: { colors } }) => css`
        border-bottom: 2px solid ${colors.grey3};
      `}
    }
  }
`;

export default EventTabUl;
