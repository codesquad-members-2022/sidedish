import styled from "styled-components";

const MinusImg = ({ handler }) => {
  return (
    <>
      <Button onClick={handler}>
        <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M9 16H23" stroke="#1B1B1B" strokeWidth="2" strokeLinecap="square" strokeLinejoin="round" />
        </svg>
      </Button>
    </>
  );
};

const Button = styled.div`
  cursor: pointer;
`;

export default MinusImg;
