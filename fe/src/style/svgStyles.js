import { css } from "styled-components";

const svgStyles = ({ height, width }) => {
  return css`
    height: ${height};
    width: ${width};
    cursor: pointer;
  `;
};

export default svgStyles;
