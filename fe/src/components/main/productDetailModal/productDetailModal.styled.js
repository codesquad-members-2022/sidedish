import styled from 'styled-components';
import { applyFlex } from '../../../helper/utils';

export const DimLayer = styled.div`
  position: fixed;
  width: 100%;
  height: 100%;
  left: 0px;
  top: 0px;
  background: rgba(1, 1, 1, 0.4);
`;

export const ModalContainer = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 960px;
  height: 596px;
  background-color: #fff;
  padding: 76px 48px 48px 48px;
  border: 1px solid #1b1b1b;
`;
