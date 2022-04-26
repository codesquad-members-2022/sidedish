import styled from "styled-components";

const RightArrowBtn = ({ clickEventHandler, isLast }) => {
  return (
    <Button onClick={clickEventHandler} isLast={isLast}>
      <svg width="11" height="20" viewBox="0 0 11 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M2 18L10 10L2 2" stroke="#1B1B1B" strokeWidth="2" strokeLinecap="square" strokeLinejoin="round" />
      </svg>
    </Button>
  );
};

const Button = styled.button`
  background-color: #fff;
  border-style: none;
  cursor: ${(props) => (props.isLast ? "default" : "pointer")};
  opacity: ${(props) => (props.isLast ? "30%" : "100%")};
`;

export default RightArrowBtn;
