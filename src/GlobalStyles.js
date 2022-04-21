import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";
import COLOR from "./variable/color";
import { SIZE } from "./variable/font";

const GlobalStyles = createGlobalStyle`
  ${reset}
  html {
    font: 400 14px/1.4 "Noto Sans KR", sans-serif;
  }
  .App {
    font: inherit;
  }
  html,
  body,
  div,
  span,
  applet,
  object,
  iframe,
  h1,
  h2,
  h3,
  h4,
  h5,
  h6,
  p,
  blockquote,
  pre,
  a,
  abbr,
  acronym,
  address,
  big,
  cite,
  code,
  del,
  dfn,
  em,
  img,
  ins,
  kbd,
  q,
  s,
  samp,
  small,
  strike,
  strong,
  sub,
  sup,
  tt,
  var,
  b,
  u,
  i,
  center,
  dl,
  dt,
  dd,
  ol,
  ul,
  li,
  fieldset,
  form,
  label,
  legend,
  table,
  caption,
  tbody,
  tfoot,
  thead,
  tr,
  th,
  td,
  article,
  aside,
  canvas,
  details,
  embed,
  figure,
  figcaption,
  footer,
  header,
  hgroup,
  menu,
  nav,
  output,
  ruby,
  section,
  summary,
  time,
  mark,
  audio,
  video {
    margin: 0;
    padding: 0;
    border: 0;
    font-family: inherit;
    font-size: 100%;
    font-weight: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
  }
  article,
  aside,
  details,
  figcaption,
  figure,
  footer,
  header,
  hgroup,
  menu,
  nav,
  section {
    display: block;
  }
  body {
    width: 100%;
    font-family: 'NotoSans', sans-serif;
    font-size: ${SIZE.BASE};
    line-height: 1.15;
    color: ${COLOR.BLACK};
    letter-spacing: -0.4px;
  }
  ol,
  ul {
    list-style: none;
  }
  blockquote,
  q {
    quotes: none;
  }
  blockquote:before,
  blockquote:after,
  q:before,
  q:after {
    content: '';
    content: none;
  }
  input,
  select,
  button,
  textarea {
    margin: 0;
    padding: 0;
    vertical-align: middle;
    font-family: 'NotoSans', sans-serif;
    font-size: 17px;
    font-weight: 400;
    color: #1b2529;
    background: none;
    border: 0;
    outline: none;
    border-radius: 0;
    box-shadow: none;
    -webkit-appearance: none;
    -ms-appearance: none;
    appearance: none;
    box-sizing: border-box;
  }
  input,
  select,
  textarea {
    display: block;
  }
  table {
    border-collapse: collapse;
    border-spacing: 0;
  }
  img {
    display: block;
    max-width: 100%;
    border: 0;
  }
  button {
    border: 0;
    outline: none;
    cursor: pointer;
  }
  i,
  em,
  address {
    font-style: normal;
  }
  u {
    text-decoration: none;
  }
  a {
    font: inherit;
    color: inherit;
    text-decoration: none;
  }
  a:hover {
    text-decoration: none;
  }
`;

export default GlobalStyles;
