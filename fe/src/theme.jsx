const layout = {
  /** 
    // TODO flex Layout 공통 컴포넌트 분리
  */
};

const colors = {
  black: '#1B1B1B',
  gray1: '#3F3F3F',
  gray2: '#777777',
  gray3: '#BCBCBC',
  gray4: '#EBEBEB',
  offWhite: '#F8F7F7',
  white: '#FFFFFF',
  green: '#6DD028',
  orange: '#FF8E14',
};

const fontSizes = {
  font40: '40px',
  font24: '24px',
  font20: '20px',
  font16: '16px',
  font14: '14px',
  font12: '12px',
};

const fontStyles = {
  logo: {
    fontWeight: 900,
    fontSize: '40px',
  },
  display: {
    fontWeight: 700,
    fontSize: '40px',
  },
  xLargeBold: {
    fontWeight: 500,
    fontSize: '24px',
    lineHeight: '38px',
  },
  largeRegular: {
    fontWeight: 400,
    fontSize: '20px',
    lineHeight: '30px',
  },
  largeBold: {
    fontWeight: 500,
    fontSize: '20px',
    lineHeight: '30px',
  },
  mediumRegular: {
    fontWeight: 400,
    fontSize: '16px',
    lineHeight: '26px',
  },
  mediumBold: {
    fontWeight: 500,
    fontSize: '16px',
    lineHeight: '26px',
  },
  smallRegular: {
    fontWeight: 400,
    fontSize: '14px',
    lineHeight: '24px',
  },
  smallBold: {
    fontWeight: 500,
    fontSize: '14px',
    lineHeight: '24px',
  },
  xSmallRegular: {
    fontWeight: 400,
    fontSize: '12px',
    lineHeight: '18px',
  },
  xSmallBold: {
    fontWeight: 500,
    fontSize: '12px',
    lineHeight: '18px',
  },
};

const cardSize = {
  large: { width: '412px', height: '412px' },
  medium: { width: '302px', height: '302px' },
  small: { width: '160px', height: '160px' },
};

const theme = { layout, colors, fontSizes, cardSize, fontStyles };

export default theme;
