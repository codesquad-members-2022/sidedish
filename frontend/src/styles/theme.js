import {css} from "styled-components";

const calcPx = size=>`${size}px`;
 const fontSizes = {
    XLarge: calcPx(24),
    Large:calcPx(20),
    Medium:calcPx(16),
    Small:calcPx(14),
    XSmall:calcPx(12)

};

 const Colors={
     Black:`#1B1B1B`,
     Grey1:`#3F3F3F`,
     Grey2:`#777777`,
     Grey3:`#BCBCBC`,
     Grey4:`#EBEBEB`,
     Off_White:`#F8F7F7`,
     White:`#FFFFFF`,
     Green:`#6DD028`,
     Orange:`#FF8E14`,
 };
 const fontWeights={
    Bold:500,
    Regular:400,
};
 const heights={
    XLarge:calcPx(36),
    Large:calcPx(30),
    Medium:calcPx(26),
    Small:calcPx(24),
    XSmall:calcPx(18),
};
 const fontFamily = {
    Outfit:'Outfit',
    NotoSans:'Noto Sans KR',
};
export const theme = {
    fontSizes,
    Colors,
    fontWeights,
    heights,
    fontFamily
}
export const Ordering = css`
  font-family: 'Outfit';
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  color: #1B1B1B;
`
export const Logo = css`
  font-family: 'Outfit';
  font-style: normal;
  font-weight: 600;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
  color: #1B1B1B;
`
export const Typography = css`
  font-family: 'Outfit';
  font-style: normal;
  font-weight: 600;
  font-size: 40px;
  line-height: 58px;
  letter-spacing: -0.004em;
  color: #1B1B1B;
`;