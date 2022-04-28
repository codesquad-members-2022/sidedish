import "styled-components";

export type themeColors = {
  Black: string;
  Grey1: string;
  Grey2: string;
  Grey3: string;
  Grey4: string;
  Off_White: string;
  White: string;
  Green: string;
  Orange: string;
};

declare module "styled-components" {
  export interface DefaultTheme {
    fontSizes: {
      XLarge: string;
      Large: string;
      Medium: string;
      Small: string;
      XSmall: string;
    };
    colors: themeColors;
    fontWeights: {
      Bold: number;
      Regular: number;
    };
    heights: {
      XLarge: string;
      Large: string;
      Medium: string;
      Small: string;
      XSmall: string;
    };
    fontFamily: {
      Outfit: string;
      NotoSans: string;
    };
  }
}
