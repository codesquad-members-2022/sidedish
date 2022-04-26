import styled from "styled-components";

const Popup = styled.div`
  box-sizing: border-box;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 96rem;
  height: 99.4rem;
  background-color: ${({ theme }) => theme.color.white};
  border: 0.2rem solid ${({ theme }) => theme.color.black};
  z-index: 2;
`;

export { Popup };
