import MainTheme from './MainTheme/Theme.jsx';
import HeaderTemplate from './Header/HeaderTemplate';
import GlobalStyles from './GlobalStyles.jsx';

function App() {
  return (
    <>
      <GlobalStyles />
      <HeaderTemplate></HeaderTemplate>
      <MainTheme></MainTheme>
    </>
  );
}

export default App;
