import { GnbMenu, GnbSubMenu, GnbSubMenuWrapper } from './Header.styled';

export function GnbLists(props) {
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
