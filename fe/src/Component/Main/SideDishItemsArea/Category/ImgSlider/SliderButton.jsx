import PropTypes from "prop-types";
import Button from "./SliderButton.styled";

const SliderButton = ({ info: { inner, type }, isClickable, onClick }) => {
  return (
    // 버튼 색상뿐 아니라 누르는 것도 안되게 해야??
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
