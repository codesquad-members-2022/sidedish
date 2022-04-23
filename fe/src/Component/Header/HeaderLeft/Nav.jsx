import PropTypes from "prop-types";
import Menu from "./Menu";
import StyledNav from "./Nav.styled";

const Nav = ({ state: { handleMouseEvent, checkIsOpen } }) => {
  return (
    <StyledNav onMouseEnter={handleMouseEvent} onMouseLeave={handleMouseEvent}>
      <Menu isOpen={checkIsOpen()} />
    </StyledNav>
  );
};

Nav.propTypes = {
  state: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default Nav;
