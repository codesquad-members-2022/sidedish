import { Link } from 'react-router-dom';

import * as S from './Header.style';

import { ReactComponent as SearchIcon } from '../../asset/icons/search.svg';
import { ReactComponent as MyPageIcon } from '../../asset/icons/mypage.svg';
import { ReactComponent as CartIcon } from '../../asset/icons/cart.svg';

const IconMenus = ({ iconMenusData }) => {
  return <S.IconMenuList>{iconMenusData.map(_getIconMenu)}</S.IconMenuList>;
};

const _getIconMenu = ({ id, name }) => (
  <S.IconMenu key={id}>
    <Link to='#'>
      {name}
      {_getIcon(name)}
    </Link>
  </S.IconMenu>
);

const _getIcon = name => {
  const SEARCH = '검색';
  const MYPAGE = '마이페이지';
  const CART = '장바구니';

  if (name === SEARCH) return <SearchIcon />;
  if (name === MYPAGE) return <MyPageIcon />;
  if (name === CART) return <CartIcon />;
};

export default IconMenus;
