import styled from "styled-components";

const MainMenuUl = styled.ul`
  display: flex;
  cursor: pointer;

  li:not(:last-child) {
    margin-right: 24px;
  }
`;

const SubMenuUl = styled.ul`
  font-family: "Noto Sans KR";
  ${({ theme: { regularFonts } }) => regularFonts.small}
  padding-top: 15px;
  position: absolute;

  li:hover {
    color: #ff8e14;
    text-decoration: underline;
  }
`;

export { MainMenuUl, SubMenuUl };
