import styled from "styled-components";

const StyledUl = styled.ul`
  display: flex;

  li {
    cursor: pointer;

    &:not(:last-child) {
      margin-right: 24px;
    }
  }
`;

const StyledNav = styled.nav`
  font-family: "Noto Sans KR";
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  margin-left: 40px;
`;

export { StyledUl, StyledNav };
