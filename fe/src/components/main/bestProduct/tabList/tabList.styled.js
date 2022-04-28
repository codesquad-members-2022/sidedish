import styled from 'styled-components';
import { applyFlex } from '../../../../helper/utils';

export const StyledDiv = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  margin-top: 34px;
  padding: 0 80px;
`;
