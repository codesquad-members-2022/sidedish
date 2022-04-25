import styled, { css } from "styled-components";

const EventWrapper = styled.div`
  > * {
    padding: 0 ${({ theme: { padding } }) => padding.large};
  }
  padding-top: 56px;
`;

const EventTitle = styled.div`
  font-family: "Noto Sans KR";
  display: flex;
  align-items: center;
  vertical-align: middle;

  .logo {
    ${({ theme: { boldFonts, colors } }) => css`
      ${boldFonts.medium};
      background-color: ${colors.offwhite};
    `};
    padding: 6px 14px;
    margin-right: 16px;
    border: black solid 2px;
    border-radius: 100px;
  }
`;

export { EventWrapper, EventTitle };
