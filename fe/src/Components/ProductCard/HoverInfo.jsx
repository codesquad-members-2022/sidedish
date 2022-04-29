import styled from 'styled-components';

import { Colors } from '@/Constants';

const HoverInfoWrapper = styled.div`
  position: absolute;
  top: 20px;
  right: 20px;
  border: 1px solid black;
  padding: 40px 42px;
  border-radius: 999px;
  background-color: ${Colors.OFF_WHITE};
  opacity: 0;
  z-index: 2;
  transition: opacity 150ms;

  .separator {
    border: 0;
    border-bottom: 1px solid ${Colors.BLACK};
    margin: 8px 0;
  }
`;

export const HoverInfo = () => {
  return (
    <HoverInfoWrapper className={'fonts-md-bold hover-info'}>
      <p>새벽 배송</p>
      <hr className={'separator'} />
      <p>전국 택배</p>
    </HoverInfoWrapper>
  );
};
