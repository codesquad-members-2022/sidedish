import styled from "styled-components";
import { custom_font, custom_flex } from "../styles/global";
import { useState } from "react";

const MenuWrapper = styled.li`
  ${custom_flex("column", "flex-start")}
  margin: 0px 12px;
`;

const Title = styled.span`
  ${custom_font("Noto Sans KR", 16, 400, 26, -0.008)}
  color: ${({ theme }) => theme.colors.Black}
`;

const Sub = styled.span`
  ${custom_font("Noto Sans KR", 16, 400, 24)}
  color: ${({ theme }) => theme.colors.Black};
  margin-top: 8px;
  ${custom_font("Noto Sans KR", 14, 400, 24)}
  color: ${({ theme }) => theme.colors.Black}
`;
const GnbMenu = styled.div`
  margin: 28px;
  ${custom_flex(`row`, `flex-start`, `center`)}
  ${(props) => props.extended && `margin-bottom: 40px;`}
`;

export const Gnb = ({ categories }) => {
  const [extended, setExtended] = useState(false);
  return (
    <GnbMenu
      onMouseEnter={() => setExtended(true)}
      onMouseLeave={() => setExtended(false)}
      extended={extended}
    >
      {categories.map((cat) => (
        <MenuWrapper key={cat.id}>
          <Title>{cat.name}</Title>
          {extended &&
            cat.subcategories.map((sub) => <Sub key={sub.id}>{sub}</Sub>)}
        </MenuWrapper>
      ))}
    </GnbMenu>
  );
};
