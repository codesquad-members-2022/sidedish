import styled from "styled-components";

const Label = ({ string, color, fontSize, backgroundColor, borderColor, padding }) => {
  return (
    <LabelBox backgroundColor={backgroundColor} borderColor={borderColor} padding={padding}>
      <LabelText color={color} fontSize={fontSize}>
        {string}
      </LabelText>
    </LabelBox>
  );
};

const LabelBox = styled.div`
  display: inline-block;
  background-color: ${(props) => props.backgroundColor};
  padding: ${(props) => props.padding};
  border: 2px solid ${(props) => props.borderColor};
  box-sizing: border-box;
  border-radius: 999px;
`;

const LabelText = styled.div`
  color: ${(props) => props.color};
  font-size: ${(props) => props.fontSize};
`;

export default Label;
