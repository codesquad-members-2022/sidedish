import styled from "styled-components";
import { ReactComponent as LeftIcon } from "../asset/leftIcon.svg";

const LeftArrowBtn = ({ clickEventHandler, isLast }) => {
  return (
    <Button onClick={clickEventHandler} isLast={isLast}>
      <LeftIcon />
    </Button>
  );
};

const Button = styled.button`
  background-color: #fff;
  border-style: none;
  cursor: ${(props) => (props.isLast ? "default" : "pointer")};
  opacity: ${(props) => (props.isLast ? "30%" : "100%")};
`;

export default LeftArrowBtn;
