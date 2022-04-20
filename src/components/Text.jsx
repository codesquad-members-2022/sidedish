import React from "react";
import styled from "styled-components";
import PropTypes from "prop-types";
import { SIZE, WEIGHT } from "../variable/font";
import COLOR from "../variable/color";

function Text(props) {
  const { size, weight, color, value } = props;
  return (
    <SPAN size={size} weight={weight} color={color}>
      {value}
    </SPAN>
  );
}

Text.propTypes = {
  size: PropTypes.string,
  weight: PropTypes.string,
  color: PropTypes.string,
  value: PropTypes.string,
};

Text.defaultProps = {
  size: SIZE.BASE,
  weight: WEIGHT.REGULAR,
  color: COLOR.BLACK,
  value: "",
};

const SPAN = styled.span({
  "font-size": (props) => SIZE[props.size],
  "font-weight": (props) => WEIGHT[props.weight],
  color: (props) => COLOR[props.color],
});

export default Text;
