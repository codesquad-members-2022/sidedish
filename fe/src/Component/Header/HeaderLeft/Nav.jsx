import PropTypes from "prop-types";
import Menu from "Component/Header/HeaderLeft/Menu";
import StyledNav from "Component/Header/HeaderLeft/Nav.styled";

const Nav = ({ state: { handleMouseEvent, isOpen } }) => {
  return (
    <StyledNav onMouseEnter={handleMouseEvent} onMouseLeave={handleMouseEvent}>
      <Menu isOpen={isOpen} />
    </StyledNav>
  );
};

Nav.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.bool])
  ).isRequired,
};

export default Nav;
