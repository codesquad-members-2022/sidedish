import PropTypes from "prop-types";
import styled, { css } from "styled-components";

const BtnShowAndHideWrapper = styled.div`
  text-align: center;
`;

const BtnShowAndHide = styled.button`
  ${({ theme: { regularFonts, colors } }) =>
    css`
      ${regularFonts.large};
      border: solid 2px ${colors.grey4};
    `}
  font-family: "Noto Sans KR", sans-serif;
  width: 203px;
  height: 62px;
  margin: 20px 0;
`;

const BtnShowAndHideArea = ({ state: { showing, setShowing } }) => {
  const handleBtnClick = () => {
    setShowing(!showing);
  };

  const btnText = showing ? "카테고리 숨기기" : "모든 카테고리 보기";
  return (
    <BtnShowAndHideWrapper>
      <BtnShowAndHide
        type="button"
        onClick={handleBtnClick}
        onKeyUp={handleBtnClick}
      >
        {btnText}
      </BtnShowAndHide>
    </BtnShowAndHideWrapper>
  );
};

BtnShowAndHideArea.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.bool])
  ).isRequired,
};

export default BtnShowAndHideArea;
