import styled from 'styled-components';
import { applyFlex } from '../../../../helper/utils';

export const ImgWrapper = styled.div`
  ${({ flex, direction }) => applyFlex(flex, direction)}
  width:392px;
  cursor: pointer;
`;
