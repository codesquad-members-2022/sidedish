import PropTypes from "prop-types";
import Menu from "./Menu";
import StyledNav from "./Nav.styled";

const Nav = ({ state: { handleMouseEvent, checkIsOpen } }) => {
  return (
    <StyledNav>
      <Menu state={{ handleMouseEvent, checkIsOpen }} />
    </StyledNav>
  );
};

Nav.propTypes = {
  state: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default Nav;
