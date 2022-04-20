import styled from 'styled-components';

import colors from '../constants/colors';
import { fonts } from '../constants/fonts';

const Text = styled.span`
  font-weight: ${({ font }) => (font ? fonts[font].fontWeight : 400)};
  font-size: ${({ font }) => (font ? fonts[font].fontSize : '16px')};
  line-height: ${({ font }) => (font ? fonts[font].lineHeight : '26px')};
  letter-spacing: ${({ font }) => (font ? fonts[font].letterSpacing : '-0.004em;')};
  color: ${({ textColor }) => textColor || colors.black};
`;

export default Text;
