import React from "react";
import styled from "styled-components";
import Main from "components/Main";

const Header = styled.header`
  width: 100vw;
  height: 300px;
  border-bottom: 1px solid black;
  margin-bottom: 30px;
`;

function App() {
  return (
    <>
      <Header>네비게이션바</Header>
      <Main />
      <div className="Modal"></div>
    </>
  );
}

export default App;
