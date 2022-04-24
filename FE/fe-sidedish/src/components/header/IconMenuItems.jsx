import { Link } from "react-router-dom";
import { IconMenu } from "./Header.style";
import { ReactComponent as SearchIcon } from "../../asset/icons/search.svg";
import { ReactComponent as MyPageIcon } from "../../asset/icons/mypage.svg";
import { ReactComponent as CartIcon } from "../../asset/icons/cart.svg";

const IconMenuItems = ({ iconMenusData }) => {
  return iconMenusData.map(_getIconMenu);
};

const _getIconMenu = ({ id, name }) => (
  <IconMenu key={id}>
    <Link to="#">
      {name}
      {_getIcon(name)}
    </Link>
  </IconMenu>
);

const _getIcon = (name) => {
  const SEARCH = "검색";
  const MYPAGE = "마이페이지";
  const CART = "장바구니";

  if (name === SEARCH) return <SearchIcon />;
  if (name === MYPAGE) return <MyPageIcon />;
  if (name === CART) return <CartIcon />;
};

export default IconMenuItems;
