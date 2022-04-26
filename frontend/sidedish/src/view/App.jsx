import GlobalStyle from "./GlobalStyle";
import Header from "./header/Header";
import BigSidedish from "./sidedish/BigSidedish";
import SmallSidedish from "./sidedish/SmallSidedish";

function App() {
    return (
        <>
            <GlobalStyle />
            <Header />
            <BigSidedish />
            <SmallSidedish />
        </>
    );
}

export default App;
