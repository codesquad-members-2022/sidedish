import { gnbMenus, gnbSubMenus, icons } from '../helper/constants.js';
import { GnbLists } from './header/gnbLists.js';
import { Svg } from './header/svg.js';
import { useState } from 'react';
import { StyledDiv, StyledH1, StyledHeader, StyledInnerDiv, StyledUl } from './header/Header.styled.js';

function Header() {
  const [isSubMenuOpen, setisSubMenuOpen] = useState(false);

  return (
    <StyledHeader
      flex
      onMouseLeave={() => {
        setisSubMenuOpen(false);
      }}
      className="Header"
    >
      <StyledH1>Ordering</StyledH1>
      <StyledUl flex>
        <GnbLists
          gnbMenus={gnbMenus}
          gnbSubMenus={gnbSubMenus}
          isSubMenuOpen={isSubMenuOpen}
          onMouseEnter={() => {
            setisSubMenuOpen(true);
          }}
        />
      </StyledUl>
      <StyledDiv>
        <StyledInnerDiv flex align="center">
          <Svg icons={icons} useIconsName={['search', 'mypage', 'shoppingCart']} />
        </StyledInnerDiv>
      </StyledDiv>
    </StyledHeader>
  );
}

export default Header;
