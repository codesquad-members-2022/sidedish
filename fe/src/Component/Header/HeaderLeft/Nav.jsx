import PropTypes from "prop-types";
import Menu from "./Menu";
import StyledNav from "./Nav.styled";

const Nav = ({ state: { handleMouseEvent, isSubMenuOpen } }) => {
  return (
    <StyledNav onMouseEnter={handleMouseEvent} onMouseLeave={handleMouseEvent}>
      <Menu isOpen={isSubMenuOpen} />
    </StyledNav>
  );
};

Nav.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.bool])
  ).isRequired,
};

export default Nav;
