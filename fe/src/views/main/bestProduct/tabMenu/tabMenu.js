import { TabMenuLi } from '../BestProduct.styled';

export function TabMenu(props) {
  if (!props.menus) {
    return ``;
  }
  return props.menus.map(menu => (
    <TabMenuLi
      data-menu-id={menu.categoryId}
      key={menu.categoryId}
      onMouseEnter={e => props.onMouseEnter(e)}
      onMouseLeave={e => props.onMouseLeave(e)}
      curTab={props.curTab}
      onClick={e => props.onClick(e, props.setCurTab)}
    >
      {menu.categoryTitle}
    </TabMenuLi>
  ));
}
