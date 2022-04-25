import styled, { css } from "styled-components";

const EventTabUl = styled.ul`
  font-family: "Noto Sans KR";
  font-size: 20px;
  font-weight: 500;
  line-height: 30px;
  display: flex;
  margin-top: 24px;
  > li {
    padding-bottom: 16px;
    &:not(:last-child) {
      margin-right: 32px;
    }
    :hover {
      border-bottom: 2px solid #1b1b1b;
    }
  }
  ${({ id }) =>
    id &&
    css`
      > :nth-child(${id}) {
        border-bottom: 2px solid #1b1b1b;
      }
    `}
`;

export default EventTabUl;
