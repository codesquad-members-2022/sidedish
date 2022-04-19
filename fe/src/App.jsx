import { Header } from './Header';
import styled from 'styled-components';

const HeaderWrapper = styled.header`
  width: 1440px;
  padding: 16px 80px;
  border-bottom: 1px solid #000;
`;

function App() {
  return (
    <>
      <HeaderWrapper>
        <Header />
      </HeaderWrapper>
    </>
  );
}

export default App;
