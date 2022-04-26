import styled from "styled-components";
import { custom_absolute, custom_flex, width_height_bypx } from "../styles/global";
import { useState } from "react";
import { GnbMenu } from "./GnbMenu";
import { Logo } from "../icons/Logo";
import { HorizontalLine } from "./HorizontalLine";
import { headerIcons } from "../icons/headerIcons";

const HeaderWrapper = styled.header`
  position: relative;
  width: 1440px;
  min-height: 83px;
  display: flex;
  background: ${({ theme }) => theme.colors.White};
`;

const HeaderLogoWrapper = styled.div`
  margin: 16px 0px 0px 80px;
  height: 50px;
  ${custom_flex('row', 'center')}
`;

const HeaderLogo = () => (
  <HeaderLogoWrapper>
    <Logo />
  </HeaderLogoWrapper>
);

const GNB = styled.div`
  margin: 28px;
  ${custom_flex(`row`, `flex-start`, `center`)}
  ${(props) => props.extended && `margin-bottom: 40px;`}
`;

const IconWrapper = styled.div`
  ${custom_flex("row", "center", "space-between")}
  ${custom_absolute(25, 80)}
  ${width_height_bypx(128)}
`;

const Icon = styled.div`
  ${custom_flex("row", "center", "center")}
  ${width_height_bypx(32, 32)}
`;

export const Header = ({ cats }) => {
  const [extended, setExtended] = useState(false);

  return (
    <HeaderWrapper>
      <HeaderLogo />
      <GNB onMouseEnter={() => setExtended(true)} onMouseLeave={() => setExtended(false)} extended={extended}>
        {cats.map((cat, index) => (
          <GnbMenu key={index} {...cat} extended={extended}></GnbMenu>
        ))}
      </GNB>
      <IconWrapper>
        <Icon>{headerIcons.SearchIcon()}</Icon>
        <Icon>{headerIcons.MyPageIcon()}</Icon>
        <Icon>{headerIcons.ShoppingCartIcon()}</Icon>
      </IconWrapper>
      <HorizontalLine position={100} color={"Black"} />
    </HeaderWrapper>
  );
};
