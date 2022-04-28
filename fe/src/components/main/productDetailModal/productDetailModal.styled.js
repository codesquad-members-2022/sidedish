import styled from 'styled-components';
import { applyFlex } from '../../../helper/utils';

export const DimLayer = styled.div`
  ${({ flex, direction }) => applyFlex({ flex, direction })}
  position: fixed;
  width: 100%;
  height: 100%;
  left: 0px;
  top: 0px;
  background: rgba(1, 1, 1, 0.4);
`;

export const ProductArea = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  padding-bottom:50px;
  border-bottom: 1px solid #1b1b1b;
`;

export const ModalArea = styled.div`
  ${({ flex, direction }) => applyFlex({ flex, direction })}
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 960px;
  height: 992px;
  background-color: #fff;
  padding: 76px 48px 48px 48px;
  border: 1px solid #1b1b1b;
`;
