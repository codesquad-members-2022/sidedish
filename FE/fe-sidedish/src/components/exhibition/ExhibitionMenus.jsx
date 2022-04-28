import * as S from './Exhibition.style';

import Card from '../card/Card';

const LARGE = 'large';

const ExhibitionMenus = ({ menus }) => {
  const menuItems = menus.map(dish => (
    <li key={dish.menuId}>
      <Card cardSize={LARGE} dish={dish} />
    </li>
  ));

  return <S.MenuList>{menuItems}</S.MenuList>;
};

export default ExhibitionMenus;
