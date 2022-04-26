import React from "react";
import { ReactComponent as leftIcon } from "../../asset/leftIcon.svg";
import { ReactComponent as rightIcon } from "../../asset/rightIcon.svg";
import svgStyles from "../../style/svgStyles";
import styled from "styled-components";

const LeftIcon = styled(leftIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  top: 40%;
  left: 20px;
  color: ${(props) =>
    props.current === props.min
      ? props.theme.colors.grey3
      : props.theme.colors.black};
`;

const RightIcon = styled(rightIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  top: 40%;
  left: 1330px;
  color: ${(props) =>
    props.current === props.max
      ? props.theme.colors.grey3
      : props.theme.colors.black};
`;

const SlideIcon = ({ onClickRightBtn, onClickLeftBtn, current, min, max }) => {
  return (
    <>
      <LeftIcon onClick={onClickLeftBtn} current={current} min={min} />
      <RightIcon onClick={onClickRightBtn} current={current} max={max} />
    </>
  );
};

export default SlideIcon;
