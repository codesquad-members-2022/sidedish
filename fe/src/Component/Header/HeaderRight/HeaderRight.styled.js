import styled from "styled-components";

const ButtonWrap = styled.div`
  display: flex;
  align-items: center;

  button:not(:last-child) {
    margin-right: 20px;
  }
`;

export default ButtonWrap;
