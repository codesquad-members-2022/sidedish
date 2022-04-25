import { GnbMenu, GnbSubMenu, GnbSubMenuWrapper } from './Header.styled';

export function GnbLists({ isSubMenuOpen, gnbMenus, gnbSubMenus, onMouseEnter }) {
  function handleMouseEnterSubMenu(e) {
    e.target.style.textDecoration = 'underline';
    e.target.style.color = '#1e88e5';
  }

  function handleMouseLeaveSubMenu(e) {
    e.target.style.textDecoration = 'none';
    e.target.style.color = '#000';
  }

  if (isSubMenuOpen) {
    return gnbMenus.map((gnbMenu, menuIdx) => (
      <GnbMenu key={`${gnbMenu}-${menuIdx}`}>
        {gnbMenu}
        <GnbSubMenuWrapper>
          {gnbSubMenus[menuIdx].map((gnbSubMenu, subMenuIdx) => (
            <GnbSubMenu
              key={`${gnbSubMenu}-${subMenuIdx}`}
              onMouseEnter={handleMouseEnterSubMenu}
              onMouseLeave={handleMouseLeaveSubMenu}
            >
              {gnbSubMenu}
            </GnbSubMenu>
          ))}
        </GnbSubMenuWrapper>
      </GnbMenu>
    ));
  }

  return gnbMenus.map((gnbMenu, menuIdx) => (
    <GnbMenu key={`${gnbMenu}-${menuIdx}`} onMouseEnter={onMouseEnter}>
      {gnbMenu}
    </GnbMenu>
  ));
}
