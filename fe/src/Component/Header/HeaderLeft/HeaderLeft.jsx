import PropTypes from "prop-types";
import Nav from "./Nav";
import NavArea from "./HeaderLeft.styled";

const HeaderLeft = ({ state: { handleMouseEvent, checkIsOpen } }) => {
  return (
    <NavArea>
      <h1>Ordering</h1>
      <Nav state={{ handleMouseEvent, checkIsOpen }} />
      {/* TODO: submenu를 이 위치로 옮기기 */}
    </NavArea>
  );
};

HeaderLeft.propTypes = {
  state: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default HeaderLeft;
