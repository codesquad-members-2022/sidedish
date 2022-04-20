import styled from "styled-components";
import { Reset } from "styled-reset";
import Header from "./Header.js";
import MainTab from "./MainTab.js";

function App() {
  return (
    <>
      <Reset />
      <Header />
      <main>
        <MainTab />
      </main>
    </>
  );
}

export default App;
