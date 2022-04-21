import { gnbMenus, gnbSubMenus, icons } from '../helper/constants.js';
import { useState } from 'react';
import {
  GnbMenu,
  GnbSubMenu,
  GnbSubMenuWrapper,
  StyledDiv,
  StyledH1,
  StyledHeader,
  StyledInnerDiv,
  StyledSvgWrapper,
  StyledUl,
} from '../styles/Header.js';

function Svg({ icons, useIconsName }) {
  return useIconsName.map((iconName, idx) => <StyledSvgWrapper key={idx}>{icons[iconName]}</StyledSvgWrapper>);
}

function GnbLists(props) {
  const { isSubMenuOpen, gnbMenus, gnbSubMenus } = props;

  function handleMouseEnterSubMenu(e) {
    e.target.style.textDecoration = 'underline';
    e.target.style.color = '#1e88e5';
  }

  function handleMouseLeaveSubMenu(e) {
    e.target.style.textDecoration = 'none';
    e.target.style.color = '#000';
  }

  if (isSubMenuOpen) {
    return gnbMenus.map((v, i) => (
      <GnbMenu key={i}>
        {v}
        <GnbSubMenuWrapper>
          {gnbSubMenus[i].map((v, i) => (
            <GnbSubMenu
              key={i}
              onMouseEnter={handleMouseEnterSubMenu}
              onMouseLeave={handleMouseLeaveSubMenu}
              className="gnbSubMenu"
            >
              {v}
            </GnbSubMenu>
          ))}
        </GnbSubMenuWrapper>
      </GnbMenu>
    ));
  }

  return gnbMenus.map((v, i) => (
    <GnbMenu key={i} onMouseEnter={props.onMouseEnter}>
      {v}
    </GnbMenu>
  ));
}

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
        ></GnbLists>
      </StyledUl>
      <StyledDiv>
        <StyledInnerDiv flex align="center">
          <Svg icons={icons} useIconsName={['search', 'mypage', 'shoppingCart']}></Svg>
        </StyledInnerDiv>
      </StyledDiv>
    </StyledHeader>
  );
}

export default Header;
