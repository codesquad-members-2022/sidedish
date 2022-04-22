import PropTypes from "prop-types";
import { MenuDatas } from "../../../MockData/MockData";
import SubMenuUl from "./Menu.Styled";

const SubMenu = ({ subMenuDatas }) => {
  const subMenuList = subMenuDatas.map((subMenuData) => (
    <li key={subMenuData.id}>{subMenuData.name}</li>
  ));

  return <SubMenuUl>{subMenuList}</SubMenuUl>;
};

const Menu = ({ state: { handleMouseEvent, checkIsOpen } }) => {
  const subMenuContents = (subMenu) => {
    return checkIsOpen() ? <SubMenu subMenuDatas={subMenu} /> : null;
  };

  return MenuDatas.map(({ id, name, subMenu }) => (
    <li
      key={id}
      onMouseEnter={handleMouseEvent}
      onMouseLeave={handleMouseEvent}
    >
      {name}
      {subMenuContents(subMenu)}
    </li>
  ));
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
