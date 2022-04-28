import styled from 'styled-components';
import { applyFlex } from '../../../../helper/utils';

export function ExtendBtn({ onClick, buttonState }) {
  return (
    <StyledBtn flex justify="center" align="center" onClick={onClick}>
      모든 카테고리 {buttonState}
    </StyledBtn>
  );
}

const StyledBtn = styled.div`
  width: 200px;
  height: 60px;
  ${({ flex, justify, align }) => applyFlex({ flex, justify, align })}
  font-weight: 400;
  font-size: 20px;
  line-height: 30px;
  color: #3f3f3f;
  border: 1px solid #ebebeb;
  box-sizing: border-box;
  margin-left: 600px;
  margin-bottom: 50px;
  cursor: pointer;
`;
