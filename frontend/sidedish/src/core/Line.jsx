import styled from "styled-components";

const DivisionLine = ({ color, height }) => {
  return <Line {...{ color, height }} />;
};

const Line = styled.hr`
  width: 100%;
  color: ${(props) => props.color};
  height: ${(props) => props.height}px;
`;

export default DivisionLine;
