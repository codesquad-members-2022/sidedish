import {createGlobalStyle} from 'styled-components';
import reset from 'styled-reset';
import {Header, SpecialPromotion, SideDishContents} from 'containers';

const GlobalStyles = createGlobalStyle`
  ${reset}
  font-family: 'Noto Sans KR';
  font-style: normal;
  button:hover{
    cursor:pointer;
  }
`;

function App() {
  return (
    <div className="App">
      <GlobalStyles />
      <Header />
      <SpecialPromotion />
      <SideDishContents />
    </div>
  );
}

export default App;
