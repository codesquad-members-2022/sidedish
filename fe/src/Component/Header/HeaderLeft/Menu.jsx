import PropTypes from "prop-types";
import { MenuDatas } from "../../../MockData/MockData";
import { MainMenuUl, SubMenuUl } from "./Menu.Styled";

const SubMenu = ({ subMenuDatas }) => {
  const subMenuList = subMenuDatas.map((subMenuData) => (
    <li key={subMenuData.id}>{subMenuData.name}</li>
  ));

  return <SubMenuUl>{subMenuList}</SubMenuUl>;
};

const Menu = ({ isOpen }) => {
  const MainMenuList = MenuDatas.map(({ id, name, subMenu }) => (
    <li key={id}>
      {name}
      {isOpen && <SubMenu subMenuDatas={subMenu} />}
    </li>
  ));

  return <MainMenuUl>{MainMenuList}</MainMenuUl>;
};

Menu.propTypes = {
  isOpen: PropTypes.bool.isRequired,
};

SubMenu.propTypes = {
  subMenuDatas: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
    })
  ).isRequired,
};

export default Menu;
