import { createGlobalStyle, css } from "styled-components";
import styled from "styled-components";

export const Search = styled.svg`
  position: absolute;
  left: 12.5%;
  right: 14.62%;
  top: 12.5%;
  bottom: 14.62%;
  color: ${({ theme }) => theme.colors.Black};
`;
export const MyPage = styled.svg`
  position: absolute;
  left: 16.67%;
  right: 16.67%;
  top: 16.67%;
  bottom: 16.67%;
  color: ${(props) => props.color};
`;
export const ShoppingCart = styled.svg`
  position: absolute;
  left: 4.17%;
  right: 12.5%;
  top: 8.33%;
  bottom: 8.33%;
  color: ${(props) => props.theme.colors.Black};
`;
export const Left = styled.svg`
  position: absolute;
  left: 37.5%;
  right: 37.5%;
  top: 25%;
  bottom: 25%;
  border: 2px solid ${(props) => props.color};
`;

export const Right = styled.svg`
  position: absolute;
  left: 37.5%;
  right: 37.5%;
  top: 25%;
  bottom: 25%;
  border: 2px solid ${(props) => props.color};
`;
export const Minus = styled.svg`
  position: absolute;
  left: 28.12%;
  right: 28.12%;
  top: 50%;
  bottom: 50%;
  border: 2px solid ${(props) => props.color};
`;
export const Plushorizontal = styled.svg`
  position: absolute;
  left: 28.12%;
  right: 28.12%;
  top: 50%;
  bottom: 50%;
  border: 2px solid ${(props) => props.color};
`;
export const Plusvertical = styled.svg`
  position: absolute;
  left: 50%;
  right: 50%;
  top: 28.12%;
  bottom: 28.12%;
  border: 2px solid ${(props) => props.color};
`;
export const GlobalStyle = createGlobalStyle`
  html, body, div, span, applet, object, iframe,
  h1, h2, h3, h4, h5, h6, p, blockquote, pre,
  a, abbr, acronym, address, big, cite, code,
  del, dfn, em, img, ins, kbd, q, s, samp,
  small, strike, strong, sub, sup, tt, var,
  b, u, i, center,
  dl, dt, dd, ol, ul, li,
  fieldset, form, label, legend,
  table, caption, tbody, tfoot, thead, tr, th, td,
  article, aside, canvas, details, embed,
  figure, figcaption, footer, header, hgroup,
  menu, nav, output, ruby, section, summary,
  time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
  }

  /* HTML5 display-role reset for older browsers */
  article, aside, details, figcaption, figure,
  footer, header, hgroup, menu, nav, section {
    display: block;
  }

  body {
    line-height: 1;
    position: relative;
    width: 1440px;
    height: 2844px;
    background: #FFFFFF;
  }

  ol, ul {
    list-style: none;
  }

  blockquote, q {
    quotes: none;
  }

  blockquote:before, blockquote:after,
  q:before, q:after {
    content: '';
    content: none;
  }

  table {
    border-collapse: collapse;
    border-spacing: 0;
  }
`;
export const Ordering = css`
  font-family: "Outfit";
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  color: #1b1b1b;
`;
export const Logo = css`
  font-family: "Outfit";
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
  color: #1b1b1b;
`;
export const Typography = css`
  font-family: "Outfit";
  font-style: normal;
  font-weight: 600;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
  color: #1b1b1b;
`;
