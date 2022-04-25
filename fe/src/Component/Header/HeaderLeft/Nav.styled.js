import styled from "styled-components";

const StyledNav = styled.nav`
  font-family: "Noto Sans KR";
  ${({ theme: { regularFonts } }) => regularFonts.medium}

  margin-left: 40px;
`;

export default StyledNav;
