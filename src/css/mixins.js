import { css } from 'styled-components';
import { fontSize } from './variables';

const flexCenter = css`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const flexBetween = css`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
`;

const basicText = css`
  display: block;
  margin-top: 10px;
  font-size: ${fontSize.l};
`;

export { flexCenter, flexBetween, basicText };
