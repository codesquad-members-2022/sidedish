import React from "react";
import styled from "styled-components";
import PropTypes from "prop-types";
import Text from "./Text";

export default function TabButton(props) {
  const { value } = props;
  return (
    <Wrap>
      <Text size="LARGE" value={value} />
    </Wrap>
  );
}

TabButton.propTypes = {
  value: PropTypes.string,
};

TabButton.defaultProps = {
  value: "",
};

const Wrap = styled.div({
  width: "fit-content",
  height: "48px",
});
