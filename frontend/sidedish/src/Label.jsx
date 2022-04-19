import styled from "styled-components";

export const Label = ({ string, color, fontSize, backgroundColor, borderColor, padding }) => {
  const Label = styled.div`
    display: inline-block;
    background-color: ${backgroundColor};
    padding: ${padding};
    border: 2px solid ${borderColor};
    box-sizing: border-box;
    border-radius: 999px;
  `;

  const LabelText = styled.div`
    color: ${color};
    font-size: ${fontSize};
  `;

  return (
    <Label>
      <LabelText>{string}</LabelText>
    </Label>
  );
};
