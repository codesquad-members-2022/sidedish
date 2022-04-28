import PropTypes from "prop-types";
import Button from "./SliderButton.styled";

const SliderButton = ({ info: { inner, type }, isClickable, onClick }) => {
  return (
    <Button className={type} isClickable={isClickable} onClick={onClick}>
      {inner}
    </Button>
  );
};

SliderButton.propTypes = {
  info: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.bool, PropTypes.node])
  ).isRequired,
  isClickable: PropTypes.bool.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default SliderButton;
