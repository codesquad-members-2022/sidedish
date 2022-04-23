import PropTypes from "prop-types";
import Nav from "./Nav";
import NavArea from "./HeaderLeft.styled";

const HeaderLeft = ({ state }) => {
  return (
    <NavArea>
      <h1>Ordering</h1>
      <Nav state={state} />
    </NavArea>
  );
};

HeaderLeft.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.bool])
  ).isRequired,
};

export default HeaderLeft;
