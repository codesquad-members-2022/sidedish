import styled from "styled-components";
import { custom_font, custom_flex } from "../styles/global";
import { useState } from "react";
import { Categories } from "../types";

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
`;

const GnbMenu = styled.div<{ extended: boolean }>`
  margin: 28px;
  ${custom_flex(`row`, `flex-start`, `center`)}
  ${(props) => props.extended && `margin-bottom: 40px;`}
`;

export const Gnb = ({ categories }: Categories) => {
  const [extended, setExtended] = useState(false);
  return (
    <GnbMenu
      onMouseEnter={() => setExtended(true)}
      onMouseLeave={() => setExtended(false)}
      extended={extended}
      data-cy="headerMenu"
    >
      {categories.map((cat) => (
        <MenuWrapper key={cat.id}>
          <Title>{cat.name}</Title>
          {extended &&
            cat.subcategories.map((sub) => (
              <Sub data-cy="subMenu" key={sub.id}>
                {sub.name}
              </Sub>
            ))}
        </MenuWrapper>
      ))}
    </GnbMenu>
  );
};
