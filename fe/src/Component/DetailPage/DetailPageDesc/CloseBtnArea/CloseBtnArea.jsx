import PropTypes from "prop-types";
import { CloseBtn, CloseBtnDiv } from "./CloseBtnArea.styled";

const CloseBtnArea = ({ onClose }) => {
  return (
    <CloseBtnDiv>
      <CloseBtn type="button" onClick={onClose}>
        닫기
      </CloseBtn>
    </CloseBtnDiv>
  );
};

CloseBtnArea.propTypes = {
  onClose: PropTypes.func.isRequired,
};

export default CloseBtnArea;
