import styled from "styled-components";
import { custom_flex, custom_font } from "../styles/global";

const MenuWrapper = styled.li`
  ${custom_flex("column", "flex-start")}
  margin: 0px 12px;
`;

const Title = styled.span`
  ${custom_font("Noto Sans KR", 16, 400, 26, -0.008)}
  color: ${({ theme }) => theme.colors.Black};
`;

const Sub = styled.span`
  ${custom_font("Noto Sans KR",16,400,24)}
  color: ${({ theme }) => theme.colors.Black};
  margin-top: 8px;
`;

export const GnbMenu = ({ id, name, subcategories, extended }) => {
  return (
    <MenuWrapper>
      <Title>{name}</Title>
      {extended &&
        subcategories.map((cat) => <Sub key={id}>{cat}</Sub>)}
    </MenuWrapper>
  );
};
