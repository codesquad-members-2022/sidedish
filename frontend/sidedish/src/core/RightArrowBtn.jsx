import styled from "styled-components";
import { ReactComponent as RightIcon } from "../asset/rightIcon.svg";

const RightArrowBtn = ({ clickEventHandler, isLast }) => {
  return (
    <Button onClick={clickEventHandler} isLast={isLast}>
      <RightIcon />
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
