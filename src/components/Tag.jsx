import React from "react";
import styled from "styled-components";
import PropTypes from "prop-types";
import Text from "./Text";
import COLOR from "../variable/color";

export default function Tag(props) {
  const { type } = props;
  return (
    <PillShape type={type}>
      <Text size="SMALL" color="WHITE" value={type} />
    </PillShape>
  );
}

Tag.propTypes = {
  type: PropTypes.string,
};

Tag.defaultProps = {
  type: "이벤트특가",
};

function getColorByType(type) {
  if (type === "이벤트특가") {
    return COLOR.GREEN;
  }
  if (type === "런칭특가") {
    return COLOR.ORANGE;
  }
  throw new Error("태그의 타입이 올바르지 않습니다.");
}

const PillShape = styled.div({
  width: "fit-content",
  padding: "6px 16px 6px 16px",
  "border-radius": "15px",
  "background-color": (props) => getColorByType(props.type),
});
