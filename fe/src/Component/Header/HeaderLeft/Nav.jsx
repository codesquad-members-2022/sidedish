import PropTypes from "prop-types";
import Menu from "./Menu";
import { StyledNav, StyledUl } from "./Nav.styled";

const Nav = ({ state: { handleMouseEvent, checkIsOpen } }) => {
  return (
    <StyledNav>
      <StyledUl>
        <Menu state={{ handleMouseEvent, checkIsOpen }} />
      </StyledUl>
    </StyledNav>
  );
};

Nav.propTypes = {
  state: PropTypes.objectOf(PropTypes.func).isRequired,
};

export default Nav;
