import { StyledLi } from './BestProduct.styled';

export function TapMenu(props) {
  if (!props.menus) {
    return ``;
  }

  return props.menus.map(menu => (
    <StyledLi
      data-menu-id={menu.id}
      key={menu.id}
      onMouseEnter={e => props.onMouseEnter(e)}
      onMouseLeave={e => props.onMouseLeave(e)}
      curTap={props.curTap}
      onClick={e => props.onClick(e, props.setCurTap)}
    >
      {menu.title}
    </StyledLi>
  ));
}
