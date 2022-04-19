import React from "react";
import styled from "styled-components";
import { GlobalStyles, colors } from "./globalStyles";

const Title = styled.span`
  color: ${(props) => props.fontColor};
`;

function App() {
  return (
    <div className="App">
      <GlobalStyles />
      <Title fontColor={colors.fontWhite}>Hello</Title>
    </div>
  );
}

export default App;
