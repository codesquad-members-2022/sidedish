const calcPx = (size) => `${size}px`;
const fontSizes = {
  XLarge: calcPx(24),
  Large: calcPx(20),
  Medium: calcPx(16),
  Small: calcPx(14),
  XSmall: calcPx(12),
};

const colors = {
  Black: `#1B1B1B`,
  Grey1: `#3F3F3F`,
  Grey2: `#777777`,
  Grey3: `#BCBCBC`,
  Grey4: `#EBEBEB`,
  Off_White: `#F8F7F7`,
  White: `#FFFFFF`,
  Green: `#6DD028`,
  Orange: `#FF8E14`,
};
const fontWeights = {
  Bold: 500,
  Regular: 400,
};
const heights = {
  XLarge: calcPx(36),
  Large: calcPx(30),
  Medium: calcPx(26),
  Small: calcPx(24),
  XSmall: calcPx(18),
};
const fontFamily = {
  Outfit: "Outfit",
  NotoSans: "Noto Sans KR",
};

export const theme = {
  fontSizes,
  colors,
  fontWeights,
  heights,
  fontFamily,
  custom_font: (family = "Noto Sans KR", size, weight, height, spacing) => `
        font-family:${family};
        font-size:${size}px;
        font-style: normal;
        font-weight: ${weight};
        font-size: ${size}px;
        line-height: ${height}px;
        letter-spacing:${spacing}em;
    `,
  custom_absolute: (top = null, right = null, bottom = null, left = null) => `
        position:absolute;
        ${top ? `top:${top}px` : ""};
        ${left ? `left:${left}px` : ""};
        ${right ? `right:${right}px` : ""};
        ${bottom ? `bottom:${bottom}px` : ""};
    `,
  custom_static: (top = null, right = null, bottom = null, left = null) => {
    return `
        ${theme.custom_absolute(top, right, bottom, left)}
        position:static;    
   `;
  },
  custom_relative: (top = null, right = null, bottom = null, left = null) => `
        ${theme.custom_absolute(top, right, bottom, left)};
        position:relative;
    `,
  flex_none: (order, mx, my) => `
        flex: none;
        flex-grow: 0;
        order: ${order};
        margin:${mx}px ${my}px;
    `,
  width_height_bypx: (width = null, height = null) => `
        ${width ? `width: ${width}px` : ""};
        ${height ? `height: ${height}px` : ""};
    `,
  custom_flex: (dir = "column", align = null, justify = null) => `
        display: flex;
        ${dir ? `flex-direction: ${dir}` : ""};
        ${align ? `align-items: ${align}` : ""};
        ${justify ? `justify-content: ${justify}` : ""};
    `,
};
